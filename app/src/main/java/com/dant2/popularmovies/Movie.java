package com.dant2.popularmovies;

/**
 * Created by jl on 7/30/17.
 */

public class Movie {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPlotSummary() {
        return plotSummary;
    }

    public void setPlotSummary(String plotSummary) {
        this.plotSummary = plotSummary;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    String name;

    public Movie(String name, String releaseDate, String plotSummary, int rating) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.plotSummary = plotSummary;
        this.rating = rating;
    }

    String releaseDate;
    String plotSummary;
    int rating;




}
