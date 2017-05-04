package com.prodTOI.urs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prodTOI.urs.model.Producttype;
import com.prodTOI.urs.service.ProductTypeService;

@RestController
public class ProductTypeController {
	@Autowired
	
	private ProductTypeService productServiceAuto;
	
	@RequestMapping(value = "/createProductType", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producttype>createOneProductType(@RequestBody Producttype productType){
		Producttype productTypeObj = new Producttype();
		productTypeObj.setProductType(productType.getProductType());
		productServiceAuto.saveProductType(productTypeObj);
		return new ResponseEntity<Producttype>(productTypeObj,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getProductType/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producttype> getProductType(@PathVariable("id") Integer productTypeId){
		Producttype productTypeObj = productServiceAuto.findProductTypeById(productTypeId);
		return new ResponseEntity<Producttype>(productTypeObj,HttpStatus.OK);
		
	}
	@RequestMapping(value="/deleteProductTypey/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Producttype> deleteProductType(@PathVariable("id") Integer productTypeId){
		Producttype object = productServiceAuto.findProductTypeById(productTypeId);
		productServiceAuto.deleteProductTypeById(object);
		return new ResponseEntity<Producttype>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateProductType", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producttype> updateProductType(@RequestBody Producttype productType){
		Producttype updateProductType =productServiceAuto.findProductTypeById(productType.getProductTypeId());
		if(updateProductType == null){
			return new ResponseEntity<Producttype>(HttpStatus.NO_CONTENT);
		}
		updateProductType.setProductType(productType.getProductType());
		productServiceAuto.updateProductTypeById(updateProductType);
		return new ResponseEntity<Producttype>(updateProductType,HttpStatus.OK);
	}
	
	@RequestMapping(value = "getAllProductType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Producttype>> getAllProductType() {
		List<Producttype> allProductTypeList = productServiceAuto.findAllProductType();
		return new ResponseEntity<List<Producttype>>(allProductTypeList, HttpStatus.OK);
	}
	
	
	
}
