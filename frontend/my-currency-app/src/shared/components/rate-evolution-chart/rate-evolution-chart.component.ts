import { AfterViewInit, ChangeDetectionStrategy, Component, Input } from '@angular/core';

import { Currency } from './../../../model/currency';
import { Rate } from './../../../model/rate';
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
    exchangeRates: Rate[] = [];

    ngAfterViewInit() {
        this.canvas = document.getElementById('rate-evolution-chart');
        this.ctx = this.canvas.getContext('2d');
        this.update();
    }

    loadExchangeRate() {
        // calling api GET list exchanges 2 params currencySource and currencyDestination
        this.exchangeRates = [
            {
                id: 1,
                currencySource: this.currencySource,
                currencyDestination: this.currencyDestination,
                date: new Date(),
                rate: Math.floor(Math.random() * 6) + 1
            },
            {
                id: 2,
                currencySource: this.currencySource,
                currencyDestination: this.currencyDestination,
                date: new Date(),
                rate: Math.floor(Math.random() * 6) + 1
            },
            {
                id: 3,
                currencySource: this.currencySource,
                currencyDestination: this.currencyDestination,
                date: new Date(),
                rate: Math.floor(Math.random() * 6) + 1
            }
        ];
    }

    update() {
        this.loadExchangeRate();
        this.chart = new Chart(this.ctx, {
            type: 'line',
            data: {
                labels: this.exchangeRates.map(exchangeRate => DateUtils.formatDate(exchangeRate.date)),
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
