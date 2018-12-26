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
	
	public MobileEntity removeFromCart(int qty,MobileEntity mobileEntity)
	{
		MobileEntity updateMobileEntity = new MobileEntity();
		updateMobileEntity.setMobileId(mobileEntity.getMobileId());
		updateMobileEntity.setName(mobileEntity.getName());
		updateMobileEntity.setManufacturer(mobileEntity.getManufacturer());
		updateMobileEntity.setBattery(mobileEntity.getBattery());
		updateMobileEntity.setWeight(mobileEntity.getWeight());
		updateMobileEntity.setOs(mobileEntity.getOs());
		updateMobileEntity.setRam(mobileEntity.getRam());
		updateMobileEntity.setInternal(mobileEntity.getInternal());
		updateMobileEntity.setExpandable(mobileEntity.getExpandable());
		updateMobileEntity.setWidth(mobileEntity.getWidth());
		updateMobileEntity.setDepth(mobileEntity.getDepth());
		updateMobileEntity.setHeight(mobileEntity.getHeight());
		updateMobileEntity.setStock(mobileEntity.getStock()-qty);
		updateMobileEntity.setPrice(mobileEntity.getPrice());
		updateMobileEntity.setImages(mobileEntity.getImages());
		return updateMobileEntity;
	}

}
