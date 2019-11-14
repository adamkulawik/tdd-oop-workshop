package pl.tdd.vod.transaction;

import pl.tdd.exercises.vod.customers.CustomerID;
import pl.tdd.exercises.vod.movies.MovieID;

import java.util.UUID;

import static java.util.UUID.randomUUID;

public class MovieTestFixtures {

    public CustomerID customerId() {
        return new CustomerID(randomUUID().toString());
    }

    public MovieID movieId() {
        return new MovieID(UUID.randomUUID().toString());
    }



}