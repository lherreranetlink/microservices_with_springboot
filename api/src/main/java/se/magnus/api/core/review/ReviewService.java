package se.magnus.api.core.review;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReviewService {

  Mono<Review> createReview(@RequestBody Review body);

  /**
   * Sample usage: "curl $HOST:$PORT/review?productId=1".
   *
   * @param productId Id of the product
   * @return the reviews of the product
   */
  @GetMapping(
    value = "/review",
    produces = "application/json")
  Flux<Review> getReviews(@RequestParam(value = "productId", required = true) int productId);

  Mono<Void> deleteReviews(@RequestParam(value = "productId", required = true)  int productId);

}
