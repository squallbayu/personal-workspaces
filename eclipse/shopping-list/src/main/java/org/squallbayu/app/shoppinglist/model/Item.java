package org.squallbayu.app.shoppinglist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="item")
public class Item {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	private String itemName;
	
	private int itemQuantity;
	
	private Long itemPricePerItem;

	private String alternateItemName;

	private int alternateItemQuantity;
	
	private Long alternateItemPricePerItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public Long getItemPricePerItem() {
		return itemPricePerItem;
	}

	public void setItemPricePerItem(Long itemPricePerItem) {
		this.itemPricePerItem = itemPricePerItem;
	}

	public String getAlternateItemName() {
		return alternateItemName;
	}

	public void setAlternateItemName(String alternateItemName) {
		this.alternateItemName = alternateItemName;
	}

	public int getAlternateItemQuantity() {
		return alternateItemQuantity;
	}

	public void setAlternateItemQuantity(int alternateItemQuantity) {
		this.alternateItemQuantity = alternateItemQuantity;
	}

	public Long getAlternateItemPricePerItem() {
		return alternateItemPricePerItem;
	}

	public void setAlternateItemPricePerItem(Long alternateItemPricePerItem) {
		this.alternateItemPricePerItem = alternateItemPricePerItem;
	}
}
