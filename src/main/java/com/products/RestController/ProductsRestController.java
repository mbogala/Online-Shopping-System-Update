package com.products.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.Exception.ProductNotFoundException;
import com.products.Model.Products;
import com.products.Service.IProduct;
@RestController
@RequestMapping("/product")
public class ProductsRestController {
	
	@Autowired
	IProduct service;
	
	@PostMapping("/addProducts")
	public ResponseEntity<Products> createProduct(@Validated @RequestBody Products products) {

		Products e = service.addProducts(products);
		System.out.println(e);
		return new ResponseEntity<Products>(e, HttpStatus.OK);
	}
	
	//Fetching all records
	
	  @GetMapping
	  public ResponseEntity<List<Products>>
	  fetchProducts() { System.out.println("all"); List<Products> products =
	  service.findAllProducts(); return ResponseEntity.ok().body(products);
	  }
	 
	
	//Fetching Records With condition
	  
	
	  @GetMapping("/{name}") public ResponseEntity <Optional<Products>> getProductsByName(@PathVariable String name){
		  Optional<Products>
	  products=service.findByName(name);
		  if(products.isPresent()) { 
		  return new ResponseEntity(products.get(),HttpStatus.OK); 
		  }
	  else
		  { throw new
	  ProductNotFoundException("Product not found..."); } 
	  }
	 
}
