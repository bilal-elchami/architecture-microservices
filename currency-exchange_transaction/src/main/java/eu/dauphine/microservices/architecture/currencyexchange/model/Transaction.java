package eu.dauphine.microservices.architecture.currencyexchange.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the transaction database table.
 * 
 */
@Entity
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private double amount;

	private double rate;

	@Temporal(TemporalType.DATE)
	@Column(name="transaction_date")
	private Date transactionDate;

	//bi-directional many-to-one association to Currency
	@ManyToOne
	@JoinColumn(name="currency_source_id")
	private Currency currencySource;

	//bi-directional many-to-one association to Currency
	@ManyToOne
	@JoinColumn(name="currency_destination_id")
	private Currency currencyDestination;

	public Transaction() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Currency getCurrencySource() {
		return this.currencySource;
	}

	public void setCurrencySource(Currency currencySource) {
		this.currencySource = currencySource;
	}

	public Currency getCurrencyDestination() {
		return this.currencyDestination;
	}

	public void setCurrencyDestination(Currency currencyDestination) {
		this.currencyDestination = currencyDestination;
	}

}