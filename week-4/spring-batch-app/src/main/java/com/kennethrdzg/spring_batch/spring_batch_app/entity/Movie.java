package com.kennethrdzg.spring_batch.spring_batch_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TMDB_INFO")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {
	@Id
	@Column(name = "MovieID")
	private int id;

	@Column(name = "Title")
	private String title;

	@Column(name = "Release_Date")
	private String releaseDate;

	@Column(name = "Original_Language")
	private String originalLanguage;

	@Column(name = "Vote_Average")
	private double score;

	@Column(name = "Budget")
	private double budget;

	@Column(name = "Revenue")
	private double revenue;
}
