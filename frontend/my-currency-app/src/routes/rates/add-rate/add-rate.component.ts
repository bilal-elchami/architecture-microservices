import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { ApiServices } from './../../../shared/services/api-services';
import { Rate } from './../../../model/rate';

@Component({
    selector: 'currency-add-rate',
    templateUrl: './add-rate.component.html'
})
export class AddRateComponent implements OnInit {

    currencies;
    exchangeRate: Rate;

    constructor(private router: Router, private api: ApiServices) {

    }

    ngOnInit() {
        this.exchangeRate = new Rate();
        this.loadCurrencies();
    }

    loadCurrencies() {
        this.api.getCurrencies().subscribe(
            res => this.currencies = res,
            err => console.error(err)
        );
    }

    save() {
        this.api.addRate(this.exchangeRate).subscribe(
            res => this.router.navigate(['/rates']),
            err => console.error(err)
        );
    }

}
