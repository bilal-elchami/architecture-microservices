import { Component, OnInit } from '@angular/core';

import { CurrencyUtils } from '../../shared/utils/currency-utils';
import { DateUtils } from '../../shared/utils/date-utils';

import { Transaction } from '../../model/transaction';
import { USD } from '../../mock-data/data';
import { EUR } from '../../mock-data/data';

@Component({
    selector: 'currency-transaction',
    templateUrl: './transactions.component.html',
    styleUrls: ['./transactions.component.scss']
})
export class TransactionsComponent implements OnInit {

    transactions: Transaction[];

    ngOnInit() {
        this.loadTransactions();
    }

    loadTransactions() {
        this.transactions = [
            {
                id: 1,
                currencySource: EUR,
                currencyDestination: USD,
                amount: 10000,
                date: new Date(),
                rate: 1.18
            },
            {
                id: 2,
                currencySource: USD,
                currencyDestination: EUR,
                amount: 10000,
                date: new Date(),
                rate: 0.89
            }
        ];
    }

}
