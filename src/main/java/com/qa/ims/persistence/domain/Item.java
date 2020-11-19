package com.qa.ims.persistence.domain;

public class Item {

	private Long item_id;
	private String itemName;
	private Double itemValue;
	
	public Item(String itemName, Double itemValue) {
		this.itemName = itemName;
		this.itemValue = itemValue; 
	}
	
	public Item(Long item_id, String itemName, Double itemValue) {
		this.item_id = item_id;
		this.itemName = itemName;
		this.itemValue = itemValue;
	}
 
	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemValue() {
		return itemValue;
	}

	public void setItemValue(Double itemValue) {
		this.itemValue = itemValue;
	}
	
	@Override
	public String toString() {
		return "Item id:" + item_id + " Item name:" + itemName + " Item value:" + itemValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (item_id == null) {
			if (other.item_id != null)
				return false;
		} else if (!item_id.equals(other.item_id))
			return false;
		if (itemValue == null) {
			if (other.itemValue != null)
				return false;
		} else if (!itemValue.equals(other.itemValue))
			return false;
		return true;
	}
}
