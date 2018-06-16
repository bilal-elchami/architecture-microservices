import { Currency } from './currency';

export class Transaction {
    id: number;
    currencySource: Currency;
    currencyDestination: Currency;
    amount: number;
    date: Date;
    rate: number;

    constructor() {
        this.rate = 0;
    }
}
