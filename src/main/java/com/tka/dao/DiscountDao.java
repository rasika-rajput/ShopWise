package com.tka.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Discount;
import com.tka.entity.Product;

@Repository
public class DiscountDao 
{

    @Autowired
    SessionFactory sessionFactory;
    
    @Autowired
	ProductDao productDao;
    
    public List<Discount> getAllDiscounts()
    {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Discount.class);
        List<Discount> discounts = criteria.list();
        session.close();
        
        return discounts;
    }
    public Discount getDiscountByID(Long id)
    {
        Session session = sessionFactory.openSession();
        Discount discount = session.get(Discount.class, id);
        session.close();
        
        return discount;
    }
    
    public List<Discount> getActiveDiscounts() 
    {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Discount.class);
        criteria.add(Restrictions.eq("isActive", true));
        criteria.add(Restrictions.ge("validTo", new Date()));
        List<Discount> discounts = criteria.list();
        
        session.close();
        return discounts;
    }
    
    public Discount getActiveDiscountsByID(Long productId) 
    {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Discount.class);
        criteria.add(Restrictions.eq("productId", productId));
        criteria.add(Restrictions.eq("isActive", true));
        criteria.add(Restrictions.ge("validTo", new Date()));
        Discount discount = (Discount) criteria.uniqueResult();
        
        session.close();
        return discount;
    }

    public String saveDiscount(Discount discount)
    {
    	String msg = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        if (discount.getDiscountPercentage() < 0 || discount.getDiscountPercentage() > 30) 
        {
        	msg = "Discount percentage must be between 0 and 30";
        }
        else
        {
        	session.save(discount);
        	msg = "Discount Saved Successfully...!!!";
        }
        
        transaction.commit();
        session.close();
		return msg;
    }

   
}
