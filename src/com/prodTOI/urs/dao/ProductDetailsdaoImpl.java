package com.prodTOI.urs.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.prodTOI.urs.model.ProductDetail;

@Repository("productDetailsDao")
public class ProductDetailsdaoImpl extends AbstractDao<Integer, ProductDetail> implements ProductDetailsdao {

	@Override
	public List<ProductDetail> findAllProductDetails() {
		Criteria criteria = createEntityCriteria();
		List<ProductDetail> productList = (List<ProductDetail>) criteria.list();
		return productList;
	}

	@Override
	public ProductDetail findProductDetailsById(int productDetailsId) {
		ProductDetail productDetailsObj = getByKey(productDetailsId);
		return productDetailsObj;
	}

	@Override
	public void deleteProductDetailsById(ProductDetail productDetailsId) {
		delete(productDetailsId);

	}

}
