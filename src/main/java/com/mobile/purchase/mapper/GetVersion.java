package com.mobile.purchase.mapper;

import org.springframework.stereotype.Component;

import com.mobile.purchase.model.OS;
import com.mobile.purchase.model.OsEntity;

@Component
public class GetVersion {
	
	public OS getVersion(OsEntity osEntity)
	{
		OS os = new OS();
		os.setName(osEntity.getName());
		os.setVersion(osEntity.getVersion());
		return os;
	}
	
	

}
