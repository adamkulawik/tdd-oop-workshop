package pl.tdd.vod.transaction;

public interface TransactionRepository {
    void save(TransactionFacade.TransactionId transactionId, TransactionDetails transactionDetails);

    TransactionDetails read(TransactionFacade.TransactionId transactionId);
}
