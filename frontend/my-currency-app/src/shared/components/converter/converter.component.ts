import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

import { Currency } from '../../../model/currency';
import { Transaction } from '../../../model/transaction';
import { CURRENCIES } from '../../../mock-data/data';
import { RateEvolutionChartComponent } from './../rate-evolution-chart/rate-evolution-chart.component';

@Component({
    selector: 'currency-converter',
    templateUrl: './converter.component.html',
    styleUrls: ['./converter.component.scss']
})
export class ConverterComponent implements OnInit {

    currencies: Currency[];
    transaction: Transaction;
    isPreviewConvertionVisible = false;
    isChartVisible = false;
    @ViewChild('chart') chart: RateEvolutionChartComponent;

    constructor(public router: Router) {

    }

    ngOnInit() {
        this.transaction = new Transaction();
        this.loadCurrencies();
    }

    loadCurrencies() {
        // api [GET] currencies
        this.currencies = CURRENCIES;
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
                this.chart.update();
            }
        }
    }

}
