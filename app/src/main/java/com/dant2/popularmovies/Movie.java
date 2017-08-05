package com.dant2.popularmovies;

/**
 * Model for movie objects
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

    public Movie(String name, String releaseDate, String plotSummary, int rating, String poster) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.plotSummary = plotSummary;
        this.rating = rating;
        this.poster = poster;
    }

    String releaseDate;
    String plotSummary;
    int rating;

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    String poster;




}
