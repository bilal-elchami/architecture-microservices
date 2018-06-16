package eu.dauphine.microservices.architecture.currencyexchange.services.interfaces;

import eu.dauphine.microservices.architecture.currencyexchange.model.Transaction;

import java.util.List;

public interface ITransactionService {

    List<Transaction> findAll();
    Transaction findById(Long id) throws Exception;
    Transaction addTransaction(Transaction transaction) throws Exception;
    void deleteTransaction(Long id);

}
