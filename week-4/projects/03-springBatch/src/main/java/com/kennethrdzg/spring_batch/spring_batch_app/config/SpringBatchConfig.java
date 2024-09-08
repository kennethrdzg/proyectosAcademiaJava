package com.kennethrdzg.spring_batch.spring_batch_app.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import com.kennethrdzg.spring_batch.spring_batch_app.entity.Movie;
import com.kennethrdzg.spring_batch.spring_batch_app.repository.MovieRepository;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SpringBatchConfig{
    private MovieRepository movieRepository;

    @Bean
    public FlatFileItemReader<Movie> reader(){
        FlatFileItemReader<Movie> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("src/main/resources/movies.csv"));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }

    public LineMapper<Movie> lineMapper(){
        DefaultLineMapper<Movie> mapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id","title","release_date","vote_average","budget","revenue");

        BeanWrapperFieldSetMapper<Movie> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Movie.class);

        mapper.setLineTokenizer(lineTokenizer);
        mapper.setFieldSetMapper(fieldSetMapper);
        return mapper;
    }

    @Bean
    public MovieProcessor processor(){
        return new MovieProcessor();
    }

    @Bean
    public RepositoryItemWriter<Movie> writer(){
        RepositoryItemWriter<Movie> writer = new RepositoryItemWriter<>();
        writer.setRepository(movieRepository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        // return stepBuilderFactory.get("csv-step").<Movie, Movie>chunk(10)
        //     .reader(reader())
        //     .processor(processor())
        //     .writer(writer())
        //     .build();
        return new StepBuilder("csv-step", jobRepository).<Movie, Movie>chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public Job runJob(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        //  return jobBuilderFactory.get("importMovies")
        //          .flow(step1()).end().build();
        return new JobBuilder("importMovies", jobRepository)
                    .flow(step1(jobRepository, transactionManager)).end().build();
    }

    @Bean
    public TaskExecutor taskExecutor(){
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);
        return asyncTaskExecutor;
    }
}
