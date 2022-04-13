package com.zpcg.SpringBootCRUD.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

//	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmployeeData(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		ResponseEntity<Employee> re = new ResponseEntity<Employee>(HttpStatus.CREATED);
		System.out.println("successfully created");
		return re;
	}

	@PostMapping("/postMapping")
	public ResponseEntity<Employee> saveEmployees(@RequestBody Employee employee) {
		employee = employeeService.saveEmployees(employee);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> listEmp = employeeService.getAllData();
		return new ResponseEntity<List<Employee>>(listEmp, HttpStatus.OK);

	}

	@GetMapping("/getMapping")
	public ResponseEntity<List<Employee>> getEmpls() {
		List<Employee> listEmp = employeeService.getEmpls();
		return new ResponseEntity<List<Employee>>(listEmp, HttpStatus.OK);

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployeeData(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		ResponseEntity<Employee> re = new ResponseEntity<Employee>(HttpStatus.UPGRADE_REQUIRED);
		return re;
	}

	@RequestMapping(value = "/getEmployee/{eid}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getDataById(@PathVariable Integer eid) {
		Optional<Employee> empl = employeeService.getEmployee(eid);
		return new ResponseEntity<Employee>(empl.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteEmployeeData() {
		employeeService.deleteEmployees();
		ResponseEntity<Employee> re = new ResponseEntity<Employee>(HttpStatus.GONE);
		return re;
	}

	@RequestMapping(value = "/deleteById/{empId}", method = RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteEmpData(@PathVariable("empId") int empId) {
		employeeService.deleteEmpData(empId);
		ResponseEntity<Employee> dt = new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
		return dt;

	}

	@DeleteMapping("/deleteByids/{empId}")
	public void deleteBook(@PathVariable("empId") int empId) {
		employeeService.deletEmployee(empId);
	}

	@RequestMapping(value = "/getEmployeeBySalary/{salary}", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmployeeBySalary(@PathVariable Double salary) {
		List<Employee> empl = employeeService.getDataBySalary(salary);
		return new ResponseEntity<List<Employee>>(empl, HttpStatus.OK);
	}

//	@RequestMapping(value = "/between", method = RequestMethod.GET)
//	public ResponseEntity<List<Employee>> between(@RequestParam Double minSalary, )

	@RequestMapping(value = "/getEmpByDesignation/{designationName}", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmployeeByDesg(@PathVariable String designationName) {
		List<Employee> empl = employeeService.getEmpByDesg(designationName);
		return new ResponseEntity<List<Employee>>(empl, HttpStatus.OK);

	}

	@RequestMapping(value = "/getDataByOrder", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmployeeData() {
		List<Employee> empl = employeeService.findAll();
		return new ResponseEntity<List<Employee>>(empl, HttpStatus.OK);
	}

	@RequestMapping(value = "/getDataByOrderBySalary", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmployeeDataBySalary() {
		List<Employee> empl = employeeService.findAllEmps();
		return new ResponseEntity<List<Employee>>(empl, HttpStatus.OK);
	}

//	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
//	public ResponseEntity<List<Employee>> getAllEmployees() {
//		List<Employee> listEmp = employeeService.getAllData();
//		return new ResponseEntity<List<Employee>>(listEmp, HttpStatus.OK);
//
//	}
	
	@GetMapping("/all-items-from-database")
	public List<Employee> retrieveAllItems() {
		return employeeService.retrieveAllItems();
	}
}
