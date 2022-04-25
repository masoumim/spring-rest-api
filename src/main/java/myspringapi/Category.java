package myspringapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;

	Category() {
	}

	public Category(String categoryName, String description) {
		super();
		this.name = categoryName;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long categoryID) {
		this.id = categoryID;
	}

	public String getName() {
		return name;
	}

	public void setName(String categoryName) {
		this.name = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
