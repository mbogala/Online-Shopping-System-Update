package com.products.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.products.Model.Products;

public interface ProductsRepository extends JpaRepository<Products,Integer> {
	
	@Query("select e from Products e where e.name=name") List<Products>
	  findByname(@Param("name")String name);

	Optional<Products> findByName(String name);

}
