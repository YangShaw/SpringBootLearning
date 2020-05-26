package com.shaw.springbootlogin.model;

import lombok.Data;

@Data
public class MovieAndRating {

    private String movieId;
    private String movieTitle;
    private String releaseDate;
    private Integer rating;

    public MovieAndRating(){

    }

    public MovieAndRating(String movieId, String movieTitle, String releaseDate, Integer rating) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }
}
