package com.prodTOI.urs.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the attribute database table.
 * 
 */
@Entity
@NamedQuery(name="Attribute.findAll", query="SELECT a FROM Attribute a")
public class Attribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="attrubute_id")
	private int attrubuteId;

	private String attributes;

	private String value;

	//bi-directional many-to-one association to ProductDetail
	@OneToMany(mappedBy="attribute", cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	@JsonIgnore
	private List<ProductDetail> productDetails;

	public Attribute() {
	}

	public int getAttrubuteId() {
		return this.attrubuteId;
	}

	public void setAttrubuteId(int attrubuteId) {
		this.attrubuteId = attrubuteId;
	}

	public String getAttributes() {
		return this.attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<ProductDetail> getProductDetails() {
		return this.productDetails;
	}

	public void setProductDetails(List<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}

	public ProductDetail addProductDetail(ProductDetail productDetail) {
		getProductDetails().add(productDetail);
		productDetail.setAttribute(this);

		return productDetail;
	}

	public ProductDetail removeProductDetail(ProductDetail productDetail) {
		getProductDetails().remove(productDetail);
		productDetail.setAttribute(null);

		return productDetail;
	}

}