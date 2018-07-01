package eu.dauphine.microservices.architecture.currencyexchange_currency.repositories;

import eu.dauphine.microservices.architecture.currencyexchange_currency.model.ExchangeRate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    @Query("SELECT e FROM ExchangeRate e WHERE e.currencySource.symbol = :from AND e.currencyDestination.symbol = :to ORDER BY e.exchangeDate DESC")
    Page<ExchangeRate> findByFromAndTo(@Param("from") String from, @Param("to") String to, Pageable pageable);

    @Query("SELECT e FROM ExchangeRate e WHERE e.currencySource.symbol = :from AND e.currencyDestination.symbol = :to ORDER BY e.exchangeDate ASC")
    List<ExchangeRate> findListByFromAndTo(@Param("from") String from, @Param("to") String to);

}
