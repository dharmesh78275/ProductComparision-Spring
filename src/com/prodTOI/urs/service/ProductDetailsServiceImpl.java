package com.prodTOI.urs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prodTOI.urs.dao.ProductDetailsdao;
import com.prodTOI.urs.model.ProductDetail;

@Service("productDetailsService")
@Transactional
public class ProductDetailsServiceImpl implements ProductDetailsService {
	
	@Autowired
	private ProductDetailsdao productDetailsDao;

	@Override
	public List<ProductDetail> findAllProductDetails() {
		return productDetailsDao.findAllProductDetails();
	}

	@Override
	public ProductDetail findProductDetailsById(int productDetailsId) {
		ProductDetail productDetailsObj = productDetailsDao.findProductDetailsById(productDetailsId);
		return productDetailsObj;
	}

	@Override
	public void deleteProductDetailsById(ProductDetail productDetailsId) {
		ProductDetail productDetails = productDetailsDao.findProductDetailsById(productDetailsId.getId());
		productDetailsDao.deleteProductDetailsById(productDetails);
		
	}



}
