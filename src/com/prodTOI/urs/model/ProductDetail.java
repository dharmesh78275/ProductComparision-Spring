package com.prodTOI.urs.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the product_details database table.
 * 
 */
@Entity
@Table(name="product_details")
@NamedQuery(name="ProductDetail.findAll", query="SELECT p FROM ProductDetail p")
public class ProductDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Producttype
	@ManyToOne(cascade=CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JoinColumn(name="product_type_id")

	private Producttype producttype;

	//bi-directional many-to-one association to Attribute
	@ManyToOne(cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	@JoinColumn(name="attribute_id")

	private Attribute attribute;

	public ProductDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Producttype getProducttype() {
		return this.producttype;
	}

	public void setProducttype(Producttype producttype) {
		this.producttype = producttype;
	}

	public Attribute getAttribute() {
		return this.attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

}