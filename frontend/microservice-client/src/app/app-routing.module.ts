import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BillsComponent } from './bills/bills.component';
import { ClientBillsComponent } from './client-bills/client-bills.component';
import { ClientsComponent } from './clients/clients.component';
import { ProductsComponent } from './products/products.component';

const routes: Routes = [
  {path:"clients",component:ClientsComponent},
  {path:"bills",component:BillsComponent},
  {path:"clients/bills/:id",component:ClientBillsComponent},
  {path:"products",component:ProductsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
