package com.kennethrdzg.springRestJPA.entity;

import jakarta.persistence.*;

@Entity
@Table (name="videogames")
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
    
    public VideoGame() {
    	
    }
    
    public VideoGame(String title, String genre, String platform, int releaseYear, String developer, String publisher, double score) {
    	this.title = title;
    	this.genre = genre;
    	this.platform = platform;
    	this.releaseYear = releaseYear;
    	this.developer = developer;
    	this.publisher = publisher;
    	this.score = score;
    }
    /*

    // define toString
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
     */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return this.id + ": [Title: " + this.title
				+ ", Genre: " + this.genre + ", Platform: " + this.platform
				+ ", Release Year: " + this.releaseYear + ", Developer: " + this.developer
				+ ", Publisher: " + this.publisher + ", Score: " + this.score
				+ "]";
	}
}