import { Currency } from './currency';

export class Rate {
    id: number;
    currencySource: Currency;
    currencyDestination: Currency;
    exchangeDate: Date;
    rate: number;

    constructor() {
        this.exchangeDate = new Date();
    }
}
