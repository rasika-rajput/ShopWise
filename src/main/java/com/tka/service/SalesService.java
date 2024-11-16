package com.tka.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.SalesDao;
import com.tka.entity.Sales;

@Service
public class SalesService 
{

	@Autowired
	SalesDao salesDao;
	
	public List<Sales> getAllSales() 
	{
		return salesDao.getAllSales();
	}
	
	public String addSale(Sales sale)
	{
		return salesDao.addSale(sale);
	}

	public List<Sales> salesReport(Date startDate, Date endDate) 
	{
		return salesDao.salesReport(startDate, endDate);
	}

	public List<Sales> monthlySales(int month) 
	{
		return salesDao.monthlySales(month);
	}

	public Long unitsSoldInMonth(int productId, int month) 
	{
		return salesDao.unitsSoldInMonth(productId, month);
	}

}
