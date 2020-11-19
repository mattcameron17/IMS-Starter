package com.qa.ims.persistence.domain;

public class OrderItems {
	
	private Long order_items_id;
	private Long order_id_fk;
	private Long item_id_fk;
	
	public OrderItems(Long order_id_fk, Long item_id_fk) {
		this.order_id_fk = order_id_fk;
		this.item_id_fk = item_id_fk;
	}
	
	public OrderItems(Long order_items_id, Long order_id_fk, Long item_id_fk) {
		this.order_items_id = order_items_id;
		this.order_id_fk = order_id_fk;
		this.item_id_fk = item_id_fk; 
	}

	public Long getOrder_items_id() {
		return order_items_id;
	}

	public void setOrder_items_id(Long order_items_id) {
		this.order_items_id = order_items_id;
	}

	public Long getOrder_id_fk() {
		return order_id_fk;
	}

	public void setOrder_id_fk(Long order_id_fk) {
		this.order_id_fk = order_id_fk;
	}

	public Long getItem_id_fk() {
		return item_id_fk;
	}

	public void setItem_id_fk(Long item_id_fk) {
		this.item_id_fk = item_id_fk;
	}
	
	@Override
	public String toString() {
		return "order_items_id:" + order_items_id + " order_id_fk:" + order_id_fk + " item_id_fk:" + item_id_fk;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItems other = (OrderItems) obj;
		if (item_id_fk == null) {
			if (other.item_id_fk != null)
				return false;
		} else if (!item_id_fk.equals(other.item_id_fk))
			return false;
		if (order_id_fk == null) {
			if (other.order_id_fk != null)
				return false;
		} else if (!order_id_fk.equals(other.order_id_fk))
			return false;
		if (order_items_id == null) {
			if (other.order_items_id != null)
				return false;
		} else if (!order_items_id.equals(other.order_items_id))
			return false;
		return true;
	}

	
	
}
