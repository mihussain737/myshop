package com.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.exception.ProductNotFoundException;
import com.myshop.payload.ProductDto;
import com.myshop.payload.ProductResponseDto;
import com.myshop.service.impl.ProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<ProductResponseDto> saveProduct(@RequestBody ProductDto productDto){
		ProductResponseDto productResponseDto = productService.saveProduct(productDto);
		return new ResponseEntity<>(productResponseDto,HttpStatus.CREATED);
	}
	@GetMapping("/{productName}")
	public ResponseEntity<ProductResponseDto> getProductByName(@PathVariable String productName){
		ProductResponseDto productByName = productService.getProductByName(productName);
		return new ResponseEntity<>(productByName,HttpStatus.CREATED);
	}
	@DeleteMapping("/{productName}")
	public ResponseEntity<String> deleteProductById(@PathVariable String productName){
		productService.deleteProductById(productName);
		return new ResponseEntity<>("product is deleted with name: "+productName,HttpStatus.OK);
	}
	@PutMapping("/{productName}")
    public ResponseEntity<String> updateProductPrice(@PathVariable String productName,@RequestBody ProductDto productDto) {
        try {
            productService.updateProductPrice(productName,productDto);
            return ResponseEntity.ok("Product price updated successfully");
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating product price");
        }
    }

}
