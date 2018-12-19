package com.mobile.purchase.mapper;

import org.springframework.stereotype.Component;

import com.mobile.purchase.model.Mobile;
import com.mobile.purchase.model.MobileEntity;

@Component
public class BuyMobileServiceMapper {
	
	public MobileEntity buyMobile(Mobile mobile,MobileEntity mobileEntity)
	{
		MobileEntity updateMobileEntity = new MobileEntity();
		updateMobileEntity.setMobileId(mobile.getId());
		updateMobileEntity.setName(mobile.getName());
		updateMobileEntity.setManufacturer(mobile.getManufacturer());
		updateMobileEntity.setBattery(mobile.getBattery());
		updateMobileEntity.setWeight(mobile.getWeight());
		updateMobileEntity.setOs(mobile.getOs());
		updateMobileEntity.setRam(mobile.getStorage().getRam());
		updateMobileEntity.setInternal(mobile.getStorage().getInternal());
		updateMobileEntity.setExpandable(mobile.getStorage().getExpandable());
		updateMobileEntity.setWidth(mobile.getDimension().getWidth());
		updateMobileEntity.setDepth(mobile.getDimension().getDepth());
		updateMobileEntity.setHeight(mobile.getDimension().getHeight());
		updateMobileEntity.setStock(mobile.getStock()-mobile.getQty());
		updateMobileEntity.setPrice(mobile.getPrice());
		updateMobileEntity.setImages(mobileEntity.getImages());
		return updateMobileEntity;
	}

}
