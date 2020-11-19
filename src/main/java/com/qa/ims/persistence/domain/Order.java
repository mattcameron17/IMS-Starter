package com.qa.ims.persistence.domain;

import java.util.ArrayList;

public class Order {
	
	private Long order_id;
	private Double orderCost = 0D; 
	private Long customer_id_fk;
	
	
	public Order(Long customer_id_fk) {
		this.customer_id_fk = customer_id_fk;
	}
	
	public Order(Long order_id, Long customer_id_fk) {
		this.order_id = order_id;
		this.customer_id_fk = customer_id_fk; 
		
	}
	

	public Order(Long order_id, Double orderCost, Long customer_id_fk) {
		super();
		this.order_id = order_id;
		this.orderCost = orderCost;
		this.customer_id_fk = customer_id_fk;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Double getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(Double orderCost) {
		this.orderCost = orderCost;
	}

	public Long getCustomer_id_fk() {
		return customer_id_fk;
	}

	public void setCustomer_id_fk(Long customer_id_fk) {
		this.customer_id_fk = customer_id_fk;
	}
	


	@Override
	public String toString() {
		return "order_id:" + order_id + " customer id:" + customer_id_fk + " order cost:" + orderCost;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customer_id_fk == null) {
			if (other.customer_id_fk != null)
				return false;
		} else if (!customer_id_fk.equals(other.customer_id_fk))
			return false;
		if (orderCost == null) {
			if (other.orderCost != null)
				return false; 
		} else if (!orderCost.equals(other.orderCost))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		return true;
	}

	

	

	
	
}


