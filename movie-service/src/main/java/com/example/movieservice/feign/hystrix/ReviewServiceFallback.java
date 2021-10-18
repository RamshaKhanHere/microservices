package com.example.movieservice.feign.hystrix;

import com.example.movieservice.feign.ReviewsFeignClient;
import com.example.movieservice.model.MovieReview;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;
import java.util.Collections;

/**
 * Fallback class used for feign client, in case the hystrix circuit breaks
 */
@Component
public class ReviewServiceFallback implements ReviewsFeignClient {

    @Override
    public CollectionModel<MovieReview> getMovieReviews(Long movieId) {
        return new CollectionModel<>(Collections.emptyList());
    }
}
