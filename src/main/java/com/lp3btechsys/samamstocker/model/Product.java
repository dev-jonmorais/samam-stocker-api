package com.lp3btechsys.samamstocker.model;

import java.util.Arrays;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
@NamedQueries({
	@NamedQuery(name="Product.getAllProducts", query="select p from Product p inner join fetch p.supplier"),
	@NamedQuery(name="Product.getProductByCategory", query="select p from Product p"
			+ " where p.category = :category")
})
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "product_id", length = 6)
	private Long productID;
	
	@Column(name = "product_name", length = 80)
	private String productName;
	
	// SUPPLIER
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;
	
	// CATEGORY
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@Column(name = "product_group", length = 40)
	private String productGroup;
	
	@Column(name = "purchase_price")
	private double purchasePrice;
	
	@Column(name = "selling_price")
	private double sellingPrice;
	
	@Column(name = "product_quantity")
	private int productQuantity;
	
	@Column(name = "photo_cover")
	private byte[] productPhotoCover;
	
	@Column(name = "product_description", length = 80)
	private String productDescription;

	public Product() {}
	
	public Product(String productName, Supplier supplier, Category category, String productGroup,
			double purchasePrice, double sellingPrice, int productQuantity, byte[] productPhotoCover,
			String productDescription) {	
		this.productName = productName;
		this.supplier = supplier;
		this.category = category;
		this.productGroup = productGroup;
		this.purchasePrice = purchasePrice;
		this.sellingPrice = sellingPrice;
		this.productQuantity = productQuantity;
		this.productPhotoCover = productPhotoCover;
		this.productDescription = productDescription;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public byte[] getProductPhotoCover() {
		return productPhotoCover;
	}

	public void setProductPhotoCover(byte[] productPhotoCover) {
		this.productPhotoCover = productPhotoCover;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productID == null) ? 0 : productID.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productID == null) {
			if (other.productID != null)
				return false;
		} else if (!productID.equals(other.productID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", supplier=" + supplier
				+ ", category=" + category + ", productGroup=" + productGroup + ", purchasePrice=" + purchasePrice
				+ ", sellingPrice=" + sellingPrice + ", productQuantity=" + productQuantity + ", productPhotoCover="
				+ Arrays.toString(productPhotoCover) + ", productDescription=" + productDescription + "]";
	}
	
}
