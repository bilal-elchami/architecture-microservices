package eu.dauphine.microservices.architecture.currencyexchange.services.implementation;

import eu.dauphine.microservices.architecture.currencyexchange.model.Transaction;
import eu.dauphine.microservices.architecture.currencyexchange.repositories.TransactionRepository;
import eu.dauphine.microservices.architecture.currencyexchange.services.interfaces.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Transaction findById(Long id) throws Exception {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (!optionalTransaction.isPresent()) {
            throw new Exception("id-" + id);
        }
        return optionalTransaction.get();
    }

    @Override
    public Transaction addTransaction(Transaction transaction) throws Exception {
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

}
