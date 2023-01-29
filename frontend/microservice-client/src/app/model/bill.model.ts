export interface bill {
    id: number
    billingDate: string
    productItems: ProductItem[]
    customerId: number
    customer: Customer
  }
  
  export interface ProductItem {
    id: number
    quantity: number
    price: number
    productID: number
    product: any
    productName: any
  }
  
  export interface Customer {
    id: number
    name: string
    email: string
  }
  