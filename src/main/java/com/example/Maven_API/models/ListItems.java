package com.example.Maven_API.models;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class ListItems {
	
	public List itemIds;
	public double amount;
	

	public void setItemIds(List<String> itemIds) {
		this.itemIds= itemIds;
	}
	
	public void setAmount(double amount) {
		this.amount= amount;
	}

	
}
