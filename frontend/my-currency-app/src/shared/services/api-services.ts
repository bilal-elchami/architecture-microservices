import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Currency } from '../../model/currency';

const API_EXCHANGE_RATE_URL = 'http://localhost:8000';
const API_TRANSACTION_URL = 'http://localhost:8080';
const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
};

@Injectable()
export class ApiServices {
    
    constructor(private http: HttpClient) {
    }

    getCurrencies() {
        const url = API_EXCHANGE_RATE_URL + '/currency';
        return this.http.get(url);
    }

    getCurrency(id) {
        const url = API_EXCHANGE_RATE_URL + '/currency/' + id;
        return this.http.get(url);
    }

    addCurrency(currency: Currency) {
        const url = API_EXCHANGE_RATE_URL + '/currency';
        return this.http.post(url, currency, httpOptions);
    }

    deleteCurrency(currencyId: number) {
        const url = API_EXCHANGE_RATE_URL + '/currency/' + currencyId;
        return this.http.delete(url);
    }

    getRates() {
        const url = API_EXCHANGE_RATE_URL + '/exchange-rate';
        return this.http.get(url);
    }

    getExchangeRate(from, to) {
        const url = API_EXCHANGE_RATE_URL + '/exchange-rate/exchange/from/' + from + '/to/' + to;
        return this.http.get(url);
    }

    getExchangeRateList(from, to) {
        const url = API_EXCHANGE_RATE_URL + '/exchange-rate/exchange-rates/from/' + from + '/to/' + to;
        return this.http.get(url);
    }

    getTransaction() {
        const url = API_TRANSACTION_URL + '/transactions';
        return this.http.get(url);
    }

    makeTransaction(from, to, amount) {
        const url = API_TRANSACTION_URL + '/transactions/exchange/from/' + from + '/to/' + to + '/amount/' + amount;
        return this.http.get(url);
    }

    addRate(rate) {
        const url = API_EXCHANGE_RATE_URL + '/exchange-rate';
        return this.http.post(url, rate, httpOptions);
    }

    deleteExchangeRate(rateId) {
        const url = API_EXCHANGE_RATE_URL + '/exchange-rate/' + rateId;
        return this.http.delete(url);
    }

}
