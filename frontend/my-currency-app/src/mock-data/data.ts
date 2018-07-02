import { Currency } from '../model/currency';
import { Rate } from '../model/rate';
import { Transaction } from '../model/transaction';

export let USD: Currency = {
    id: 1,
    name: 'United States Dollar',
    symbol: 'USD'
};
export let EUR: Currency = {
    id: 2,
    name: 'Euro',
    symbol: 'EUR'
};
export let LBP: Currency = {
    id: 3,
    name: 'Lebanese pound',
    symbol: 'LBP'
};
export let CURRENCIES: Currency[] = [USD, EUR, LBP];

export let USD_EUR_RATE: Rate = {
    id: 1,
    currencySource: USD,
    currencyDestination: EUR,
    exchangeDate: new Date(),
    rate: 0.85
};
