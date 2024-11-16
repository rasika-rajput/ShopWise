package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.tka.dao.ProductDao;
import com.tka.entity.Product;

@Service
public class StockService
{

    @Autowired
     ProductDao productDao;

    @Autowired
     EmailService emailService;

    @Scheduled(fixedRate = 3600000)
    public void checkStockLevels() 
    {
        List<Product> products = productDao.getAllProducts();

        for (Product product : products) 
        {
            if (product.getStock() < 20)
            { 
                emailService.sendStockAlert("rasikarajput@gmail.com", product.getName(), product.getStock());
                System.out.println("Stock alert sent for product: " + product.getName());
            }
        }
    }
}

