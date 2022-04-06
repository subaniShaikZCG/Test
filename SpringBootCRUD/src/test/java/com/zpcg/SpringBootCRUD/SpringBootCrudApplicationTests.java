package com.zpcg.SpringBootCRUD;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zpcg.SpringBootCRUD.Model.Employee;
import com.zpcg.SpringBootCRUD.Repository.EmployeeDao;
import com.zpcg.SpringBootCRUD.Service.EmployeeService;

@WebMvcTest
//@SpringBootTest
class SpringBootCrudApplicationTests {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;

	@MockBean
	private EmployeeService employeeService;

//	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testGetExample() throws Exception {
		List<Employee> empls = new ArrayList<>();
		Employee empl = new Employee();
		empl.setEmpId(25);
		empl.setLastName("shaik");
		empl.setDept("IT");
		empl.setLocation("HYD");
		empl.setFirstName("subani");
		empl.setFullName("subanishaik");
		empl.setSalary(5656.00);
		empls.add(empl);
		Mockito.when(employeeService.getEmpls()).thenReturn(empls);
		System.out.println(empls);
		System.out.println("ok");
		mockMvc.perform(get("/employee/getMapping")).andExpect(status().isOk())
				.andExpect(jsonPath("$.size()").value(empls.size())).andDo(print());
	}

	@Test
	public void testPostExample() throws Exception {
		Employee empl = new Employee();
		empl.setEmpId(21);
		empl.setLastName("shaik");
		empl.setDept("java");
		empl.setLocation("hyd");
		empl.setFirstName("subani");
		empl.setFullName("subanishaik");
		empl.setSalary(1234.12);
		Mockito.when(employeeService.saveEmployee(ArgumentMatchers.any())).thenReturn(empl);
		String json = objectMapper.writeValueAsString(empl);
		mockMvc.perform(post("/employee/saveEmployee").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andDo(print());
	}
	
	 @Test
	  void shouldCreatePostTest() throws Exception {
	    Employee empl = new Employee(1, "prabha", "karan", "prabhakaran", "bglr", "sdet", 3241.00);
	    mockMvc.perform(post("/employee/postMapping").contentType(MediaType.APPLICATION_JSON)
	        .content(objectMapper.writeValueAsString(empl)))
	        .andExpect(status().isCreated())
	        .andDo(print());
	  }
	 

	 
	 @Test
	  void shouldDeleteTutorial() throws Exception {
	    int empId = 6;
	    doNothing().when(employeeService).deletEmployee(empId);
	    mockMvc.perform(delete("/employee/deleteById/{empId}", empId))
	         .andExpect(status().isNoContent())
	         .andDo(print());
	  }

}

//@Test
//public void testDeleteExample() throws Exception {
//    Mockito.when(employeeService.deletEmployee(ArgumentMatchers.anyInt())).thenReturn("Student is deleted");
//    MvcResult requestResult = mockMvc.perform(delete("/employee/deleteById/{empId}").param("empId", "1"))
//            .andExpect(status().isOk()).andExpect(status().isOk()).andReturn();
//    String result = requestResult.getResponse().getContentAsString();
//    assertEquals(result, "Employee is deleted");
//}

//.andExpect(jsonPath("$.empId", Matchers.equalTo(21)))
//.andExpect(jsonPath("$.firstName", Matchers.equalTo("subani")))
//.andExpect(jsonPath("$.lastName", Matchers.equalTo("shaik")))
//.andExpect(jsonPath("$.fullName", Matchers.equalTo("subanishaik")))
//.andExpect(jsonPath("$.dept", Matchers.equalTo("java")))
//.andExpect(jsonPath("$.location", Matchers.equalTo("hyd")))
//.andExpect(jsonPath("$.salary", Matchers.equalTo(1234.12)));
