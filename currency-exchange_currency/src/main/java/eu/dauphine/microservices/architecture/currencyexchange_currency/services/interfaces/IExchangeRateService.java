package eu.dauphine.microservices.architecture.currencyexchange_currency.services.interfaces;

import eu.dauphine.microservices.architecture.currencyexchange_currency.model.ExchangeRate;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IExchangeRateService {
    List<ExchangeRate> findAll();
    ExchangeRate findById(Long id) throws Exception;
    ExchangeRate addExchangeRate(ExchangeRate exchangeRate) throws Exception;
    void deleteExchangeRate(Long id);
    ExchangeRate findByFromAndTo(String from, String to) throws Exception;
}
