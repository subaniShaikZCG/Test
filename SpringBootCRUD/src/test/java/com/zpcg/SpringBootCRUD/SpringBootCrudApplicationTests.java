package com.zpcg.SpringBootCRUD;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zpcg.SpringBootCRUD.Model.Employee;
import com.zpcg.SpringBootCRUD.Service.EmployeeService;


@WebMvcTest
class SpringBootCrudApplicationTests {
	
	@Autowired
	MockMvc mockMvc;

	@MockBean
	private EmployeeService employeeService;

	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testGetExample() throws Exception {
		List<Employee> empls = new ArrayList<>();
		Employee empl = new Employee();
		empl.setEmpId(25);
		empl.setLastName("shaik");
		empl.setDept("IT");
		empl.setLocation("HYD");
		empl.setFirstName("subani");
		empls.add(empl);
		Mockito.when(employeeService.getAllData()).thenReturn(empls);
		System.out.println(empls);
		System.out.println("ok");
		mockMvc.perform(get("/getMapping")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
				.andExpect(jsonPath("$[0].firstName", Matchers.equalTo("subani")));
	}


//	@Test
//	void contextLoads() {
//	}

}
