import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BillingService {

  constructor(private http:HttpClient) { }

  getClientBill(clientid:number):Observable<any>{
    return this.http.get<any>("http://localhost:8082/BILLING-SERVICE/fullBill/"+clientid)
  }
  getAllBills():Observable<any>{
    return this.http.get<any>("http://localhost:8082/BILLING-SERVICE/bills")

  }
}
