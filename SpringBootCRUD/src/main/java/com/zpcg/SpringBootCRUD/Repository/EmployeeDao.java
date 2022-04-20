package com.zpcg.SpringBootCRUD.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zpcg.SpringBootCRUD.Model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	List<Employee> findBySalary(Double salary);

     //	List<Employee> findByDesg(String designationName);

     //	List<Employee> deleteAll(Employee employee);
	
	
	// a custom query for the retrieving employee based upon names
	@Query(value = "SELECT e FROM Employee e ORDER BY lastName  ")
	   public List<Employee> findAllSortedByName();
	
	
	// a custom query for the retrieving employee based upon salary
	@Query(value = "SELECT e FROM Employee e ORDER BY salary DESC")
	   public List<Employee> findAllSortedBySalary();

}
