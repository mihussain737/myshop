package com.myshop.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ProductDto {
	private Long productId;
	private String productName;
	private Long productPrice;
	private String productCompany;

}
