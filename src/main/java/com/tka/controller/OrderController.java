package com.tka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController 
{

    @Autowired
     OrderService orderService;

    @PostMapping("/placeOrder/{productId}/{quantity}")
    public String placeOrder(@PathVariable Long productId, @PathVariable int quantity) 
    {
        return orderService.placeOrder(productId, quantity);
    }
}

