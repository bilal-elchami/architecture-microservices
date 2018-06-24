package eu.dauphine.microservices.architecture.currencyexchange_currency.services.interfaces;

import eu.dauphine.microservices.architecture.currencyexchange_currency.model.Currency;

import java.util.List;

public interface ICurrencyService {
    List<Currency> findAll();
    Currency findById(Long id) throws Exception;
    Currency addCurrency(Currency currency) throws Exception;
    void deleteCurrency(Long id);
}
