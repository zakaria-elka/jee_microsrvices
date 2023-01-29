import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs'; 
import { client } from '../model/client.model';
@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http:HttpClient) { }

  public getAllClients():Observable<any>{


    return  this.http.get<any>("http://localhost:8082/CUSTOMER-MICROSV/customers")

  }
}
