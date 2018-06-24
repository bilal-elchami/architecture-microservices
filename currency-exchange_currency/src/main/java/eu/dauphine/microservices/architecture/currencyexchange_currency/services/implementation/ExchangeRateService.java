package eu.dauphine.microservices.architecture.currencyexchange_currency.services.implementation;

import eu.dauphine.microservices.architecture.currencyexchange_currency.model.ExchangeRate;
import eu.dauphine.microservices.architecture.currencyexchange_currency.repositories.ExchangeRateRepository;
import eu.dauphine.microservices.architecture.currencyexchange_currency.services.interfaces.IExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExchangeRateService implements IExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Override
    public List<ExchangeRate> findAll() {
        return exchangeRateRepository.findAll();
    }

    @Override
    public ExchangeRate findById(Long id) throws Exception {
        Optional<ExchangeRate> optionalExchangeRate = exchangeRateRepository.findById(id);
        if (!optionalExchangeRate.isPresent()) {
            throw new Exception("id-" + id);
        }
        return optionalExchangeRate.get();
    }

    @Override
    public ExchangeRate addExchangeRate(ExchangeRate exchangeRate) throws Exception {
        return exchangeRateRepository.save(exchangeRate);
    }

    @Override
    public void deleteExchangeRate(Long id) {
        exchangeRateRepository.deleteById(id);
    }

}
