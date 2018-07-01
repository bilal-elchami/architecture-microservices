import { Component, OnInit } from '@angular/core';

import { ApiServices } from './../../shared/services/api-services';

@Component({
    selector: 'currency-currencies',
    templateUrl: './currencies.component.html',
    styleUrls: ['./currencies.component.scss']
})
export class CurrenciesComponent implements OnInit {

    currencies;

    constructor(private api: ApiServices) {

    }

    ngOnInit() {
        this.loadCurrencies();
    }

    loadCurrencies() {
        this.api.getCurrencies().subscribe(
            res => this.currencies = res,
            err => console.error(err)
        );
    }

}
