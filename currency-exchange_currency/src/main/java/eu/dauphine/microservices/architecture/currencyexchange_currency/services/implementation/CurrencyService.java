package eu.dauphine.microservices.architecture.currencyexchange_currency.services.implementation;

import eu.dauphine.microservices.architecture.currencyexchange_currency.model.Currency;
import eu.dauphine.microservices.architecture.currencyexchange_currency.repositories.CurrencyRepository;
import eu.dauphine.microservices.architecture.currencyexchange_currency.services.interfaces.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService implements ICurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }

    @Override
    public Currency findById(Long id) throws Exception {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (!optionalCurrency.isPresent()) {
            throw new Exception("id-" + id);
        }
        return optionalCurrency.get();
    }

    @Override
    public Currency addCurrency(Currency currency) throws Exception {
        return currencyRepository.save(currency);
    }

    @Override
    public void deleteCurrency(Long id) {
        currencyRepository.deleteById(id);
    }
}
