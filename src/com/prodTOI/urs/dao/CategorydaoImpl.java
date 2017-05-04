package com.prodTOI.urs.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.prodTOI.urs.model.Category;

@Repository("categorydao")
public class CategorydaoImpl extends AbstractDao<Integer, Category> implements Categorydao {

	/**
	 * this implementation method return one Category object by it's categoryId
	 */
	public Category findByCategoryId(int categoryId) {
		Category category = getByKey(categoryId);
		return category;
	}

	@Override
	public void save(Category category) {

		persist(category);
	}

	@Override
	public List<Category> findByallCategory() {
		Criteria criteria = createEntityCriteria();
		List<Category> categories = (List<Category>) criteria.list();
		return categories;
	}
	@Override
	public void updateCategoryById(Category updateCategory) {
		update(updateCategory);
	}

	@Override
	public Boolean deleteMoltipleCategory(Category category) {
		 delete(category);
		 return true;
	}

	@Override
	public void deleteCategorybyId(Category category) {
		delete(category);
	}

	
}
