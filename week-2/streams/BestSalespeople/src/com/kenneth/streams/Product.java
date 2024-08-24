package com.kenneth.streams;

public class Product {
	static int totalProducts;
	
	public int productId;
	public double price;
	
	public Product(double price) {
		Product.totalProducts += 1;
		
		this.productId = Product.totalProducts;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "ProductID: " + this.productId; 
	}
}
