package com.example.movieservice.model;
import com.example.movieservice.repository.Movie;
import lombok.Data;

import java.util.Collection;

@Data
public class MovieDTO {
    private Long id;
    private String title;
    private String poster;
    private Collection<MovieReview> reviews;

    public MovieDTO(Movie movie, Collection<MovieReview> reviews) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.poster = movie.getPoster();
        this.reviews = reviews;
    }
}
