package com.zpcg.SpringBootCRUD.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zpcg.SpringBootCRUD.Model.Employee;
import com.zpcg.SpringBootCRUD.Repository.EmployeeDao;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	public void saveEmployee(Employee employee) {
		String firstName = employee.getFirstName();
		String lastName = employee.getLastName();
		String fullName = firstName.concat(lastName);
		employee.setFullName(fullName);
		employeeDao.save(employee);
	}

	public List<Employee> getAllData() {
		List<Employee> list = employeeDao.findAll();
		return list;
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

//	public List<Employee> deleteEmployee(Employee employee) {
//		List<Employee> list = employeeDao.deleteAll(getAllData(E));
//		return list ;
//		
//	}
}
