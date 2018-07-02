package eu.dauphine.microservices.architecture.currencyexchange.controllers;

import eu.dauphine.microservices.architecture.currencyexchange.model.ExchangeRate;
import eu.dauphine.microservices.architecture.currencyexchange.model.Transaction;
import eu.dauphine.microservices.architecture.currencyexchange.services.interfaces.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private Environment environment;

    @Autowired
    private ITransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.findAll();
    }

    @GetMapping("/{transactionId}")
    public Transaction findTransactionById(@PathVariable Long transactionId) {
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
        String response;
        try {
            transactionService.deleteTransaction(transactionId);
            response = "{ \"deleted\": true }";
        } catch (Exception e) {
            e.printStackTrace();
            response = "{ \"deleted\": false }";
        }
        return response;
    }

    private ExchangeRate getExchangeRate(String from, String to) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<ExchangeRate> responseEntity = null;

        String hostname = environment.getProperty("currency_app_hostname")!=null ?
                environment.getProperty("currency_app_hostname") :
                "localhost";

        String url = "http://" + hostname + ":8000" +
                "/exchange-rate/exchange/from/{from}/to/{to}";

        responseEntity = new RestTemplate().getForEntity(url, ExchangeRate.class, uriVariables);
        ExchangeRate exchangeRate = responseEntity.getBody();
        return exchangeRate;
    }

    @RequestMapping(value="/exchange/from/{from}/to/{to}/amount/{amount}")
    public Transaction makeTransaction(@PathVariable String from, @PathVariable String to, @PathVariable double amount) {
        ExchangeRate exchangeRate = getExchangeRate(from, to);
        Transaction transaction = new Transaction(amount,
                exchangeRate.getRate(),
                new Date(),
                exchangeRate.getCurrencySource().getId(),
                exchangeRate.getCurrencyDestination().getId());
        return addTransaction(transaction);
    }

}
