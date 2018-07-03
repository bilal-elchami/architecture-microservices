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

	private String currencySourceSymbol;

	private String currencyDestinationSymbol;

	public Transaction() {
	}

	public Transaction(double amount, double rate, Date transactionDate, String currencySourceSymbol, String currencyDestinationSymbol) {
		this.amount = amount;
		this.rate = rate;
		this.transactionDate = transactionDate;
		this.currencySourceSymbol = currencySourceSymbol;
		this.currencyDestinationSymbol = currencyDestinationSymbol;
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

	public String getCurrencySourceSymbol() {
		return currencySourceSymbol;
	}

	public void setCurrencySourceSymbol(String currencySourceSymbol) {
		this.currencySourceSymbol = currencySourceSymbol;
	}

	public String getCurrencyDestinationSymbol() {
		return currencyDestinationSymbol;
	}

	public void setCurrencyDestinationSymbol(String currencyDestinationSymbol) {
		this.currencyDestinationSymbol = currencyDestinationSymbol;
	}
}