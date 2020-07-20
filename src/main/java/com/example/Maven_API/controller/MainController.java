package com.example.Maven_API.controller;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Maven_API.models.Comprar;
import com.example.Maven_API.models.ListItems;
import com.example.Maven_API.models.Items;
import com.example.Maven_API.services.ListService;


@RestController
public class MainController {

    @Autowired
    private ListService listService;

    @PostMapping(value="/coupon")
    public ResponseEntity<Comprar> getList(@RequestBody ListItems listItems) {
    	
    	if (listItems.amount < 90) {
        	return new ResponseEntity(HttpStatus.NOT_FOUND);
    	}
    
    	Comprar obj = listService.getListDefined(listItems);
    	return new ResponseEntity<Comprar>(obj, HttpStatus.OK);
    }
    
}
