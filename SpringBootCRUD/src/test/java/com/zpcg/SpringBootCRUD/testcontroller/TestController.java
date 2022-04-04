//package com.zpcg.SpringBootCRUD.testcontroller;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.hamcrest.Matchers;
//import org.mockito.ArgumentMatchers;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.zpcg.SpringBootCRUD.Model.Employee;
//import com.zpcg.SpringBootCRUD.Service.EmployeeService;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//@SpringBootTest
//public class TestController extends AbstractTest {
//	
//	@Autowired
//	MockMvc mockMvc;
//	
//	@MockBean
//	private EmployeeService employeeService;
//	
//	@Override
//	@Before
//	public void setUp() {
//		super.setUp();
//	}
//
//	@Test
//	public void getEmployeesList() throws Exception {
//		String uri = "/employees";
//		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
//				.andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		Employee[] productlist = super.mapFromJson(content, Employee[].class);
//		assertTrue(productlist.length > 0);
//	}
//	
//	 @Test
//	    public void testGetExample() throws Exception {
//		 String uri = "/getEmployees";
//	        List<Employee> empl = new ArrayList<>();
//	        Employee emply = new Employee();
//	        emply.setEmpId(1);
//	        emply.setFirstName("Arun");
//	        empl.add(emply);
//	        Mockito.when(employeeService.getAllData()).thenReturn(empl);
//	        mockMvc.perform(get("/getMapping")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
//			.andExpect(jsonPath("$[0].firstName", Matchers.equalTo("subani")));
//	    }
//
//	@Test
//	public void createEmployee() throws Exception {
//		String uri = "/employee";
//		Employee empl = new Employee();
//		empl.setEmpId(22);
//		empl.setFirstName("Ginger");
//		String inputJson = super.mapToJson(empl);
//		MvcResult mvcResult = mvc.perform(
//				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
//				.andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(201, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		assertEquals(content, "Product is created successfully");
//	}
//
//	@Test
//	public void updateEmployee() throws Exception {
//		String uri = "/employee/2";
//		Employee empl = new Employee();
//		empl.setFirstName("Lemon");
//		String inputJson = super.mapToJson(empl);
//		MvcResult mvcResult = mvc.perform(
//				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
//				.andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		assertEquals(content, "employee is updated successsfully");
//	}
//	
//	@Test
//	public void deleteEmployee() throws Exception {
//		String uri = "/employee/2";
//		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		assertEquals(content, "employee is deleted successsfully");
//	}
//}
