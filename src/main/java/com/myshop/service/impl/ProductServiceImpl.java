package com.myshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.entity.Product;
import com.myshop.exception.ProductNotFoundException;
import com.myshop.payload.ProductDto;
import com.myshop.payload.ProductResponseDto;
import com.myshop.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Override
	public ProductResponseDto saveProduct(ProductDto productDto) {
		Product product = new Product();
		product.setProductId(productDto.getProductId());
		product.setProductName(productDto.getProductName());
		product.setProductPrice(productDto.getProductPrice());
		product.setProductCompany(productDto.getProductCompany());
		productRepo.save(product);

		ProductResponseDto productResponseDto = new ProductResponseDto();
		productResponseDto.setProductName(product.getProductName());
		productResponseDto.setProductPrice(product.getProductPrice());
		return productResponseDto;
	}

	@Override
	public ProductResponseDto getProductByName(String productName) {
		List<Product> products = productRepo.findByProductName(productName);

		// Check if the list is not empty
		if (!products.isEmpty()) {
			Product product = products.get(0); // Assuming you want the first product if multiple products have the same
												// name
			ProductResponseDto productResponseDto = new ProductResponseDto();
			productResponseDto.setProductName(product.getProductName());
			productResponseDto.setProductPrice(product.getProductPrice());
			return productResponseDto;
		} else {
			// Handle case where no product with the given name is found
			throw new ProductNotFoundException("Product with name " + productName + " not found");
		}
	}

	@Override
	@Transactional
	public void deleteProductById(String productName) {
		productRepo.removeByProductName(productName);
	}

	@Override
	@Transactional
	public void updateProductPrice(String productName,ProductDto productDto) {
		// Retrieve the product by name
		List<Product> products = productRepo.findByProductName(productName);

		// Check if product exists
		if (!products.isEmpty()) {
			// Assuming only one product with the given name exists
			Product product = new Product();
			Product product2 = products.get(0);
			product.setProductId(product2.getProductId());
			product.setProductCompany(product2.getProductCompany());
			product.setProductName(product2.getProductName());
			product.setProductPrice(productDto.getProductPrice());
			productRepo.save(product);
		} else {
			throw new ProductNotFoundException("Product with name " + productName + " not found");
		}

	}
}
