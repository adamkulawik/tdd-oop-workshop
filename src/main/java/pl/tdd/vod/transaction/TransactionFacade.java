package pl.tdd.vod.transaction;

import pl.tdd.exercises.vod.customers.CustomerID;
import pl.tdd.exercises.vod.customers.CustomerStatus;
import pl.tdd.exercises.vod.customers.CustomersFacade;
import pl.tdd.exercises.vod.movies.MovieID;
import pl.tdd.exercises.vod.movies.MovieType;
import pl.tdd.exercises.vod.movies.MoviesFacade;
import pl.tdd.exercises.vod.notification.NotificationFacade;

import java.math.BigDecimal;

import static java.time.LocalDateTime.now;
import static java.util.UUID.randomUUID;

public class TransactionFacade {

    private final NotificationFacade notificationFacade;
    private final PriceCalculation priceCalculation = new PriceCalculation();
    private CustomersFacade customersFacade;
    private MoviesFacade movieCatalogueFacade;
    private TransactionRepository repository = new InMemoryTransactionRepository();

    public TransactionFacade(NotificationFacade notificationFacade, CustomersFacade customersFacade, MoviesFacade movieCatalogueFacade) {
        this.notificationFacade = notificationFacade;
        this.customersFacade = customersFacade;
        this.movieCatalogueFacade = movieCatalogueFacade;
    }

    public TransactionId payForMovie(CustomerID customerID, MovieID movieID) {
        CustomerStatus customerStatus = customersFacade.customerStatus(customerID);
        MovieType movieType = movieCatalogueFacade.movieType(movieID);
        BigDecimal price = priceCalculation.calculatePrice(customerStatus, movieType);
        TransactionId transactionId = new TransactionId(randomUUID().toString());
        repository.save(transactionId, new TransactionDetails(now(), customerID, movieID, price));
        notificationFacade.allowStreaming(customerID, movieID);
        return transactionId;
    }

    public TransactionDetails showTransactionDetails(TransactionId transactionId) {
        return repository.read(transactionId);

    }

    public static class TransactionId {
        private final String rawValue;

        public TransactionId(String rawValue) {
            this.rawValue = rawValue;
        }

        public String getRawValue() {
            return rawValue;
        }
    }
}
