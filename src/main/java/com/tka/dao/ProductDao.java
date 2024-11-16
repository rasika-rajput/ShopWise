package com.tka.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Product;

@Repository
public class ProductDao 
{

    @Autowired
    SessionFactory sessionFactory;

    public List<Product> getAllProducts()
    {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Product.class);
        List<Product> products = criteria.list();
        session.close();
        return products;
    }
    
    public List<Product> productsOutOfStock() 
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Product.class);
		List<Product> products = criteria.list(); 
		
		List<Product> outOfStock = new ArrayList();
				
		for (Product product : products) 
		{
			if(product.getStock() < 10)
			{
				outOfStock.add(product);
			}
		}
		return outOfStock;
	}
	
    public String updateProduct(Product product) 
	{
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(product);
        
		transaction.commit();
	    session.close();
		return "Product Updated Successfully";
		
	}
    
    public String addProduct(Product product) 
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        session.close();
        
        return "Product Added Successfully...!!!";
    }

    public Product getProductByID(Long id) 
    {
        Session session = sessionFactory.openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }

    public String updateProductPriceBasedOnStock(Long id, Product product) 
    {
    	String msg = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        product = session.get(Product.class, id);
       
       
            if (product.getStock() < 10) 
            {
                msg = "Product is Out Of Stock...";
            }
            if (product.getStock() < 20) 
            {
                msg = "Alert..... Restock The Product";
            }
            if (product.getStock() > 1000)
            {
                product.setPrice(product.getPrice() - (product.getPrice()*5/100));
                session.update(product);
				msg = "Reduced The Price for Product " +product.getName() +" by 5%  =  Rs." +product.getPrice();
            } 
            else if (product.getStock() < 50) 
            {
                product.setPrice(product.getPrice() + (product.getPrice()*5/100));
                session.update(product);           
				msg = "Increased The Price for Product " +product.getName() +" by 5%  =  Rs." +product.getPrice();
            }
            transaction.commit();
            session.close();
           
            return msg;
    }

    public List<Product> getLowStockProducts() 
    {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Product.class);
        criteria.add(Restrictions.lt("stock", 20));
        List<Product> products = criteria.list();
        session.close();
        return products;
    }

    public String deleteProduct(Long id) 
    {
    	String msg = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product = session.get(Product.class, id);
        if (product != null) 
        {
            session.delete(product);
            msg = "Product Deleted Successfully...!!!";
        }
        else
        {
        	msg = "Product Not Found With ID : " +id;
        }
        transaction.commit();
        session.close();
        
		return msg;
    }
}