package model;

import java.math.BigDecimal;

public class Product {
	
	private Long id;
	private String productName;
	private BigDecimal price;
	private BigDecimal discount;
	private String sku;
	private String category;
	private String supplier;
	private String supplierAdress;
	
	public Product() {
		super();
	}

	public Product(Long id, String productName, BigDecimal price, BigDecimal discount, String sku, String category,
			String supplier, String supplierAdress) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.discount = discount;
		this.sku = sku;
		this.category = category;
		this.supplier = supplier;
		this.supplierAdress = supplierAdress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String code) {
		this.sku = code;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getSupplierAdress() {
		return supplierAdress;
	}

	public void setSupplierAdress(String supplierAdress) {
		this.supplierAdress = supplierAdress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "product [id=" + id + ", productName=" + productName + ", price=" + price + ", discount=" + discount
				+ ", sku code=" + sku + ", category=" + category + ", supplier=" + supplier + ", supplierAdress="
				+ supplierAdress + "]";
	}	
}
