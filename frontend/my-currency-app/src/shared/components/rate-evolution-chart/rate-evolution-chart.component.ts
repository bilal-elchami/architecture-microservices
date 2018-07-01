import { AfterViewInit, ChangeDetectionStrategy, Component, Input } from '@angular/core';

import { Currency } from './../../../model/currency';
import { Rate } from './../../../model/rate';
import { ApiServices } from './../../services/api-services';
import { DateUtils } from '../../utils/date-utils';
import { Chart } from 'chart.js';

@Component({
    selector: 'currency-rate-evolution-chart',
    templateUrl: './rate-evolution-chart.component.html',
    styleUrls: ['./rate-evolution-chart.component.scss'],
    changeDetection: ChangeDetectionStrategy.OnPush
})
export class RateEvolutionChartComponent implements AfterViewInit {

    canvas: any;
    ctx: any;
    chart: any;
    @Input() currencySource: Currency;
    @Input() currencyDestination: Currency;
    exchangeRates;

    constructor(private api: ApiServices) {
    }

    ngAfterViewInit() {
        this.canvas = document.getElementById('rate-evolution-chart');
        this.ctx = this.canvas.getContext('2d');
        this.update(this.currencySource, this.currencyDestination);
    }

    loadExchangeRate() {
        const from = this.currencySource.symbol;
        const to = this.currencyDestination.symbol;
        this.api.getExchangeRateList(from, to).subscribe(
            res => {
                this.exchangeRates = res;
                this.updateChart();
            },
            err => console.error(err)
        );
    }

    update(_currencySource, _currencyDestination) {
        this.currencySource = _currencySource;
        this.currencyDestination = _currencyDestination;
        this.loadExchangeRate();
    }

    updateChart() {
        console.log(this.exchangeRates);
        this.chart = new Chart(this.ctx, {
            type: 'line',
            data: {
                labels: this.exchangeRates.map(exchangeRate => exchangeRate.exchangeDate),
                datasets: [{
                    data: this.exchangeRates.map(exchangeRate => exchangeRate.rate),
                    label: this.currencySource.symbol + ' / ' + this.currencyDestination.symbol,
                    borderColor: '#3e95cd',
                    fill: false
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        stacked: true
                    }]
                }
            }
        });
    }

}
