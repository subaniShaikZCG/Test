package com.zpcg.SpringBootCRUD.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zpcg.SpringBootCRUD.Model.Employee;
import com.zpcg.SpringBootCRUD.Repository.DesignationDao;
import com.zpcg.SpringBootCRUD.Repository.EmployeeDao;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	DesignationDao designationDao;

	public Employee saveEmployee(Employee employee) {
		String firstName = employee.getFirstName();
		String lastName = employee.getLastName();
		String fullName = firstName.concat(lastName);
		employee.setFullName(fullName);
		employeeDao.save(employee);
		return employee;
	}

	public Employee saveEmployees(Employee employee) {
		employee.setEmpId(21);
		employee.setFirstName("subani");
		employee.setLastName("shaik");
		employee.setFullName("subanishaik");
		employee.setDept("java");
		employee.setLocation("hyd");
		employee.setSalary(1234.12);
		return employee;
	}

	public List<Employee> getAllData() {
		List<Employee> list = employeeDao.findAll();
		return list;
	}

	public List<Employee> getEmpls() {
		List<Employee> empls = new ArrayList<>();
		Employee empl = new Employee();
		empls.add(empl);
		return empls;
	}

	public void updateEmployee(Employee employee) {
		String firstName = employee.getFirstName();
		String lastName = employee.getLastName();
		String fullName = firstName.concat(lastName);
		employee.setFullName(fullName);
		employeeDao.save(employee);

	}

	public void deleteEmpData(int empId) {
		employeeDao.deleteById(empId);

	}

	public void deletEmployee(int empId) {
		employeeDao.deleteById(empId);

	}
	


	public Optional<Employee> getEmployee(Integer eid) {
		Optional<Employee> employee = employeeDao.findById(eid);
		return employee;
	}

	public List<Employee> getDataBySalary(Double salary) {
		List<Employee> list = employeeDao.findBySalary(salary);
		return list;
	}

	public List<Employee> getEmpByDesg(String designationName) {
		List<Employee> lis = designationDao.findByDesignationName(designationName);
		return lis;
	}

	public List<Employee> findAll() {
		List<Employee> lis = employeeDao.findAllSortedByName();
		return lis;
	}

	public List<Employee> findAllEmps() {
		List<Employee> lis = employeeDao.findAllSortedBySalary();
		return lis;
	}
//	public List<Employee> deleteEmployee(Employee employee) {
//		List<Employee> list = employeeDao.deleteAll(getAllData(E));
//		return list ;
//		
//	}

	public void deleteEmployees() {
		employeeDao.deleteAll();

	}

	public List<Employee> retrieveAllItems() {
		List<Employee> list = employeeDao.findAll();
		return list;
	}

	public void deletEmployer(int empId) {
		employeeDao.findById(empId);
		employeeDao.deleteById(empId);
		
		
		
	}
	
//	public void deletEmployerr(Employee employee) {
//		employee = employeeDao.returnEmployee(employee.getEmpId());
//		employeeDao.delete(employee);
//		employeeDao.deleteById(empId);
//		return "SUCCESS";
		
//	}
}
