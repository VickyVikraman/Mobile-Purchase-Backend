package com.mobile.purchase.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mobile.purchase.model.OsEntity;

public interface OSDao extends CrudRepository<OsEntity, String> {
	
	List<OsEntity> findByName(String os	);
	
	List<OsEntity> findAllByName(String os);

}
