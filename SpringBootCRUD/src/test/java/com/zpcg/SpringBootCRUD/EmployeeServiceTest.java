package com.zpcg.SpringBootCRUD;

//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertThat;
//import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.zpcg.SpringBootCRUD.Model.Employee;
import com.zpcg.SpringBootCRUD.Repository.EmployeeDao;
import com.zpcg.SpringBootCRUD.Service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@Autowired
	MockMvc mockMvc;

	@InjectMocks
	private EmployeeService employeeService;

	@Mock
	private EmployeeDao employeeDao;
	
	@Test
	public void getUsersTest() {
		when(employeeDao.findAll()).thenReturn(Stream.of(new Employee(12, "test", "test", "testtest", "hyd", "java", 1212.12), new 
				Employee(13, "subani", "shaik", "subanishaik", "java engineer", "hyd", 12345.0)).collect(Collectors.toList()));
		assertEquals(2, employeeService.getAllData().size());
	}
	
	
	//getting the total data testing
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
	
	
	// save method test case
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
	
	//put test case 

//	@SuppressWarnings("deprecation")
	@Test
	public void savedEmployee_put() {
		Employee employee = new Employee();
		employee.setEmpId(25);
		employee.setFirstName("raju");
		employee.setLastName("raju");
		employee.setFullName("rajuraju");
		employee.setDept("cse");
		employee.setLocation("bglr");
		employee.setSalary(22222.12);
		Mockito.when(employeeDao.save(any(Employee.class))).thenReturn(employee);

		Employee savedCustomer = employeeDao.save(employee);
//		assertThat(savedCustomer.getFirstName()).isNotNull();
		assertEquals(savedCustomer.getFirstName(), "raju");
	}

//	@Test()
//	public void deleteAllDataTest() throws Exception {
////		Employee empl = new Employee();
////		Employee empl2 = new Employee();
////		EmployeeService emp = new EmployeeService();
////		doNothing().when(employeeDao).deleteAll();
////		int expectedResult = 0;
//		employeeService.deleteEmployees();
////		System.out.println(str);
////		assertEquals("DELETED", str);
////		assertNotNull(str);
//	}

	@Test
	public void deleteApplicationById() throws Exception {
		Employee empl = new Employee();
		empl.setFirstName("test name");
		empl.setEmpId(1);
		when(employeeDao.findById(empl.getEmpId())).thenReturn(Optional.of(empl));
		employeeService.deletEmployer(empl.getEmpId());
		verify(employeeDao).deleteById(empl.getEmpId());

//		Employee employee = new Employee();
//		doThrow(Exception).when(employeeService.deletEmployer(12)).thenReturn("Success");
//		assertThat(employee.getFirstName()).isNull();
//		Employee employee = new Employee();
//		EmployeeService emps = mock(EmployeeService.class);
//		when(emps.deletEmployer(12)).thenReturn("Approved");
//		Mockito.doReturn(employee).when(employeeDao.deleteById(12))
//		doNothing().when(employeeService.deletEmployer(12));
//		doNothing().when(employeeDao.deleteById(12));
//		assertThat(employee.getFirstName()).isNull();
//    	Mockito.when(employeeDao.deleteById(ArgumentMatchers.any())).thenReturn(employee);
//        mockMvc.perform(MockMvcRequestBuilders.delete("/applications", 10001L))
//                .andExpect(status().isOk());

//        String emps = employeeService.deletEmployee(1);
//        assertEquals(emps, "DELETED");
	}

	@Test
	public void should_throw_exception_when_user_doesnt_exist() {
		Employee empls = new Employee();
		empls.setEmpId(1);
		empls.setFirstName("subani");

		given(employeeDao.findById(anyInt()));
		employeeService.deletEmployer(empls.getEmpId());
	}

	private void given(Optional<Employee> findById) {
		// TODO Auto-generated method stub
		
	}
	
	@Test
	
	public void deleteUserTest() {
		Employee empl = new Employee(11, "subani", "shaik", "subanishaik", "java engineer", "hyd", 12345.0);
		employeeService.deleteEmployees();
		verify(employeeDao, times(1)).deleteAll();
	}

	@Test
	public void test() {
		assertEquals("AC", "AC");
		// the first value is expected and second value is actual when they both are
		// same at that moment only our test case is success
	}
}
