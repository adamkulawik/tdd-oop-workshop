package pl.tdd.notification;

import pl.tdd.customers.CustomerID;
import pl.tdd.movies.MovieID;

public interface NotificationFacade {
    void allowStreaming(CustomerID customerID, MovieID movieId);
}
