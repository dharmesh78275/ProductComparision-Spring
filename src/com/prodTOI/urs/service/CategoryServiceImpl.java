package com.prodTOI.urs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prodTOI.urs.dao.Categorydao;
import com.prodTOI.urs.model.Category;

@Service("categoryService1")
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private Categorydao categorydao;

	/**
	 * This method get the one category Object by it's categoryId
	 */
	@Override
	public Category findByCategoryId(int categoryId) {

		Category categoryObj = categorydao.findByCategoryId(categoryId);
		return categoryObj;
	}

	@Override
	public void saveCategory(Category category) {

		categorydao.save(category);
	}

	@Override
	public List<Category> findAllCategories() {
		
		return categorydao.findByallCategory();
	}

	@Override
	public void updateCategoryById(Category updateCategory) {
		
		categorydao.updateCategoryById(updateCategory);
		
	}

	@Override
	public boolean deleteSelectedCategory(ArrayList<Category> categoryList) {
		int id=0;
		for (Category category : categoryList) {
			id =category.getProductCatagoryId();
			Category deleteCategory = categorydao.findByCategoryId(id);
			categorydao.deleteMoltipleCategory(deleteCategory);
		}
		return true;
		
	}

	@Override
	public void deleteCategorybyId(Integer categoryId) {
		Category category = categorydao.findByCategoryId(categoryId);
		categorydao.deleteCategorybyId(category);
	}

}
