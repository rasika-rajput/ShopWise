package com.tka.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Sales;
import com.tka.service.SalesService;

@RestController
@RequestMapping("/sales")
public class SalesController 
{

	@Autowired
     SalesService salesService;
	
	@GetMapping("/allSales")
	public List<Sales> getAllSales()
	{
		return salesService.getAllSales();
	}
	
	@PostMapping("/addNewSale")
	public String addSale(@RequestBody Sales sale)
	{
		return salesService.addSale(sale);
	}
	
	@GetMapping("/salesReport/{startDate}/{endDate}")
	public List<Sales> salesReport(@PathVariable Date startDate, @PathVariable Date endDate)
	{
		return salesService.salesReport(startDate, endDate);
	}
	
	@GetMapping("/monthlySales/{month}")
	public List<Sales> monthlySales(@PathVariable int month)
	{
		return salesService.monthlySales(month);
	}
	
	@GetMapping("/unitsSoldInMonth/{productId}/{month}")
	public Long unitsSoldInMonth(@PathVariable int productId, @PathVariable int month)
	{
		return salesService.unitsSoldInMonth(productId, month);
	}

}
