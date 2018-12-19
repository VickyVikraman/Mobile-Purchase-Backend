package com.mobile.purchase.mapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.mobile.purchase.model.Dimension;
import com.mobile.purchase.model.Mobile;
import com.mobile.purchase.model.MobileEntity;
import com.mobile.purchase.model.Storage;

@Component
public class GetAllMobile {
	
	String base64Image;
	String pathFile;
	public Mobile getMobile(MobileEntity mobileDetails)
	{
		Mobile mobile=new Mobile();
		mobile.setId(mobileDetails.getMobileId());
		mobile.setName(mobileDetails.getName());
		mobile.setManufacturer(mobileDetails.getManufacturer());
		mobile.setOs(mobileDetails.getOs());
		mobile.setBattery(mobileDetails.getBattery());
		mobile.setWeight(mobileDetails.getWeight());
		
		Storage storage = new Storage();
		storage.setRam(mobileDetails.getRam());
		storage.setInternal(mobileDetails.getInternal());
		storage.setExpandable(mobileDetails.getExpandable());
		mobile.setStorage(storage);
		
		Dimension dimension = new Dimension();
		dimension.setWidth(mobileDetails.getWidth());
		dimension.setDepth(mobileDetails.getDepth());
		dimension.setHeight(mobileDetails.getHeight());
		mobile.setDimension(dimension);
		
		mobile.setPrice(mobileDetails.getPrice());
		mobile.setStock(mobileDetails.getStock());
		
		List<String> file = changeIndexToBase64(mobileDetails.getImages(),mobileDetails.getManufacturer());
		mobile.setFile(file);
		return mobile;
	}
	public List<String> changeIndexToBase64(String imageIndex,String folderName)
	{
		List<String> images = new ArrayList<>();
		Pattern p = Pattern.compile("-?\\d+");
		java.util.regex.Matcher m = p.matcher(imageIndex);
		while (m.find()) {
		  images.add(imageToBase64(m.group()+".jpg",folderName));
		}		
		return images;
	}
	
	public String imageToBase64(String imageName,String folderName)
	{
		pathFile="E:\\Mobile_Purchase_Images/"+folderName+"/"+imageName;
		File file = new File(pathFile);
		try (FileInputStream imageInFile = new FileInputStream(file)) {
			// Reading a Image file from file system
			byte imageData[] = new byte[(int) file.length()];
			imageInFile.read(imageData);
			base64Image = Base64.getEncoder().encodeToString(imageData);
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
		return "data:image/jpeg;base64,"+base64Image;
	}
	
}
