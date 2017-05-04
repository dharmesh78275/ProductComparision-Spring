package com.prodTOI.urs.service;

import java.util.List;

import com.prodTOI.urs.model.Producttype;

public interface ProductTypeService {

	void saveProductType(Producttype productType);

	public Producttype findProductTypeById(int productTypeId);

	public void deleteProductTypeById(Producttype productTypeId);

	void updateProductTypeById(Producttype updateProductType);

	List<Producttype> findAllProductType();

}
