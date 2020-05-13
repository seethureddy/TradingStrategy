package main.java.com.acme.mytrader.product;

import main.java.com.acme.mytrader.price.PriceListener;

public class Product implements PriceListener {
	
	private String prodName;
	private Integer price;
	
	public Product(String name, Integer price) {	
		this.prodName = name;
		this.price = price;		
	}
		
	@Override
	public void priceUpdate(String security, double price) {
		if(this.prodName.equalsIgnoreCase(security)) {
			System.out.println("Current price of product {"+security+"} is {"+price+"}");
		}
	}

}
