package com.prodTOI.urs.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.prodTOI.urs.model.Attribute;

@Repository("attributeDao")
public class AttributedaoImpl extends AbstractDao<Integer, Attribute> implements Attributedao{

	@Override
	public Attribute findByAttributeId(int AttributeId) {
		
		Attribute attribute = getByKey(AttributeId);
		return attribute;
	}

	@Override
	public List<Attribute> findByallAttribute() {
		
		Criteria criteria = createEntityCriteria();
		List<Attribute> attribute = (List<Attribute>) criteria.list();
		return attribute;
	}

	@Override
	public void save(Attribute attribute) {
		persist(attribute);
		
	}

	@Override
	public void deleteAttributeById(Attribute attributeId) {
		delete(attributeId);
	}

	@Override
	public void updateAttributeById(Attribute attribute) {
		update(attribute);
		
	}

}
