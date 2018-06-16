package eu.dauphine.microservices.architecture.currencyexchange.repositories;

import eu.dauphine.microservices.architecture.currencyexchange.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
