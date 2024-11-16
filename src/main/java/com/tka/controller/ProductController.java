package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Product;
import com.tka.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController
{

    @Autowired
    ProductService productService;

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }
    
    @GetMapping("/productsOutOfStock")
	public List<Product> productsOutOfStock()
	{
		return productService.productsOutOfStock();
	}
    
    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Product product)
    {
        return productService.addProduct(product);
    }

    @PutMapping("/updateProductPriceBasedOnStock/{id}")
    public String updateProductPriceBasedOnStock(@PathVariable Long id, @RequestBody Product product) 
    {
        return productService.updateProductPriceBasedOnStock(id, product);
    }

    @GetMapping("/lowStockProducts")
    public List<Product> getLowStockProducts() 
    {
        return productService.getLowStockProducts();
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id)
    {
        return productService.deleteProduct(id);
    }
}
