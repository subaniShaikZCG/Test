package com.zpcg.SpringBootCRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zpcg.SpringBootCRUD.Model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

//	List<Employee> deleteAll(Employee employee);

}
