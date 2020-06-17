package com.sg.fixmastery.product;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	private String productcode;
	private String name;
	private String exchange;
	private String category;
	private String subcategory;
	private String CLASS;
	private String sze;
	
	public String getProductcode() {
		return productcode;
	}
	public String getName() {
		return name;
	}
	public String getExchange() {
		return exchange;
	}
	public String getCategory() {
		return category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public String getCLASS() {
		return CLASS;
	}
	public String getSze() {
		return sze;
	}
	
	
}
