package com.mobile.purchase.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobile.purchase.dao.AddToCart;
import com.mobile.purchase.dao.MobilePurchase;
import com.mobile.purchase.dao.OSDao;
import com.mobile.purchase.mapper.AddMobileServiceMapper;
import com.mobile.purchase.mapper.BuyMobileServiceMapper;
import com.mobile.purchase.mapper.CartMapper;
import com.mobile.purchase.mapper.GetAllMobile;
import com.mobile.purchase.mapper.GetVersion;
import com.mobile.purchase.mapper.UpdateMobile;
import com.mobile.purchase.model.Cart;
import com.mobile.purchase.model.CartEntity;
import com.mobile.purchase.model.Mobile;
import com.mobile.purchase.model.MobileEntity;
import com.mobile.purchase.model.OS;
import com.mobile.purchase.model.OsEntity;

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
		MobileEntity images = mobilePurchase.findByMobileId(mobile.getId());
		MobileEntity mobileEntity = updateMobileMapper.updateMobile(mobile,images.getImages());
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
		MobileEntity mobileEntity=null;
		for(int i=0;i<mobile.length;i++)
		{
			getMobileEntity=mobilePurchase.findByMobileId(mobile[i].getId());
			mobileEntity=buyMobileMapper.buyMobile(mobile[i],getMobileEntity);
			mobilePurchase.save(mobileEntity);
		}
	}
	
	@Autowired
	CartMapper cartMapper;
	
	@Autowired
	AddToCart addToCart;
	
	public long addMobileToCart(Cart cart)
	{
		CartEntity cartEntity = cartMapper.addMobileToCart(cart);
		addToCart.save(cartEntity);
		long length = addToCart.count();
		return length;
	}
	
	public Cart[] getCartItem()
	{
		List<CartEntity> cartEntity = new ArrayList<>();
		addToCart.findAll().forEach(e->cartEntity.add(e));
		
		Cart[] cart = new Cart[cartEntity.size()];
		int i=0;
		for(CartEntity cartItem:cartEntity)
		{
			cart[i]=cartMapper.getCartItem(cartItem);
			i++;
		}
		return cart;
	}
	
	public Mobile[] getMobileById(Cart cart[])
	{
		Mobile[] mobile = new Mobile[cart.length];
		MobileEntity mobileEntity=new MobileEntity();
		for(int i=0;i<cart.length;i++)
		{
			mobileEntity=mobilePurchase.findByMobileId(cart[i].getId());
			mobile[i]=cartMapper.getCartItemById(mobileEntity,cart[i].getQty());
		}
		return mobile;
	}
	
	public void deleteItem(int id)
	{
		addToCart.deleteById(id);
	}
	
	public boolean deleteAll(Cart cart[])
	{
		MobileEntity getMobileEntity=new MobileEntity();
		MobileEntity mobileEntity=null;
		for(int i=0;i<cart.length;i++)
		{
			getMobileEntity=mobilePurchase.findByMobileId(cart[i].getId());
			mobileEntity=buyMobileMapper.removeFromCart(cart[i].getQty(),getMobileEntity);
			mobilePurchase.save(mobileEntity);
		}
		addToCart.deleteAll();
		return true;
	}
	
	@Autowired
	OSDao osVersion;
	
	@Autowired
	GetVersion getVersion;
	
	public OS[] version(String osName)
	{
		List<OsEntity> osEntity=new ArrayList<>();
		osVersion.findAllByName(osName).forEach(e->osEntity.add(e));
		OS returnVersion[] = new OS[osEntity.size()];
		int i=0;
		
		for(OsEntity versions : osEntity)
		{
			returnVersion[i]=getVersion.getVersion(versions);
			i++;
			System.out.println(versions.getVersion());
		}
		
		
		return returnVersion;
	}
	
	
}
