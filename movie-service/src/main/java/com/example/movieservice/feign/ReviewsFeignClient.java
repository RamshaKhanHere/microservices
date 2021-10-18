package com.example.movieservice.feign;

import com.example.movieservice.feign.hystrix.ReviewServiceFallbackFactory;
import com.example.movieservice.model.MovieReview;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "review-service", fallbackFactory = ReviewServiceFallbackFactory.class)
public interface ReviewsFeignClient {

    @GetMapping("/reviews/search/findAllByMovieId")
    CollectionModel<MovieReview> getMovieReviews(@RequestParam("movieID") Long  movieId);
}