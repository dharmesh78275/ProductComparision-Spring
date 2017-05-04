package com.prodTOI.urs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prodTOI.urs.dao.Attributedao;
import com.prodTOI.urs.model.Attribute;

@Service("attributeService")
@Transactional
public class AttributeServiceImpl implements AttributeService {

	@Autowired
	private Attributedao attributeDao;

	@Override
	public Attribute findByAttributeId(int AttributeId) {
		Attribute attributeObj = attributeDao.findByAttributeId(AttributeId);
		return attributeObj;
	}

	@Override
	public List<Attribute> findAllAttribute() {
		return attributeDao.findByallAttribute();
	}

	@Override
	public void saveAttribute(Attribute attribute) {
		attributeDao.save(attribute);
		
	}

	@Override
	public void deleteAttributeById(Attribute attributeId) {
		Attribute attribute = attributeDao.findByAttributeId(attributeId.getAttrubuteId());
		attributeDao.deleteAttributeById(attribute);
		
	}

	@Override
	public void updateAttributeById(Attribute attribute) {
		attributeDao.updateAttributeById(attribute);
		
	}

}
