//package com.zpcg.SpringBootCRUD;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.hamcrest.Matchers;
//import org.junit.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.zpcg.SpringBootCRUD.Model.Employee;
//import com.zpcg.SpringBootCRUD.Service.EmployeeService;
//
//@WebMvcTest
//public class EmployeeControllerTest {
//
//	@Autowired
//	MockMvc mockMvc;
//
//	@MockBean
//	private EmployeeService employeeService;
//
//	private static ObjectMapper mapper = new ObjectMapper();
//
//	@Test
//	public void testGetExample() throws Exception {
//		List<Employee> empls = new ArrayList<>();
//		Employee empl = new Employee();
//		empl.setEmpId(1);
//		empl.setLastName("shaik");
//		empl.setDept("IT");
//		empl.setLocation("HYD");
//		empl.setFirstName("subani");
//		empls.add(empl);
//		Mockito.when(employeeService.getAllData()).thenReturn(empls);
//		mockMvc.perform(get("/getMapping")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
//				.andExpect(jsonPath("$[0].firstName", Matchers.equalTo("subani")));
//	}
//
//}



