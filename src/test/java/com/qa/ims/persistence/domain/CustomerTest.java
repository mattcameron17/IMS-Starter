package com.qa.ims.persistence.domain;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerTest {

	private final Customer cust = new Customer("Matt", "Cam");
	
	@Test
	public void testSetId() {
		final Long expected = 5L;
		cust.setId(5L);
		assertEquals(expected, cust.getId());
	}
	
	@Test
	public void testSetSurname() {
		final String expected = "Bob";
		cust.setSurname("Bob");
		assertEquals(expected, cust.getSurname());
	}
}
