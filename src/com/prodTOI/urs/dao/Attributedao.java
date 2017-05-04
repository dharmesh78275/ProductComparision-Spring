package com.prodTOI.urs.dao;

import java.util.List;

import com.prodTOI.urs.model.Attribute;
import com.prodTOI.urs.model.Category;
import com.prodTOI.urs.model.Producttype;

public interface Attributedao {
	
	Attribute findByAttributeId(int AttributeId);
	
	List<Attribute> findByallAttribute();
	
	void save(Attribute attribute);
	
	public void deleteAttributeById(Attribute attributeId);
	
	public void updateAttributeById(Attribute attribute);

}
