package com.tka.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Integer stock;
    private String category;
    private Boolean isDiscountEligible;
	public Product() {
		super();
	}
	public Product(Long id, String name, Double price, Integer stock, String category, Boolean isDiscountEligible) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.category = category;
		this.isDiscountEligible = isDiscountEligible;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Boolean getIsDiscountEligible() {
		return isDiscountEligible;
	}
	public void setIsDiscountEligible(Boolean isDiscountEligible) {
		this.isDiscountEligible = isDiscountEligible;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", category="
				+ category + ", isDiscountEligible=" + isDiscountEligible + "]";
	}

    
    
}

