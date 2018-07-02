package eu.dauphine.microservices.architecture.currencyexchange.model;

import java.io.Serializable;
import java.util.Date;

public class ExchangeRate implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date exchangeDate;

	private double rate;

	private Currency currencyDestination;

	private Currency currencySource;

	public ExchangeRate() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getExchangeDate() {
		return this.exchangeDate;
	}

	public void setExchangeDate(Date exchangeDate) {
		this.exchangeDate = exchangeDate;
	}

	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public Currency getCurrencyDestination() {
		return this.currencyDestination;
	}

	public void setCurrencyDestination(Currency currencyDestination) {
		this.currencyDestination = currencyDestination;
	}

	public Currency getCurrencySource() {
		return this.currencySource;
	}

	public void setCurrencySource(Currency currencySource) {
		this.currencySource = currencySource;
	}

	@Override
	public String toString() {
		return "ExchangeRate{" +
				"id=" + id +
				", exchangeDate=" + exchangeDate +
				", rate=" + rate +
				", currencyDestination=" + currencyDestination +
				", currencySource=" + currencySource +
				'}';
	}
}