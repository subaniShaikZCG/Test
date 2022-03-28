package com.zpcg.SpringBootCRUD.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zpcg.SpringBootCRUD.Model.Employee;
import com.zpcg.SpringBootCRUD.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getData")
	public String getData() {
		return "data from springBootZPCG";
		
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ResponseEntity<Employee> saveEmployeeData(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		ResponseEntity<Employee> re = new ResponseEntity<Employee>(HttpStatus.CREATED);
		System.out.println("successfully created");
		return re;
	}

	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> listEmp = employeeService.getAllData();
		return new ResponseEntity<List<Employee>>(listEmp, HttpStatus.OK);

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployeeData(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		ResponseEntity<Employee> re = new ResponseEntity<Employee>(HttpStatus.CREATED);
		return re;
	}
	
	@RequestMapping(value = "/getEmployee/{eid}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getDataById(@PathVariable Integer eid) {
		Optional<Employee> empl = employeeService.getEmployee(eid);
		return new ResponseEntity<Employee>(empl.get(),HttpStatus.OK);
	}
	

//	@RequestMapping(value="/update", method = RequestMethod.DELETE)
//	public ResponseEntity<Employee> deleteEmployeeData(@RequestBody Employee employee) {
//		employeeService.deleteEmployee(employee);
//		ResponseEntity<Employee> re = new ResponseEntity<Employee>(HttpStatus.GONE);
//		return re;
//	}

	@RequestMapping(value = "/deleteById/{empId}", method = RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteEmpData(@PathVariable("empId") int empId) {
		employeeService.deleteEmpData(empId);
		ResponseEntity<Employee> dt = new ResponseEntity<Employee>(HttpStatus.GONE);
		return dt;

	}
	
	@DeleteMapping("/deleteByids/{empId}")
	public void deleteBook(@PathVariable("empId") int empId)
	{
		employeeService.deletEmployee(empId);
	}
	
	@RequestMapping(value = "/getEmployeeBySalary/{salary}", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmployeeBySalary(@PathVariable Double salary){
		List<Employee> empl = employeeService.getDataBySalary(salary);
		return new ResponseEntity<List<Employee>>(empl, HttpStatus.OK);
	}
}
