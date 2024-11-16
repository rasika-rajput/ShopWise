package com.tka.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.ProductDao;
import com.tka.entity.Product;

@Service
public class ProductService 
{

    @Autowired
    ProductDao productDao;

    public List<Product> getAllProducts() 
    {
        return productDao.getAllProducts();
    }
    
    public List<Product> productsOutOfStock() 
	{
		return productDao.productsOutOfStock();
	}
	
    public String addProduct(Product product) 
    {
        return productDao.addProduct(product);
    }

    public String updateProductPriceBasedOnStock(Long id, Product product) 
    {
        return productDao.updateProductPriceBasedOnStock(id, product);
    }

    public List<Product> getLowStockProducts()
    {
        return productDao.getLowStockProducts();
    }

    public String deleteProduct(Long id) 
    {
        return productDao.deleteProduct(id);
    }

  
}
