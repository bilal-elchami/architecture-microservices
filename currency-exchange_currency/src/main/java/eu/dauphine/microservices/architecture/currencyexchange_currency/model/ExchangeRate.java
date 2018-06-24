package eu.dauphine.microservices.architecture.currencyexchange_currency.model;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the exchange_rate database table.
 * 
 */
@Entity
@Table(name="exchange_rate")
public class ExchangeRate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name="exchange_date")
	private Date exchangeDate;

	private double rate;

	//bi-directional many-to-one association to Currency
	@ManyToOne
	@JoinColumn(name="currency_destination_id")
	private Currency currencyDestination;

	//bi-directional many-to-one association to Currency
	@ManyToOne
	@JoinColumn(name="currency_source_id")
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

}