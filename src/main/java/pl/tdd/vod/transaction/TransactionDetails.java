package pl.tdd.vod.transaction;

import pl.tdd.exercises.vod.customers.CustomerID;
import pl.tdd.exercises.vod.movies.MovieID;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDetails {
    private LocalDateTime localDateTime;
    private CustomerID customerId;
    private MovieID movieId;
    private BigDecimal price;

    public TransactionDetails(LocalDateTime localDateTime, CustomerID customerId, MovieID movieId, BigDecimal price) {
        this.localDateTime = localDateTime;
        this.customerId = customerId;
        this.movieId = movieId;
        this.price = price;
    }

    public LocalDateTime getTransactionDate() {
        return localDateTime;

    }

    public CustomerID getCustomerId() {
        return customerId;
    }

    public MovieID getMovieId() {
        return movieId;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
