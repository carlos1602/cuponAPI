package com.example.Maven_API.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.example.Maven_API.models.Comprar;
import com.example.Maven_API.models.ListItems;
import com.example.Maven_API.models.Items;

@Service
public class ListService {
	
	
	public Comprar getListDefined(ListItems listItems) {
		Items stock;
		String productStock, productOrder; 
		List<String> order;
		double balance, total, price;
		int maxStock, maxOrder;
		
		List<Items> listOfProducts= new ArrayList<>();
		List<String> stockAvailable= new ArrayList<>();
		List<String> itemsBought= new ArrayList<>();

		
//Carga de lista del inventario dependiendo del presupuesto del cliente
		balance=listItems.amount;
		
		if (balance < 270) {
			listOfProducts.add(new Items("MLA3",260));
			listOfProducts.add(new Items("MLA2",210));
			listOfProducts.add(new Items("MLA1",100));			
			listOfProducts.add(new Items("MLA5",90));				
			listOfProducts.add(new Items("MLA4",80));
		}
		else {
			listOfProducts.add(new Items("MLA1",100));
			listOfProducts.add(new Items("MLA2",210));
			listOfProducts.add(new Items("MLA3",260));		
			listOfProducts.add(new Items("MLA5",90));				
			listOfProducts.add(new Items("MLA4",80));
		}
		
		stockAvailable.add("MLA1");
		stockAvailable.add("MLA2");
		stockAvailable.add("MLA3");
		stockAvailable.add("MLA4");
		stockAvailable.add("MLA5");
		
		order = listItems.itemIds;
		
		Collection<String> similar = new HashSet<String>(stockAvailable);
		similar.retainAll(order);
		List<String> OrderUser= new ArrayList<>(similar);
		
		maxStock = listOfProducts.size();
		maxOrder = OrderUser.size();
		
		
		for(int itemStock=0; itemStock < maxStock;itemStock++) {
			
			for(int itemOrder=0;itemOrder<maxOrder;itemOrder++){
//Se obtiene el precio y producto del inventario				
				stock= listOfProducts.get(itemStock);
				price=stock.getPrice();					
				productStock= stock.getItemID();
//Se obtiene el nombre del producto pedido por el cliente			
				productOrder=OrderUser.get(itemOrder);
			
				if(price <= balance && productStock == productOrder) {
					balance -= price;
					itemsBought.add(productStock);
					itemOrder=maxOrder;												
				}				
			}
		}
			
		total = listItems.amount - balance; 
		Comprar bill=new Comprar(itemsBought, total);
		
		return bill;
	}
	
}
