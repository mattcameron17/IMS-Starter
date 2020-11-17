package com.qa.ims.persistence.domain;

public class Order {
	
	private Long order_id;
	private Long orderCost = null;
	private Long customer_id_fk;
	
	public Order(Long customer_id_fk) {
		this.customer_id_fk = customer_id_fk;
	}
	
	public Order(Long order_id, Long customer_id_fk) {
		this.order_id = order_id;
		this.customer_id_fk = customer_id_fk;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(Long orderCost) {
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

	
}


