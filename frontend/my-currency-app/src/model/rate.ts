import { Currency } from './currency';

export class Rate {
    id: number;
    currencySource: Currency;
    currencyDestination: Currency;
    date: Date;
    rate: number;
}
