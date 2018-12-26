package com.mobile.purchase.dao;

import org.springframework.data.repository.CrudRepository;

import com.mobile.purchase.model.CartEntity;

public interface AddToCart extends CrudRepository<CartEntity, Integer> {

}
