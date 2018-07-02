import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CurrenciesComponent } from './../routes/currencies/currencies.component';
import { HomeComponent } from '../routes/home/home.component';
import { TransactionsComponent } from '../routes/transactions/transactions.components';
import { RatesComponent } from './../routes/rates/rates.component';
import { AddRateComponent } from './../routes/add-rate/add-rate.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'currencies', component: CurrenciesComponent },
  { path: 'transactions', component: TransactionsComponent },
  { path: 'rates', component: RatesComponent },
  { path: 'add-rate', component: AddRateComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
