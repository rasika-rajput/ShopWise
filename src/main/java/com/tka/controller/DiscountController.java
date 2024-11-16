package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Discount;
import com.tka.service.DiscountService;

@RestController
@RequestMapping("/discounts")
public class DiscountController 
{

    @Autowired
    DiscountService discountService;

    @GetMapping("/getAllDiscounts")
    public List<Discount> getAllDiscounts()
    {
        return discountService.getAllDiscounts();
    }
    
    @GetMapping("/getDiscountByID/{id}")
    public Discount getDiscountByID(@PathVariable Long id)
    {
        return discountService.getDiscountByID(id);
    }
    
    @GetMapping("/getActiveDiscounts")
    public List<Discount> getActiveDiscounts() 
    {
        return discountService.getActiveDiscounts();
    }
    
    @GetMapping("/getActiveDiscountsByID/{productId}")
    public Discount getActiveDiscountsByID(@PathVariable Long productId) 
    {
        return discountService.getActiveDiscountsByID(productId);
    }
    
    @PostMapping("/addDiscount")
    public String addDiscount(@RequestBody Discount discount) 
    {
        return discountService.addDiscount(discount);
    }
    
   
}
