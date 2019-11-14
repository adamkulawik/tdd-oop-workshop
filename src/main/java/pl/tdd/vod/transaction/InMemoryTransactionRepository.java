package pl.tdd.vod.transaction;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class InMemoryTransactionRepository implements TransactionRepository {

    private final Map<TransactionFacade.TransactionId, TransactionDetails> transactions = new ConcurrentHashMap<>();

    @Override
    public void save(TransactionFacade.TransactionId transactionId, TransactionDetails transactionDetails) {
        transactions.put(transactionId, transactionDetails);
    }

    @Override
    public TransactionDetails read(TransactionFacade.TransactionId transactionId) {
        return transactions.get(transactionId);
    }
}
