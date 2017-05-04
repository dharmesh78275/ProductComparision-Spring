package com.prodTOI.urs.dao;

import java.util.List;

import com.prodTOI.urs.model.Producttype;

public interface ProductTypedao {

	void save(Producttype productType);

	public Producttype findProductTypeById(int productTypeId);

	public void deleteProductTypeById(Producttype productTypeId);
	
	void updateProductTypeById(Producttype productType);
	
	List<Producttype> findByallProductType();
}
