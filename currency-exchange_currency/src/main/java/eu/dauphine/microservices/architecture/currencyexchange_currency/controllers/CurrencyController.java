package eu.dauphine.microservices.architecture.currencyexchange_currency.controllers;

import eu.dauphine.microservices.architecture.currencyexchange_currency.model.Currency;
import eu.dauphine.microservices.architecture.currencyexchange_currency.services.interfaces.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    private ICurrencyService currencyService;

    @GetMapping
    public List<Currency> getAllCurrencies() {
        return currencyService.findAll();
    }

    @GetMapping("/{currencyId}")
    public Currency findCurrencyById(@PathVariable Long currencyId) {
        try {
            return currencyService.findById(currencyId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping
    public Currency addCurrency(@RequestBody Currency currency) {
        try {
            return currencyService.addCurrency(currency);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/{currencyId}")
    public String deleteCurrency(@PathVariable Long currencyId) {
        try {
            currencyService.deleteCurrency(currencyId);
            return "OK";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "KO";
    }
}
