package com.tka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService 
{

    @Autowired
     JavaMailSender mailSender;

    public void sendStockAlert(String toEmail, String productName, int stock) 
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Restock Alert: " + productName);
        message.setText("The stock of product " + productName + " has dropped below the minimum threshold. Current stock: " + stock + ". Please restock.");

        mailSender.send(message);
    }
}

