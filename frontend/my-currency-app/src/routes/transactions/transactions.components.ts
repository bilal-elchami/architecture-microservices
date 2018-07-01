import { Component, OnInit } from '@angular/core';

import { ApiServices } from './../../shared/services/api-services';

@Component({
    selector: 'currency-transaction',
    templateUrl: './transactions.component.html',
    styleUrls: ['./transactions.component.scss']
})
export class TransactionsComponent implements OnInit {

    transactions;
    
    constructor(private api: ApiServices) {

    }

    ngOnInit() {
        this.loadTransactions();
    }

    loadTransactions() {
        this.api.getTransaction().subscribe(
            res => this.transactions = res,
            err => console.error(err)
        );
    }

}
