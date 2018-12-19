package com.mobile.purchase.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mobile.purchase.model.MobileEntity;

public interface MobilePurchase extends CrudRepository<MobileEntity, Integer> {
	
	public MobileEntity findByMobileId(int id);
	

}
