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

import com.prodTOI.urs.model.Attribute;
import com.prodTOI.urs.model.Producttype;
import com.prodTOI.urs.service.AttributeService;

@RestController
public class AttributeController {
	@Autowired
	private AttributeService attributeService;

	@RequestMapping(value = "/getAttribute/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Attribute> getAttribute(@PathVariable("id") Integer attributeId) {
		Attribute attribute = attributeService.findByAttributeId(attributeId);
		return new ResponseEntity<Attribute>(attribute, HttpStatus.OK);
	}

	@RequestMapping(value = "getAllAttribute", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Attribute>> getAllAttributeList() {
		List<Attribute> allAttributeList = attributeService.findAllAttribute();
		return new ResponseEntity<List<Attribute>>(allAttributeList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/createAttribute", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Attribute> createOneAttribute(@RequestBody Attribute attribute) {
		Attribute newAttribute = new Attribute();
		newAttribute.setAttributes(attribute.getAttributes());
		newAttribute.setValue(attribute.getValue());
		attributeService.saveAttribute(newAttribute);
		return new ResponseEntity<Attribute>(newAttribute,HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteAttribute/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Attribute> deleteAttribute(@PathVariable("id") Integer AttributeId){
		Attribute attributeObj = attributeService.findByAttributeId(AttributeId);
		attributeService.deleteAttributeById(attributeObj);
		return new ResponseEntity<Attribute>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/updateAttribute", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Attribute> updateAttribute(@RequestBody Attribute attribute){
		Attribute attributeObj = attributeService.findByAttributeId(attribute.getAttrubuteId());
		if(attributeObj == null){
			return new ResponseEntity<Attribute>(HttpStatus.NO_CONTENT);
		}
		attributeObj.setAttributes(attribute.getAttributes());
		attributeService.updateAttributeById(attributeObj);
		return new ResponseEntity<Attribute>(attributeObj,HttpStatus.OK);
	}
	

}
