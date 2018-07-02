import { Component, OnInit } from '@angular/core';

import { ApiServices } from './../../shared/services/api-services';

@Component({
    selector: 'currency-transaction',
    templateUrl: './transactions.component.html',
    styleUrls: ['./transactions.component.scss']
})
export class TransactionsComponent implements OnInit {

    transactions;
    currencies;
    isDone = false;
    
    constructor(private api: ApiServices) {

    }

    ngOnInit() {
        this.loadTransactions();
    }

    loadCurrencies() {
        this.api.getCurrencies().subscribe(
            res => {
                this.currencies = res;
                this.setCurrencies();
            },
            err => console.error(err)
        );
    }

    setCurrencies() {
        for (let i = 0; i < this.transactions.length; i++) {
            this.transactions[i].currencySource = this.currencies.filter(
                currency => (currency.id === this.transactions[i].currencyDestinationId)
            )[0];
            this.transactions[i].currencyDestination = this.currencies.filter(
                currency => (currency.id === this.transactions[i].currencySourceId)
            )[0];
        }
        this.isDone = true;
    }

    loadTransactions() {
        this.api.getTransaction().subscribe(
            res => {
                this.transactions = res;
                this.loadCurrencies();
            },
            err => console.error(err)
        );
    }

}
