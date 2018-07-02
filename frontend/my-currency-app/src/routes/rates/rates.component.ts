import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { ApiServices } from './../../shared/services/api-services';

@Component({
    selector: 'currency-rates',
    templateUrl: './rates.component.html',
    styleUrls: ['./rates.component.scss']
})
export class RatesComponent implements OnInit {

    rates;

    constructor(public router: Router, private api: ApiServices) {

    }

    ngOnInit() {
        this.loadRates();
    }

    loadRates() {
        this.api.getRates().subscribe(
            res => this.rates = res,
            err => console.error(err)
        );
    }

    addExchangeRate() {
        this.router.navigate(['/rates/new']);
    }

    delete(id) {
        this.api.deleteExchangeRate(id).subscribe(
            res => this.rates = this.rates.filter(rate => rate.id !== id),
            err => console.error(err)
        );
    }

}
