package com.tka.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Sales;

@Repository
public class SalesDao
{
	@Autowired
	SessionFactory sessionFactory;

	public List<Sales> getAllSales() 
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Sales.class);
		List<Sales> allSales = criteria.list();
		
		return allSales;
	}
	
	public String addSale(Sales sale)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(sale);
		transaction.commit();
		session.close();
		
		return "New Sale Added Successfully...!!!";
	}
	
	public List<Sales> salesReport(Date startDate, Date endDate) 
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Sales.class);
		criteria.add(Restrictions.between("purchaseDate", startDate, endDate));
		List<Sales> report = criteria.list();
		
		return report;
	}

	public List<Sales> monthlySales(int month) 
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Sales.class);
		criteria.add(Restrictions.eq("month", month));
		List<Sales> report = criteria.list();
		
		return report;
	}

	public Long unitsSoldInMonth(int productId, int month) 
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Sales.class);
		criteria.add(Restrictions.eq("month", month));
		criteria.add(Restrictions.eq("productId", productId));
		
		criteria.setProjection(Projections.sum("quantity"));
	    Long totalUnits = (Long) criteria.uniqueResult();
	
		return totalUnits;
	}

}
