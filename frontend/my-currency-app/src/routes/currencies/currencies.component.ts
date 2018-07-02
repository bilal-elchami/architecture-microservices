import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { ApiServices } from './../../shared/services/api-services';

@Component({
    selector: 'currency-currencies',
    templateUrl: './currencies.component.html',
    styleUrls: ['./currencies.component.scss']
})
export class CurrenciesComponent implements OnInit {

    currencies;

    constructor(private router: Router, private api: ApiServices) {

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

    delete(currencyId: number) {
        this.api.deleteCurrency(currencyId).subscribe(
            res => this.currencies = this.currencies.filter(currency => currency.id !== currencyId),
            err => console.error(err)
        );
    }

}
