package eu.dauphine.microservices.architecture.currencyexchange.controllers;

import eu.dauphine.microservices.architecture.currencyexchange.model.Transaction;
import eu.dauphine.microservices.architecture.currencyexchange.services.interfaces.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = transactionService.findAll();
        return transactions;
    }

    @GetMapping("/{transactionId}")
    public Transaction findCustomerById(@PathVariable Long transactionId) {
        try {
            return transactionService.findById(transactionId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        try {
            return transactionService.addTransaction(transaction);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/{transactionId}")
    public String deleteTransaction(@PathVariable Long transactionId) {
        try {
            transactionService.deleteTransaction(transactionId);
            return "OK";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "KO";
    }

}
