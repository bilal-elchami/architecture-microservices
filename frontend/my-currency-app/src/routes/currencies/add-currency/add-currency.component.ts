import { Component, OnInit, Input } from '@angular/core';

import { ApiServices } from './../../../shared/services/api-services';
import { Currency } from '../../../model/currency';
import { Router } from '@angular/router';

@Component({
    selector: 'currency-add-currency',
    templateUrl: './add-currency.component.html'
})
export class AddCurrencyComponent implements OnInit {

    currency: Currency;

    constructor(private router: Router, private api: ApiServices) {
    }

    ngOnInit() {
        this.currency = new Currency();
    }

    save(){
        this.api.addCurrency(this.currency).subscribe(
            res => this.router.navigate(['/currencies']),
            err => console.error(err)
        );
    }

}
