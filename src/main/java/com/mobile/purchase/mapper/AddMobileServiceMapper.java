package com.mobile.purchase.mapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mobile.purchase.model.Mobile;
import com.mobile.purchase.model.MobileEntity;

@Component
public class AddMobileServiceMapper {
	
	
	public MobileEntity addMobile(Mobile mobile)
	{
		MobileEntity mobileEntity = new MobileEntity();
		mobileEntity.setName(mobile.getName());
		mobileEntity.setManufacturer(mobile.getManufacturer());
		mobileEntity.setOs(mobile.getOs());
		mobileEntity.setBattery(mobile.getBattery());
		mobileEntity.setWeight(mobile.getWeight());
		mobileEntity.setRam(mobile.getStorage().getRam());
		mobileEntity.setInternal(mobile.getStorage().getInternal());
		mobileEntity.setExpandable(mobile.getStorage().getExpandable());
		mobileEntity.setWidth(mobile.getDimension().getWidth());
		mobileEntity.setDepth(mobile.getDimension().getDepth());
		mobileEntity.setHeight(mobile.getDimension().getHeight());
		mobileEntity.setStock(mobile.getStock());
		mobileEntity.setPrice(mobile.getPrice());
		String imageNames=base64ToImg(mobile.getFile(),mobile.getManufacturer());
		mobileEntity.setImages(imageNames);
		return mobileEntity;
	}
	
	public String base64ToImg(List<String> base64,String name)
	{
		String base64ImageString=null;
		int[] nameIndex = new int[base64.size()];
		String pathFile="E:\\Mobile_Purchase_Images";
		for(int i=0;i<base64.size();i++)
		{
			base64ImageString = base64.get(i);
			File file = new File(pathFile+"/"+name);
			 if (!file.exists()) 
			 {
	            file.mkdir();
	         }
			 try (FileOutputStream imageOutFile = new FileOutputStream(file+"/"+i+".jpg")) 
			 {
				nameIndex[i]=i; 
				byte[] imageByteArray = Base64.getDecoder().decode(base64ImageString);
				imageOutFile.write(imageByteArray);
    		}
		    catch (FileNotFoundException e) 
			{
				System.out.println("Image not found" + e);
			}
			catch (IOException ioe) 
			{
				System.out.println("Exception while reading the Image " + ioe);
    		}
               
		}
//		System.out.println(nameIndex.toString());
		return  Arrays.toString(nameIndex);
	}

}
