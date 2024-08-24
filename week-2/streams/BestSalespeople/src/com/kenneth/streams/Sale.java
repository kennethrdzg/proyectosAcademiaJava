package com.kenneth.streams;


public class Sale {//implements Comparable<Sale>{
	Product product;
	Salesperson salesperson;
	int quantity;

	public Sale(Product product, Salesperson salesperson, int quantity) {
		this.product = product;
		this.salesperson = salesperson;
		this.quantity = quantity;
	}
	
	@Override
	public String toString(){
		return "Sale [ " + this.salesperson + ", " + this.product + ", Quantity: " + this.quantity + ", Total: $" + this.product.price * quantity + " ]"; 
		//return "Sale [ ProductId: " + this.product.productId + ", Salesman: " + this.salesman.name + ", Total: $" + this.product.price * this.quantity + " ]";
	}
	
	/*
	 @Override
	public int compareTo(Sale other) {
		if(this.product.productId != other.product.productId)
			return this.product.productId - other.product.productId;
		if(this.quantity != other.quantity)
			return this.quantity;
		
		return this.salesman.employeeId - other.salesman.employeeId;
	}
	 */
}
