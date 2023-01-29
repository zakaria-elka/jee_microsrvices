import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { bill } from '../model/bill.model';
import { BillingService } from '../services/billing.service';

@Component({
  selector: 'app-bills',
  templateUrl: './bills.component.html',
  styleUrls: ['./bills.component.css']
})
export class BillsComponent implements OnInit {
  bills!:bill[]


  constructor(private billingService:BillingService,private router:Router) { }

  ngOnInit(): void {
    this.billingService.getAllBills().subscribe((data)=>{
      this.bills=data._embedded.bills
       
      console.log(this.bills)
    })
  }
  goToCustomerBills(billid:number){
    this.router.navigateByUrl("clients/bills/"+billid)

  }

}
