package com.kennethrdzg.jpa.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "budget")
    private double budget;

    @Column(name = "revenue")
    private double revenue;

    @Column(name = "runtime")
    private int runtime;

    @Column(name = "rating")
    private double rating;

    // Constructors
    public Movie(){

    }

    public Movie(String title, LocalDate releaseDate, double budget, double revenue, int runtime, double rating){
        this.title = title;
        this.releaseDate = releaseDate;
        this.budget = budget;
        this.revenue = revenue;
        this.runtime = runtime;
        this.rating = rating;
    }

    // Getters and Setters

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public LocalDate getReleaseDate(){
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate){
        this.releaseDate = releaseDate;
    }

    public double getBuget(){
        return this.budget;
    }

    public void setBudget(double budget){
        this.budget = budget;
    }

    public double getRevenue(){
        return this.revenue;
    }

    public void setRevenue(double revenue){
        this.revenue = revenue;
    }

    public int getRuntime(){
        return this.runtime;
    }

    public void setRuntime(int runtime){
        this.runtime = runtime;
    }

    public double getRating(){
        return this.rating;
    }

    public void setRating(double rating){
        this.rating = rating;
    }

    @Override
    public String toString(){
        return "Movie [ id = " + this.id
        + ", title = " + this.title
        + ", release date = " + this.releaseDate
        + ", budget = " + this.budget
        + ", revenue = " + this.revenue
        + ", runtime = " + this.runtime + " minutes"
        + ", rating = " + this.rating
        + " ]";
    }
}
