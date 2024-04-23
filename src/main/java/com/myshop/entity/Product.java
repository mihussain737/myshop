package com.myshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Product {
	
	@Id
	private Long productId;
	private String productName;
	private Long productPrice;
	private String productCompany;
}
