package com.mobile.purchase.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobile.purchase.dao.MobilePurchase;
import com.mobile.purchase.mapper.AddMobileServiceMapper;
import com.mobile.purchase.mapper.BuyMobileServiceMapper;
import com.mobile.purchase.mapper.GetAllMobile;
import com.mobile.purchase.mapper.UpdateMobile;
import com.mobile.purchase.model.Mobile;
import com.mobile.purchase.model.MobileEntity;

@Component
public class MobileService {
	
	@Autowired
	MobilePurchase mobilePurchase;
	
	@Autowired
	AddMobileServiceMapper addMobileServiceMapper;
	
	public Mobile add(Mobile mobile)
	{
		MobileEntity mobileEntity = addMobileServiceMapper.addMobile(mobile);
		
		mobilePurchase.save(mobileEntity);
		
		return null;
	}
	
	@Autowired
	GetAllMobile getAllMobile;
	
	public Mobile[] getAllMobiles()
	{
		
		List<MobileEntity> allMobiles = new ArrayList<>();
		mobilePurchase.findAll().forEach(e->allMobiles.add(e));
		
		Mobile[] returnMobile = new Mobile[allMobiles.size()];
		int i=0;
		
		
		for(MobileEntity mobile : allMobiles)
		{
			returnMobile[i] = getAllMobile.getMobile(mobile);
			i++;
		}
		return returnMobile;
	}
	
	@Autowired
	UpdateMobile updateMobileMapper;
	
	public void updateMobile(Mobile mobile)
	{
		MobileEntity mobileEntity = updateMobileMapper.updateMobile(mobile);
		mobilePurchase.save(mobileEntity);
	}
	
	public void deleteMobile(int id)
	{
		mobilePurchase.deleteById(id);
	}
	
	@Autowired
	BuyMobileServiceMapper buyMobileMapper;
	
	public void buyMobile(Mobile[] mobile)
	{
		MobileEntity getMobileEntity=new MobileEntity();
		Mobile getMobile = new Mobile();
		MobileEntity mobileEntity=null;
		for(int i=0;i<mobile.length;i++)
		{
			getMobileEntity=mobilePurchase.findByMobileId(mobile[i].getId());
			mobileEntity=buyMobileMapper.buyMobile(mobile[i],getMobileEntity);
			mobilePurchase.save(mobileEntity);
		}
	}
	
	
}
