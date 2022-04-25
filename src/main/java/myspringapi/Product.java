package myspringapi;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "category_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Category category;

	private String productName;
	private int supplierId;
	private String quantityPerUnit;
	private String unitPrice;
	private int unitsInStock;
	private int unitsOnOrder;
	private int reorderLevel;

	public Product() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long productID) {
		this.id = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierID) {
		this.supplierId = supplierID;
	}

	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public int getUnitsOnOrder() {
		return unitsOnOrder;
	}

	public void setUnitsOnOrder(int unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}

	public int getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public void setCategory(Category category) {
		this.category = category;

	}

	public String getCategory() {
		return category.getName();
	}
}
