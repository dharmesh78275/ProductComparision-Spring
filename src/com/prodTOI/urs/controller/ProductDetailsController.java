package com.prodTOI.urs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prodTOI.urs.model.ProductDetail;
import com.prodTOI.urs.model.Producttype;
import com.prodTOI.urs.service.ProductDetailsService;

@RestController
public class ProductDetailsController {

	@Autowired
	private ProductDetailsService productDetailsService;

	@RequestMapping(value = "/getProductDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDetail>> findAllProductDetails() {
		List<ProductDetail> productDetailList = productDetailsService.findAllProductDetails();
		return new ResponseEntity<List<ProductDetail>>(productDetailList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getproductDetailsById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDetail> getproductDetailsById(@PathVariable("id") Integer productDetailsId){
		ProductDetail productDetailsObj = productDetailsService.findProductDetailsById(productDetailsId);
		return new ResponseEntity<ProductDetail>(productDetailsObj,HttpStatus.OK);	
	}
	
	@RequestMapping(value="/deleteProductDetails/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<ProductDetail> deleteProductDetails(@PathVariable("id") Integer productDetailsId){
		ProductDetail productDetails = productDetailsService.findProductDetailsById(productDetailsId);
		productDetailsService.deleteProductDetailsById(productDetails);
		return new ResponseEntity<ProductDetail>(HttpStatus.OK);
	}
}
