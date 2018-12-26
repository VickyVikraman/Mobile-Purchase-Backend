package com.mobile.purchase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.purchase.Impl.MobileService;
import com.mobile.purchase.model.Cart;
import com.mobile.purchase.model.Mobile;
import com.mobile.purchase.model.OS;

@RestController
public class MobilePurchaseController {
	
	@Autowired
	MobileService mobileService;
	
	@RequestMapping(value="/add")
	@CrossOrigin(origins = "http://localhost:4200")
	public void addMobile(@RequestBody Mobile mobile )
	{
		mobile = mobileService.add(mobile);	
	}
	
	@RequestMapping(value="/get")
	@CrossOrigin(origins = "http://localhost:4200")
	public Mobile[] getAllMobiles()
	{
		return mobileService.getAllMobiles();
	}
	
	@RequestMapping(value="/update")
	@CrossOrigin(origins = "http://localhost:4200")
	public void updateMobile(@RequestBody Mobile mobile)
	{
		mobileService.updateMobile(mobile);
		System.out.println("success");
	}
	
	@RequestMapping(value="/delete")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteMobile(@RequestParam int id)
	{
		System.out.println(id);
		mobileService.deleteMobile(id);
	}
	
	@RequestMapping(value="/buy")
	@CrossOrigin(origins = "http://localhost:4200")
	public void buyNow(@RequestBody Mobile[] mobile)
	{
		mobileService.buyMobile(mobile);
	}
	
	@RequestMapping(value="/getCartItem")
	@CrossOrigin(origins = "http://localhost:4200")
	public Cart[] getCartItem()
	{
		return mobileService.getCartItem();
	}
	
	@RequestMapping(value="/addToCart")
	@CrossOrigin(origins = "http://localhost:4200")
	public long addToCart(@RequestBody Cart cart)
	{
		return mobileService.addMobileToCart(cart);
	}
	
	
	@RequestMapping(value="/getItemByIds")
	@CrossOrigin(origins = "http://localhost:4200")
	public Mobile[] getCartItemsById(@RequestBody Cart[] cart)
	{
		return mobileService.getMobileById(cart);
	}
	
	@RequestMapping(value="/deleteItem")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteItem(@RequestParam int id)
	{
		mobileService.deleteItem(id);
	}
	
	@RequestMapping(value="/deleteAll")
	@CrossOrigin(origins = "http://localhost:4200")
	public boolean deleteAll(@RequestBody Cart[] cart)
	{
		
		return mobileService.deleteAll(cart);
	}
	
	@RequestMapping(value="/version")
	@CrossOrigin(origins = "http://localhost:4200")
	public OS[] version(@RequestParam String os)
	{
		return mobileService.version(os);
	}
}
