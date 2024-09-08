package com.kennethrdzg.springRestJPA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name="videogames")
@Data
@AllArgsConstructor
@NoArgsConstructor
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