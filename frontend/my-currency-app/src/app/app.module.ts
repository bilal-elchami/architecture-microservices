
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from '../routes/home/home.component';
import { TransactionsComponent } from './../routes/transactions/transactions.components';
import { ConverterComponent } from './../shared/components/converter/converter.component';
import { RateEvolutionChartComponent } from './../shared/components/rate-evolution-chart/rate-evolution-chart.component';

@NgModule({
  declarations: [
    AppComponent,
    ConverterComponent,
    HomeComponent,
    TransactionsComponent,
    RateEvolutionChartComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  exports: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
