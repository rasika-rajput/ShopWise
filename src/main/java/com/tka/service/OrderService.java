package com.tka.service;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.DiscountDao;
import com.tka.dao.ProductDao;
import com.tka.dao.SalesDao;
import com.tka.entity.Discount;
import com.tka.entity.Product;
import com.tka.entity.Sales;


@Service
public class OrderService 
{
    @Autowired
     ProductDao productDao;

    @Autowired
     DiscountDao discountDao;
    
    @Autowired
    SalesDao salesDao;

    public String placeOrder(Long productId, int quantity) 
    {
        Product product = productDao.getProductByID(productId);
        double price = product.getPrice();
        
        if (product == null || product.getStock() < quantity) 
        {
            return "Product is out of stock";
        }

        if(product.getStock() > 1000)
        {
        	price = product.getPrice() - (product.getPrice()*5/100);
        }
        
        else if(product.getStock() < 50)
        {
        	price = product.getPrice() + (product.getPrice()*5/100);
        }
        
        Discount discount = discountDao.getActiveDiscountsByID(productId);
        double totalDiscount = 0;

        if (product.getIsDiscountEligible()) 
        {
            if (LocalDate.now().getMonthValue() == 10)
            { 
                totalDiscount = totalDiscount + 15;
            }
            else 
            {
                totalDiscount = totalDiscount + 5;
            }
        }

        if (quantity > 100)
        {
            totalDiscount = totalDiscount + 10;
        }
       
        if (discount != null && discount.getValidTo().after(new Date())) 
        {
            totalDiscount = totalDiscount + discount.getDiscountPercentage();
        }
       
        if (totalDiscount > 30) 
        {
            totalDiscount = 30;
        }
        
        double finalPrice = (price - (price * totalDiscount / 100)) * quantity;

        product.setStock(product.getStock() - quantity);
        productDao.updateProduct(product);

        Sales sale = new Sales();
        sale.setPurchaseDate(LocalDate.now());
        sale.setMonth(LocalDate.now().getMonthValue());
        sale.setYear(LocalDate.now().getYear());
        sale.setProductId(productId);
        sale.setQuantity(quantity);
        sale.setTotalPrice(finalPrice);
        
        salesDao.addSale(sale);
        
        return "Order placed... Total Amount = Rs." + finalPrice;
    }
}

