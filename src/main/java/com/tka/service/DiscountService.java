package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.DiscountDao;
import com.tka.entity.Discount;

@Service
public class DiscountService 
{

    @Autowired
    DiscountDao discountDao;

    public List<Discount> getAllDiscounts()
    {
        return discountDao.getAllDiscounts();
    }
    
    public Discount getDiscountByID(Long id)
    {
        return discountDao.getDiscountByID(id);
    }
    
    public List<Discount> getActiveDiscounts() 
    {
        return discountDao.getActiveDiscounts();
    }
    
    public Discount getActiveDiscountsByID(Long productId) 
    {
        return discountDao.getActiveDiscountsByID(productId);
    }
    
    public String addDiscount(Discount discount) 
    {
        return discountDao.saveDiscount(discount);
    }
    
   
}
