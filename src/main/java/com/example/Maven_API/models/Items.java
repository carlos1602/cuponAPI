package com.example.Maven_API.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Items {
	private String itemID;
	private double price;
	
	public Items(String itemID, double price) {
		this.itemID = itemID;
		this.price = price;
	}
	
	public String getItemID() {
		return itemID;
	}
	
	
	
	public Double getPrice() {
		return price;
	}
	
}
