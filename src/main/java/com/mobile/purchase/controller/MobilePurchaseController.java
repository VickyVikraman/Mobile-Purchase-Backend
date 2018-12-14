package com.mobile.purchase.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mobile.purchase.Impl.MobileService;
import com.mobile.purchase.model.Mobile;

@RestController
public class MobilePurchaseController {
	
	private final Path rootLocation = Paths.get("ProfilePictureStore");
	@Autowired
	MobileService mobileService;
	
	@RequestMapping(value="/add")
	public void addMobile(@RequestBody Mobile mobile )
	{
		mobile = mobileService.add(mobile);	
	}
	
	@RequestMapping(value="/get")
	public Mobile[] getAllMobiles()
	{
		return mobileService.getAllMobiles();
	}
	
	
	@RequestMapping(value="/update")
	public void updateMobile(@RequestBody Mobile mobile)
	{
		mobileService.updateMobile(mobile);
		System.out.println("success");
	}
	
	
	@RequestMapping(value="/delete")
	public void deleteMobile(@RequestParam int id)
	{
		System.out.println(id);
		mobileService.deleteMobile(id);
	}
	
	
}
