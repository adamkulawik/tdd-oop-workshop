package pl.tdd.exercises.vod.notification;

import pl.tdd.exercises.vod.customers.CustomerID;
import pl.tdd.exercises.vod.movies.MovieID;

public interface NotificationFacade {
    void allowStreaming(CustomerID customerID, MovieID movieId);
}
