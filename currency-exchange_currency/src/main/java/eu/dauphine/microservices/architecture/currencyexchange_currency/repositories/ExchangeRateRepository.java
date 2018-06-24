package eu.dauphine.microservices.architecture.currencyexchange_currency.repositories;

import eu.dauphine.microservices.architecture.currencyexchange_currency.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

}
