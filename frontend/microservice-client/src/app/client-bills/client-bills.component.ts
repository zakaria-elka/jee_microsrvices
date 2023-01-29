import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { bill } from '../model/bill.model';
import { BillingService } from '../services/billing.service';

@Component({
  selector: 'app-client-bills',
  templateUrl: './client-bills.component.html',
  styleUrls: ['./client-bills.component.css']
})
export class ClientBillsComponent implements OnInit {
  id!:number;
  sum!:number;
  Bills!:bill;


  constructor(private route:ActivatedRoute,private billingService:BillingService) { }

  ngOnInit(): void {

    this.id=this.route.snapshot.params["id"]
    this.billingService.getClientBill(this.id).subscribe((data)=>{
      this.Bills=data
      console.log(this.Bills)
    })

    const sun = this.Bills.productItems.reduce((accumulator, obj) => {
      return accumulator + obj.quantity*obj.price;
    }, 0);

    

 
  }
  

}
