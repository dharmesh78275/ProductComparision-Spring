package com.prodTOI.urs.service;

import java.util.ArrayList;
import java.util.List;

import com.prodTOI.urs.model.Category;

/**
 *this interface method get one category object by it's categoryId
 */
public interface CategoryService {
	Category findByCategoryId(int categoryId);

	/**
	 *  this Interface method create one category object which is passed with json
	 */
	void saveCategory(Category category);
	
	List<Category> findAllCategories();

	void updateCategoryById(Category updateCategory);


	public boolean deleteSelectedCategory(ArrayList<Category> categoryList);


	public void deleteCategorybyId(Integer categoryId);
	
	
}
