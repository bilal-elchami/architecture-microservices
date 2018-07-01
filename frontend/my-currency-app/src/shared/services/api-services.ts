import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const API_URL = 'http://localhost:8080';

@Injectable()
export class ApiServices {

    constructor(private http: HttpClient) {
    }

    getCurrencies() {
        return this.http.get(API_URL + '/currency');
    }

    getRates() {
        return this.http.get(API_URL + '/exchange-rate');
    }
}
