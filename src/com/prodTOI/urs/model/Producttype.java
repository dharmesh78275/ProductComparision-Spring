package com.prodTOI.urs.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the producttype database table.
 * 
 */
@Entity
@NamedQuery(name="Producttype.findAll", query="SELECT p FROM Producttype p")
public class Producttype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_type_id")
	private int productTypeId;

	@Column(name="product_type")
	private String productType;

	//bi-directional many-to-one association to ProductDetail
	@OneToMany(mappedBy="producttype",cascade= CascadeType.ALL,orphanRemoval=true, fetch=FetchType.LAZY)
	@JsonIgnore
	private List<ProductDetail> productDetails;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="product_category_id")
	@JsonIgnore
	private Category category;

	public Producttype() {
	}

	public int getProductTypeId() {
		return this.productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public List<ProductDetail> getProductDetails() {
		return this.productDetails;
	}

	public void setProductDetails(List<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}

	public ProductDetail addProductDetail(ProductDetail productDetail) {
		getProductDetails().add(productDetail);
		productDetail.setProducttype(this);

		return productDetail;
	}

	public ProductDetail removeProductDetail(ProductDetail productDetail) {
		getProductDetails().remove(productDetail);
		productDetail.setProducttype(null);

		return productDetail;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}