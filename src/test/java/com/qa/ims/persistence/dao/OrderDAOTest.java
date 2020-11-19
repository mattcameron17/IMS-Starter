package com.qa.ims.persistence.dao;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.DBUtils;


public class OrderDAOTest {

	private final OrderDAO DAO = new OrderDAO();

	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "Ic3Berg$lim");
	} 
	
	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	 
	@Test
	public void testCreate() {
		final Order created = new Order(2L, 0D, 1L);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, 0D, 1L));
		assertEquals(expected, DAO.readAll());
	}
	
	
	
	@Test
	public void testReadOrderedItems() {
		Order expectedOrder = new Order(1L, 0D, 1L);
		List<OrderItems> expected = new ArrayList<>();
		expected.add(new OrderItems(1L, 1L, 1L));
		assertEquals(expected, DAO.readOrderedItems(expectedOrder));
	}
	
	@Test
	public void testReadLatest() {
		assertEquals(new Order(1L, 0D, 1L), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Order(ID, 0D, 1L), DAO.readOrder(ID));
	}
	
	@Test
	public void testReadPrice() {
		Item item = new Item(1L, "dreamcast", 120.00D);
		final Double expectedPrice = 120.00D;
		assertEquals(expectedPrice, DAO.readPrice(item.getItem_id())); 
	}
	
	
	
	@Test
	public void testReadLatestItems() {
		assertEquals(new OrderItems(1L, 1L, 1L), DAO.readLatestItems());
	}

	@Test
	public void testUpdate() {
		final Order updated = new Order(1L, 0D, 1L);
		assertEquals(updated, DAO.update(updated));

	} 
	
	
	
	@Test
	public void testUpdateCost() {
		Order expected = new Order(1L, 0D, 1L);
		assertEquals(expected,DAO.updateCost(50D, expected));
	}

	@Test
	public void testDelete() {
		assertEquals(0, DAO.delete(1));
	}
	
	@Test
	public void testDeleteOrderItems() {
		assertEquals(1,DAO.deleteOrderItem(1) );
	} 

}
