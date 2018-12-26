package com.mobile.purchase.model;

import java.util.List;

public class Cart {
	
	private int id;
	private int qty;
	private List<Integer> mobileId;
	
	

	public List<Integer> getMobileId() {
		return mobileId;
	}
	public void setMobileId(List<Integer> mobileId) {
		this.mobileId = mobileId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	

}
