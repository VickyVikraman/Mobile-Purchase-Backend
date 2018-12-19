package com.mobile.purchase.mapper;

import org.springframework.stereotype.Component;

import com.mobile.purchase.model.Mobile;
import com.mobile.purchase.model.MobileEntity;

@Component
public class UpdateMobile {
	
	public MobileEntity updateMobile(Mobile mobile)
	{
		MobileEntity mobileEntity = new MobileEntity();
		mobileEntity.setMobileId(mobile.getId());
		mobileEntity.setName(mobile.getName());
		mobileEntity.setManufacturer(mobile.getManufacturer());
		mobileEntity.setBattery(mobile.getBattery());
		mobileEntity.setWeight(mobile.getWeight());
		mobileEntity.setOs(mobile.getOs());
		mobileEntity.setRam(mobile.getStorage().getRam());
		mobileEntity.setInternal(mobile.getStorage().getInternal());
		mobileEntity.setExpandable(mobile.getStorage().getExpandable());
		mobileEntity.setWidth(mobile.getDimension().getWidth());
		mobileEntity.setDepth(mobile.getDimension().getDepth());
		mobileEntity.setHeight(mobile.getDimension().getHeight());
		mobileEntity.setStock(mobile.getStock());
		mobileEntity.setPrice(mobile.getPrice());
		return mobileEntity;
	}

}
