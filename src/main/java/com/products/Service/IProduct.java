package com.products.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.products.Model.Products;
@Service
@Transactional
public interface IProduct  {

	List<Products> findAllProducts();

	//List<Products> findByName(String name);

	Products addProducts(Products products);

	Optional<Products> findByName(String name);

}
