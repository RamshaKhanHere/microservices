package com.example.movieservice.feign.hystrix;

import com.example.movieservice.feign.ReviewsFeignClient;
import com.example.movieservice.model.MovieReview;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * Fallback class used for feign client, in case the hystrix circuit breaks
 * This allows access to the underlying exception that broke the circuit
 */
@Component
public class ReviewServiceFallbackFactory implements FallbackFactory<ReviewsFeignClient> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReviewServiceFallbackFactory.class);


    @Override
    public ReviewsFeignClient create(Throwable throwable) {
        return new ReviewsFeignClient() {
            @Override
            public CollectionModel<MovieReview> getMovieReviews(Long movieId) {
                LOGGER.error("Error occurred trying to fetch reviews from review service", throwable);
                return new CollectionModel<>(Collections.emptyList());
            }
        };
    }
}
