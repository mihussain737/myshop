package com.myshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findByProductName(String productName);
//	void deleteByProductName(String productName);
	void removeByProductName(String productName);

}
