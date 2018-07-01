import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

import { ApiServices } from './../../services/api-services';
import { Transaction } from '../../../model/transaction';
import { RateEvolutionChartComponent } from './../rate-evolution-chart/rate-evolution-chart.component';

@Component({
    selector: 'currency-converter',
    templateUrl: './converter.component.html',
    styleUrls: ['./converter.component.scss']
})
export class ConverterComponent implements OnInit {

    currencies;
    transaction: Transaction;
    isPreviewConvertionVisible = false;
    isChartVisible = false;
    @ViewChild('chart') chart: RateEvolutionChartComponent;

    constructor(public router: Router, private api: ApiServices) {

    }

    ngOnInit() {
        this.transaction = new Transaction();
        this.loadCurrencies();
    }

    loadCurrencies() {
        this.api.getCurrencies().subscribe(
            res => this.currencies = res,
            err => console.error(err)
        );
    }

    switchCurrencies() {
        const oldCurrencySource = this.transaction.currencySource;
        this.transaction.currencySource = this.transaction.currencyDestination;
        this.transaction.currencyDestination = oldCurrencySource;
    }

    convert() {
        console.log(this.transaction);
        this.isPreviewConvertionVisible = true;
        this.router.navigate(['/transactions']);
    }

    updatePreviewConversionVisbility() {
        this.isPreviewConvertionVisible = (this.isChartVisible && this.transaction.amount != null);
        if (this.isPreviewConvertionVisible) {
            // update rate of transaction
        }
    }

    updateChartVisbility() {
        this.isChartVisible = (this.transaction.currencySource != null && this.transaction.currencyDestination != null);
        this.updatePreviewConversionVisbility();
        if (this.isChartVisible) {
            if (this.chart) {
                this.chart.update(this.transaction.currencySource, this.transaction.currencyDestination);
            }
        }
    }

}
