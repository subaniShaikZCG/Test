package com.zpcg.SpringBootCRUD;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import java.util.Arrays;

import com.zpcg.SpringBootCRUD.Model.Employee;
import com.zpcg.SpringBootCRUD.Repository.EmployeeDao;
import com.zpcg.SpringBootCRUD.Service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@InjectMocks
	private EmployeeService employeeService;

	@Mock
	private EmployeeDao employeeDao;

	@Test
	public void getAllDataTest() {
		when(employeeDao.findAll()).thenReturn(
				Arrays.asList(new Employee(11, "subani", "shaik", "subanishaik", "java engineer", "hyd", 12345.0)));
		List<Employee> items = employeeService.retrieveAllItems();
		System.out.println(items);
		assertNotNull(items);
		assertEquals(items, items);
		assertEquals(12345.0, items.get(0).getSalary());
	}

	@Test
	public void postDataTest() throws Exception {
		Employee employee = new Employee();
		employee.setEmpId(21);
		employee.setFirstName("subani");
		employee.setLastName("shaik");
		employee.setFullName("subanishaik");
		employee.setDept("java");
		employee.setLocation("hyd");
		employee.setSalary(1234.12);
		Mockito.when(employeeDao.save(ArgumentMatchers.any())).thenReturn(employee);
		Employee emps = employeeService.saveEmployee(employee);
		System.out.println(emps);
		System.out.println(
				"----------------------------------------------------------------------------------------------");
		assertNotNull(emps);
		assertEquals(employee, emps);
		assertEquals(1234.12, emps.getSalary());
		assertEquals("subani", emps.getFirstName());
		System.out.println(emps.getFirstName() + " shaik");
	}

	@Test
	public void deleteAllDataTest() {
		Employee empl = new Employee();
		Employee empl2 = new Employee();

//		when(employeeDao.deleteAll()).thenReturn(
//				Arrays.asList(new Employee(11, "subani", "shaik", "subanishaik", "java engineer", "hyd", 12345.0)));
		doNothing().when(employeeDao).deleteAll();
		Employee empls = employeeService.deleteEmployees();

//		System.out.println(items);
		assertNotNull(empls);
//		assertEquals(empls, empls);
//		assertEquals(12345.0, empls.get(0).getSalary());
	}

	@Test
	public void test() {
		assertEquals("AC", "AC");
		// the first value is expected and second value is actual when they both are
		// same at that moment only our test case is success
	}
}
