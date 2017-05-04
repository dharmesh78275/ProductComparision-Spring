package com.prodTOI.urs.service;

import java.util.List;

import com.prodTOI.urs.model.Attribute;
import com.prodTOI.urs.model.Producttype;

public interface AttributeService {

	Attribute findByAttributeId(int AttributeId);

	List<Attribute> findAllAttribute();

	void saveAttribute(Attribute attribute);
	
	public void deleteAttributeById(Attribute attributeId);
	
	public void updateAttributeById(Attribute attribute);
}
