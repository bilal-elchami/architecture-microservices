package eu.dauphine.microservices.architecture.currencyexchange.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the currency database table.
 * 
 */
@Entity
public class Currency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String symbol;

	//bi-directional many-to-one association to ExchangeRate
	@JsonIgnore
	@OneToMany(mappedBy="currencySource")
	private List<ExchangeRate> exchangeRatesSource;

	//bi-directional many-to-one association to ExchangeRate
	@JsonIgnore
	@OneToMany(mappedBy="currencyDestination")
	private List<ExchangeRate> exchangeRatesDestination;

	//bi-directional many-to-one association to Transaction
	@JsonIgnore
	@OneToMany(mappedBy="currencySource")
	private List<Transaction> transactionsSource;

	//bi-directional many-to-one association to Transaction
	@JsonIgnore
	@OneToMany(mappedBy="currencyDestination")
	private List<Transaction> transactionsDestination;

	public Currency() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public List<ExchangeRate> getExchangeRatesSource() {
		return this.exchangeRatesSource;
	}

	public void setExchangeRatesSource(List<ExchangeRate> exchangeRatesSource) {
		this.exchangeRatesSource = exchangeRatesSource;
	}

	public ExchangeRate addExchangeRates1(ExchangeRate exchangeRates1) {
		getExchangeRatesSource().add(exchangeRates1);
		exchangeRates1.setCurrencyDestination(this);

		return exchangeRates1;
	}

	public ExchangeRate removeExchangeRates1(ExchangeRate exchangeRates1) {
		getExchangeRatesSource().remove(exchangeRates1);
		exchangeRates1.setCurrencyDestination(null);

		return exchangeRates1;
	}

	public List<ExchangeRate> getExchangeRatesDestination() {
		return this.exchangeRatesDestination;
	}

	public void setExchangeRatesDestination(List<ExchangeRate> exchangeRatesDestination) {
		this.exchangeRatesDestination = exchangeRatesDestination;
	}

	public ExchangeRate addExchangeRates2(ExchangeRate exchangeRates2) {
		getExchangeRatesDestination().add(exchangeRates2);
		exchangeRates2.setCurrencySource(this);

		return exchangeRates2;
	}

	public ExchangeRate removeExchangeRates2(ExchangeRate exchangeRates2) {
		getExchangeRatesDestination().remove(exchangeRates2);
		exchangeRates2.setCurrencySource(null);

		return exchangeRates2;
	}

	public List<Transaction> getTransactionsSource() {
		return this.transactionsSource;
	}

	public void setTransactionsSource(List<Transaction> transactionsSource) {
		this.transactionsSource = transactionsSource;
	}

	public Transaction addTransactionsSource(Transaction transactionsSource) {
		getTransactionsSource().add(transactionsSource);
		transactionsSource.setCurrencySource(this);

		return transactionsSource;
	}

	public Transaction removeTransactionsSource(Transaction transactionsSource) {
		getTransactionsSource().remove(transactionsSource);
		transactionsSource.setCurrencySource(null);

		return transactionsSource;
	}

	public List<Transaction> getTransactionsDestination() {
		return this.transactionsDestination;
	}

	public void setTransactionsDestination(List<Transaction> transactionsDestination) {
		this.transactionsDestination = transactionsDestination;
	}

	public Transaction addTransactionsDestination(Transaction transactionsDestination) {
		getTransactionsDestination().add(transactionsDestination);
		transactionsDestination.setCurrencyDestination(this);

		return transactionsDestination;
	}

	public Transaction removeTransactionsDestination(Transaction transactionsDestination) {
		getTransactionsDestination().remove(transactionsDestination);
		transactionsDestination.setCurrencyDestination(null);

		return transactionsDestination;
	}

}