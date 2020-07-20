package com.example.Maven_API.models;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Comprar {
	private List itemID;
	private double price;
	
	public Comprar(List itemID, double price) {
		this.itemID = itemID;
		this.price = price;
	}
	
	public List getItemID() {
		return itemID;
	}
	
	public Double getPrice() {
		return price;
	}
	
}
