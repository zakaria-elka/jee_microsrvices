import { Component, OnInit } from '@angular/core';
import { product } from '../model/product.model';
import { ProductsService } from '../services/products.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  Products!:product[]

  constructor(private productService:ProductsService) { }

  ngOnInit(): void {
    this.productService.getAllProducts().subscribe((data)=>{
      this.Products=data._embedded.products
       
    })
  }

}
