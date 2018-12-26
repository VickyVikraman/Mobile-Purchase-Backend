package com.mobile.purchase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="cart")
@Table(name="cart")
public class CartEntity 
{
	@Id
	private int mobile_id;
	
	@Column(name="qty")
	private int qty;
	
	public int getMobile_id() {
		return mobile_id;
	}
	public void setMobile_id(int mobile_id) {
		this.mobile_id = mobile_id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
}
