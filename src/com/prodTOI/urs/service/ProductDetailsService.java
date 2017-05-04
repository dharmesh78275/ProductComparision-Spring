package com.prodTOI.urs.service;

import java.util.List;

import com.prodTOI.urs.model.ProductDetail;
import com.prodTOI.urs.model.Producttype;

public interface ProductDetailsService {

	List<ProductDetail> findAllProductDetails();
	
	public ProductDetail findProductDetailsById(int productDetailsId);
	
	public void deleteProductDetailsById(ProductDetail productDetailsId);
}
