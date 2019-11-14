package pl.tdd.vod.transaction;

import pl.tdd.exercises.vod.customers.CustomerStatus;
import pl.tdd.exercises.vod.movies.MovieType;

import java.math.BigDecimal;

public class PriceCalculation {
    BigDecimal calculatePrice(CustomerStatus customerStatus, MovieType movieType) {
        return customerStatus.equals(CustomerStatus.VIP)
                ? BigDecimal.valueOf(3)
                : movieType.equals(MovieType.REGULAR)
                    ? BigDecimal.valueOf(5)
                    : BigDecimal.valueOf(10);
    }
}