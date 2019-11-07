package pl.tdd.vod.notification;

import pl.tdd.vod.customers.CustomerID;
import pl.tdd.vod.movies.MovieID;

public interface NotificationFacade {
    void allowStreaming(CustomerID customerID, MovieID movieId);
}
