package com.zpcg.SpringBootCRUD.testcontroller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.zpcg.SpringBootCRUD.Model.Employee;

public class TestController extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getEmployeesList() throws Exception {
		String uri = "/employees";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Employee[] productlist = super.mapFromJson(content, Employee[].class);
		assertTrue(productlist.length > 0);
	}

	@Test
	public void createEmployee() throws Exception {
		String uri = "/employee";
		Employee empl = new Employee();
		empl.setEmpId(22);
		empl.setFirstName("Ginger");
		String inputJson = super.mapToJson(empl);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Product is created successfully");
	}

	@Test
	public void updateEmployee() throws Exception {
		String uri = "/employee/2";
		Employee empl = new Employee();
		empl.setFirstName("Lemon");
		String inputJson = super.mapToJson(empl);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "employee is updated successsfully");
	}

	@Test
	public void deleteEmployee() throws Exception {
		String uri = "/employee/2";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "employee is deleted successsfully");
	}
}
