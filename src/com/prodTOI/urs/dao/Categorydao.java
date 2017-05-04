package com.prodTOI.urs.dao;

import java.util.List;

import com.prodTOI.urs.model.Category;

public interface Categorydao {

	/**
	 * this interface method get the one Category object by it's category Id
	 */
	Category findByCategoryId(int categoryId);

	void save(Category category); // create one category

	List<Category> findByallCategory();

	void updateCategoryById(Category updateCategory);

	public Boolean deleteMoltipleCategory(Category category);

	public void deleteCategorybyId(Category categoryId);
}
