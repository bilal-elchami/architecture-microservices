import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from '../routes/home/home.component';
import { TransactionsComponent } from './../routes/transactions/transactions.components';
import { ConverterComponent } from './../shared/components/converter/converter.component';
import { RateEvolutionChartComponent } from './../shared/components/rate-evolution-chart/rate-evolution-chart.component';
import { CurrenciesComponent } from '../routes/currencies/currencies.component';
import { RatesComponent } from '../routes/rates/rates.component';
import { ApiServices } from './../shared/services/api-services';

@NgModule({
  declarations: [
    AppComponent,
    ConverterComponent,
    CurrenciesComponent,
    HomeComponent,
    RatesComponent,
    TransactionsComponent,
    RateEvolutionChartComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ApiServices],
  exports: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
