package eu.dauphine.microservices.architecture.currencyexchange_currency.repositories;

import eu.dauphine.microservices.architecture.currencyexchange_currency.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

}