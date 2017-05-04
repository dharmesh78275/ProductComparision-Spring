package com.prodTOI.urs.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_catagory_id")
	private int productCatagoryId;

	@Column(name="product_category")
	private String productCategory;

	//bi-directional many-to-one association to Producttype
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Producttype> producttypes;

	public Category() {
	}

	public int getProductCatagoryId() {
		return this.productCatagoryId;
	}

	public void setProductCatagoryId(int productCatagoryId) {
		this.productCatagoryId = productCatagoryId;
	}

	public String getProductCategory() {
		return this.productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public List<Producttype> getProducttypes() {
		return this.producttypes;
	}

	public void setProducttypes(List<Producttype> producttypes) {
		this.producttypes = producttypes;
	}

	public Producttype addProducttype(Producttype producttype) {
		getProducttypes().add(producttype);
		producttype.setCategory(this);

		return producttype;
	}

	public Producttype removeProducttype(Producttype producttype) {
		getProducttypes().remove(producttype);
		producttype.setCategory(null);

		return producttype;
	}

}