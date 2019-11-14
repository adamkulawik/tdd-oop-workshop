package pl.tdd.vod.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pl.tdd.exercises.vod.customers.CustomerID;
import pl.tdd.exercises.vod.customers.CustomerStatus;
import pl.tdd.exercises.vod.customers.CustomersFacade;
import pl.tdd.exercises.vod.movies.MovieID;
import pl.tdd.exercises.vod.movies.MovieType;
import pl.tdd.exercises.vod.movies.MoviesFacade;
import pl.tdd.exercises.vod.notification.NotificationFacade;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VodTest {

    private final MovieTestFixtures fixture = new MovieTestFixtures();

    private final NotificationFacade notificationFacade = mock(NotificationFacade.class);
    private final CustomersFacade customersFacade = mock(CustomersFacade.class);
    private final MoviesFacade movieCatalogueFacade = mock(MoviesFacade.class);
    private final TransactionFacade transactionFacade = new TransactionFacade(notificationFacade, customersFacade,movieCatalogueFacade);
    private final CustomerID customerId = fixture.customerId();
    private final MovieID movieID = fixture.movieId();

    @Test
    public void payingForMovieReturnsTranscationId () {
        // when
        when(customersFacade.customerStatus(customerId)).thenReturn(CustomerStatus.VIP);

        TransactionFacade.TransactionId transactionId = transactionFacade.payForMovie(customerId, movieID);

        // then
        assertThat(transactionId).isNotNull();

        // and
        verify(notificationFacade).allowStreaming(customerId, movieID);
    }

    @Test
    public void showTransactionDetailsForGivenIdAndVIpCustomers () {
        // given
        Mockito.when(customersFacade.customerStatus(customerId)).thenReturn(CustomerStatus.VIP);
        // and
        when(movieCatalogueFacade.movieType(movieID)).thenReturn(MovieType.REGULAR);
        // and
        TransactionFacade.TransactionId transactionId = transactionFacade.payForMovie(customerId, movieID);
        // when
        TransactionDetails transactionDetails = transactionFacade.showTransactionDetails(transactionId);

        //then
        assertThat(transactionDetails.getTransactionDate()).isNotNull();
        assertThat(transactionDetails.getCustomerId()).isEqualTo(customerId);
        assertThat(transactionDetails.getMovieId()).isEqualTo(movieID);
        assertThat(transactionDetails.getPrice()).isEqualTo(BigDecimal.valueOf(3));
    }

    @Test
    public void showTransactionDetailsForGivenIdAndRegularCustomers () {
        // given
        when(customersFacade.customerStatus(customerId)).thenReturn(CustomerStatus.REGULAR);
        // and
        when(movieCatalogueFacade.movieType(movieID)).thenReturn(MovieType.REGULAR);

        // and
        TransactionFacade.TransactionId transactionId = transactionFacade.payForMovie(customerId, movieID);

        // when
        TransactionDetails transactionDetails = transactionFacade.showTransactionDetails(transactionId);

        //then
        assertThat(transactionDetails.getTransactionDate()).isNotNull();
        assertThat(transactionDetails.getCustomerId()).isEqualTo(customerId);
        assertThat(transactionDetails.getMovieId()).isEqualTo(movieID);
        assertThat(transactionDetails.getPrice()).isEqualTo(BigDecimal.valueOf(5));
    }

    @Test
    public void showTransactionDetailsForGivenIdAndRegularCustomersPremiere () {
        // given
        when(customersFacade.customerStatus(customerId)).thenReturn(CustomerStatus.REGULAR);
        //
        when(movieCatalogueFacade.movieType(movieID)).thenReturn(MovieType.PREMIERE);
        // and
        TransactionFacade.TransactionId transactionId = transactionFacade.payForMovie(customerId, movieID);

        // when
        TransactionDetails transactionDetails = transactionFacade.showTransactionDetails(transactionId);

        //then
        assertThat(transactionDetails.getTransactionDate()).isNotNull();
        assertThat(transactionDetails.getCustomerId()).isEqualTo(customerId);
        assertThat(transactionDetails.getMovieId()).isEqualTo(movieID);
        assertThat(transactionDetails.getPrice()).isEqualTo(BigDecimal.valueOf(10));
    }
}
