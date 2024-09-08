package com.kennethrdzg.crudJPA.videoGameREST.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="videogames")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VideoGame{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="title")
    private String title;
    
    @Column(name="genre")
    private String genre;
    
    @Column(name="platform")
    private String platform;
    
    @Column(name="release_year")
    private int releaseYear;
    
    @Column(name="developer")
    private String developer;
    
    @Column(name="publisher")
    private String publisher;
    
    @Column(name="score")
    private double score;
	
	@Override
	public String toString() {
		return this.id + ": [Title: " + this.title
				+ ", Genre: " + this.genre + ", Platform: " + this.platform
				+ ", Release Year: " + this.releaseYear + ", Developer: " + this.developer
				+ ", Publisher: " + this.publisher + ", Score: " + this.score
				+ "]";
	}
}