package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.Utils;

/**
 * Takes in order details for CRUD functionality
 *
 */

public class OrderController implements CrudController<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	/**
	 * Reads all orders to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		
		for (Order order : orders) {
			LOGGER.info(order.toString());
			List<OrderItems> order_itemsItems = orderDAO.readOrderedItems(order);
			for (OrderItems order_items : order_itemsItems) {
				LOGGER.info(order_items.toString());
			}
		}
		return orders;
	}

	/**
	 * Creates an order by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter the customer id");
		Long customer_id_fk = utils.getLong();
		Order order = orderDAO.create(new Order(customer_id_fk));
		LOGGER.info("Order created");
		return order;
	}

	/**
	 * Updates an existing order by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long order_id = utils.getLong();
		LOGGER.info("Please enter a customer id");
		Long customer_id_fk = utils.getLong();
		
		LOGGER.info("Would you like to add an item to the order?");
		String addItem = utils.getString();
		
		while(addItem.toLowerCase().equals("yes")) {
			LOGGER.info("Please enter the item id you would like to add to order");
			Long item_id_fk = utils.getLong();
			OrderItems orderItems = orderDAO.createItems(new OrderItems(order_id,item_id_fk));
			LOGGER.info("Would you like to add another item to the order?");
			addItem = utils.getString();
			
		}
		
		
		
		Order order = orderDAO.update(new Order(order_id, customer_id_fk));
		LOGGER.info("Order Updated");
		return order;
	}

	
	/**
	 * Deletes an existing order by the id of the order
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long order_id = utils.getLong();
		return orderDAO.delete(order_id);
	}

}
