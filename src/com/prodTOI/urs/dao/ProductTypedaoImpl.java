package com.prodTOI.urs.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.prodTOI.urs.model.Producttype;

@Repository("productdao") //Repository name same as autowired in ServiceImpl
public class ProductTypedaoImpl extends AbstractDao<Integer, Producttype> implements ProductTypedao{

	@Override
	public void save(Producttype productType) {
		persist(productType);	
	}

	@Override
	public Producttype findProductTypeById(int productTypeId) {
		
		Producttype productTypeObj = getByKey(productTypeId);
		return productTypeObj;
	}

	@Override
	public void deleteProductTypeById(Producttype productTypeId) {
		delete(productTypeId);
		
	}

	@Override
	public void updateProductTypeById(Producttype productType) {
		update(productType);
		
	}

	@Override
	public List<Producttype> findByallProductType() {
		Criteria criteria = createEntityCriteria();
		List<Producttype> productType = (List<Producttype>) criteria.list();
		return productType;
		
	}

}
