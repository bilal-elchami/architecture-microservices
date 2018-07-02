package eu.dauphine.microservices.architecture.currencyexchange_currency.controllers;

import eu.dauphine.microservices.architecture.currencyexchange_currency.model.ExchangeRate;
import eu.dauphine.microservices.architecture.currencyexchange_currency.services.interfaces.IExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exchange-rate")
public class ExchangeRateController {

    @Autowired
    private IExchangeRateService exchangeRateService;

    @GetMapping
    public List<ExchangeRate> getAllExchangeRate() {
        return exchangeRateService.findAll();
    }

    @GetMapping("/{exchangeRateId}")
    public ExchangeRate findExchangeRateById(@PathVariable Long exchangeRateId) {
        try {
            return exchangeRateService.findById(exchangeRateId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping
    public ExchangeRate addExchangeRate(@RequestBody ExchangeRate exchangeRate) {
        try {
            return exchangeRateService.addExchangeRate(exchangeRate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/{exchangeRateId}")
    public String deleteExchangeRate(@PathVariable Long exchangeRateId) {
        String response;
        try {
            exchangeRateService.deleteExchangeRate(exchangeRateId);
            response = "{ \"deleted\": true }";
        } catch (Exception e) {
            e.printStackTrace();
            response = "{ \"deleted\": false }";
        }
        return response;
    }

    @RequestMapping(value="/exchange/from/{from}/to/{to}")
    public ExchangeRate getExchangeRate(@PathVariable String from, @PathVariable String to){
        try {
            return exchangeRateService.findByFromAndTo(from, to);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value="/exchange-rates/from/{from}/to/{to}")
    public List<ExchangeRate> getExchangeRateList(@PathVariable String from, @PathVariable String to){
        try {
            return exchangeRateService.findListByFromAndTo(from, to);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
