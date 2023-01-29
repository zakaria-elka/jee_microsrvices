import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { client } from '../model/client.model';
import { ClientService } from '../services/client.service';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {
  Clients!:client[]

  constructor(private clientService:ClientService,private router:Router) { }

  ngOnInit(): void {
    
    this.getClients()

  }
  getClients(){
    this.clientService.getAllClients().subscribe(
      (res)=>{
         
        this.Clients=res._embedded.customers
        console.log(this.Clients)
      }
     )
  }
  goToCustomerBills(customerid:number){
    this.router.navigateByUrl("clients/bills/"+customerid)

  }

}
