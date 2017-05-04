package com.prodTOI.urs.controller;

import java.util.ArrayList;
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

import com.prodTOI.urs.model.Category;
import com.prodTOI.urs.service.CategoryService;

@RestController
public class ProductController {

	@Autowired
	private CategoryService categoryService;

	/**
	 * This method get all category list
	 * 
	 * @return
	 */
	@RequestMapping(value = "getAllCategory", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> getAllCategoryList() {
		List<Category> allCategoryList = categoryService.findAllCategories();
		return new ResponseEntity<List<Category>>(allCategoryList, HttpStatus.OK);

	}

	/**
	 * to get one category object by categoryId
	 * 
	 * @param categoryId
	 * @return
	 */

	@RequestMapping(value = "/getCategory/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> getCategory(@PathVariable("id") Integer categoryId) {
		Category category = categoryService.findByCategoryId(categoryId);
		return new ResponseEntity<Category>(category, HttpStatus.OK);

	}

	/**
	 * This method is used to create one new category
	 * 
	 * @return Category object
	 */
	@RequestMapping(value = "/createCategory", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> createOneCategory(@RequestBody Category category) {
		Category newCategory = new Category();
		newCategory.setProductCategory(category.getProductCategory());
		categoryService.saveCategory(newCategory);
		return new ResponseEntity<Category>(newCategory, HttpStatus.OK);
	}

	/**
	 * This method is used to update one category via its ID
	 * 
	 * @param category
	 * @return Category object
	 */
	@RequestMapping(value = "/updateCategory", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
		Category updateCategory = categoryService.findByCategoryId(category.getProductCatagoryId());
		if (updateCategory == null) {
			return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
		}
		updateCategory.setProductCategory(category.getProductCategory());
		categoryService.updateCategoryById(updateCategory);
		return new ResponseEntity<Category>(updateCategory, HttpStatus.OK);
	}

	/**
	 * to Delete multiple category object
	 * 
	 * @param categoryList
	 * @return
	 */

	@RequestMapping(value = "/deleteCategory", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> deleteMultipleCategory(@RequestBody ArrayList<Category> categoryList) {
		categoryService.deleteSelectedCategory(categoryList);
		return new ResponseEntity<List<Category>>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteCategory/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Category> deleteCategory(@PathVariable("id") Integer categoryId){
		 categoryService.deleteCategorybyId(categoryId);
		
		return new ResponseEntity<Category>(HttpStatus.OK);
	}
	

	

}
