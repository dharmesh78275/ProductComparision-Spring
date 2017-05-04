package com.prodTOI.urs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prodTOI.urs.dao.ProductTypedao;
import com.prodTOI.urs.model.Producttype;

@Service("productTypeService")
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypedao productdao;

	@Override
	public void saveProductType(Producttype productType) {
		productdao.save(productType);

	}

	@Override
	public Producttype findProductTypeById(int productTypeId) {
		Producttype productTypeObj = productdao.findProductTypeById(productTypeId);
		return productTypeObj;
	}

	@Override
	public void deleteProductTypeById(Producttype productTypeId) {
		Producttype productType = productdao.findProductTypeById(productTypeId.getProductTypeId());
		productdao.deleteProductTypeById(productType);
		
	}

	@Override
	public void updateProductTypeById(Producttype updateProductType) {
		productdao.updateProductTypeById(updateProductType);
		
	}

	@Override
	public List<Producttype> findAllProductType() {
		
		return productdao.findByallProductType();
	}

}
