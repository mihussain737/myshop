package com.myshop.service.impl;

import com.myshop.payload.ProductDto;
import com.myshop.payload.ProductResponseDto;

public interface ProductService {
	
	public ProductResponseDto saveProduct(ProductDto productDto);

	public ProductResponseDto getProductByName(String productName);

	public void deleteProductById(String productName);
	
    public void updateProductPrice(String productName,ProductDto productDto);

}
