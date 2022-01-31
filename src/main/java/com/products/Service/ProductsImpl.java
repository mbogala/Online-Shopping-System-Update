package com.products.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.Model.Products;
import com.products.Repository.ProductsRepository;
@Service
public class ProductsImpl implements IProduct {
	
	@Autowired
	 ProductsRepository dao;
	 public Products addProducts(Products products) {
		
	Products product=dao.save(products);
	
		return products;
	}
	
	@Override
	public List<Products> findAllProducts() {
		List<Products> products=dao.findAll();
		return products;
	}

	@Override
	public Optional<Products> findByName(String name) {
		// TODO Auto-generated method stub
		Optional<Products> products=dao.findByName(name); 
		  return products;
	}

}
