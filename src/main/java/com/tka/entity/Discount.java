package com.tka.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private Double discountPercentage;
    private Date validFrom;
    private Date validTo;
    private Boolean isActive;
	public Discount() {
		super();
	}
	public Discount(Long id, Long productId, Double discountPercentage, Date validFrom, Date validTo,
			Boolean isActive) {
		super();
		this.id = id;
		this.productId = productId;
		this.discountPercentage = discountPercentage;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.isActive = isActive;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	public Date getValidTo() {
		return validTo;
	}
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Discount [id=" + id + ", productId=" + productId + ", discountPercentage=" + discountPercentage
				+ ", validFrom=" + validFrom + ", validTo=" + validTo + ", isActive=" + isActive + "]";
	}

    
    
}

