import { Component, OnInit, Input } from '@angular/core';

import { ApiServices } from './../../../shared/services/api-services';
import { Currency } from '../../../model/currency';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
    selector: 'currency-add-currency',
    templateUrl: './add-currency.component.html'
})
export class AddCurrencyComponent implements OnInit {
    
    currency;

    constructor(private router: Router, private route: ActivatedRoute,  private api: ApiServices) {
    }

    ngOnInit() {
        this.currency = new Currency();
        let currencyId = this.route.snapshot.paramMap.get('currencyId');
        console.log(currencyId);
        if (currencyId !== undefined){
            this.api.getCurrency(currencyId).subscribe(
                res => this.currency = res,
                err => console.error(err)
            );
        }
    }

    save(){
        this.api.addCurrency(this.currency).subscribe(
            res => this.router.navigate(['/currencies']),
            err => console.error(err)
        );
    }

}
