#Video-On Demand Kata

##VOD module

###Step 1 - PoC

Create a API with two methods 
- `TransactionID payForMovie(CustomerID customerID, MovieID movieId)`
- `MovieStream showMovieStream(TransactionID transactionId)`

returning date of transaction, movieId, and a price. Price is fixed to 0 USD at the moment.

> How about persisting data? How to test it? Time to dive into unit and integration test

###Step 2 - Walking skeleton

Send notification to streaming module using `NotificationFacade` interface and method `movieStreamingStarted`

> How to proceed? We don't know what's behind NotificationFacade

###Step 3 - time to charge our customers

Our customers now will pay 5 USD for every movie 

###Step 4 - VIP client

Fetch from CRM module status of the customer. VIP customers will now pay 3 USD.

Data can be fetched from `CustomerFacade` interface, 
method `CustomerStatus customerStatus(CustomerId customerId)`

###Step 5 - Premiere movies

Fetch movie type from Movie Catalogue. Regular customers now will pay 10 USD for premiere movies.

Data can be fetched from `MovieCatalogueFacade` interface, 
method `MovieStatus movieStatus(MovieId movieId)`

###Step 6 - bug alert

VIP customers should pay 2 USD, not 3. 