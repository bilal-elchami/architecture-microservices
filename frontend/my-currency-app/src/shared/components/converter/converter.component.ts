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

    makeTransaction() {
        this.isPreviewConvertionVisible = true;
        const from = this.transaction.currencySource.symbol;
        const to = this.transaction.currencyDestination.symbol;
        const amount = this.transaction.amount;
        this.api.makeTransaction(from, to, amount).subscribe(
            res => this.router.navigate(['/transactions']),
            err => console.error(err)
        );
    }

    updatePreviewConversionVisbility() {
        this.isPreviewConvertionVisible = (this.isChartVisible && this.transaction.amount != null);
        if (this.isPreviewConvertionVisible) {
            this.api.getExchangeRate(this.transaction.currencySource.symbol, this.transaction.currencyDestination.symbol).subscribe(
                res => {
                    const currentExchangeRate = <Transaction> res;
                    this.transaction.rate = currentExchangeRate.rate;
                },
                err => console.error(err)
            );
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
