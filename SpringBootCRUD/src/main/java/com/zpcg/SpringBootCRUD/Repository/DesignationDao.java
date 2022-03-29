package com.zpcg.SpringBootCRUD.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zpcg.SpringBootCRUD.Model.Designation;
import com.zpcg.SpringBootCRUD.Model.Employee;

@Repository
public interface DesignationDao extends JpaRepository<Designation, Integer> {

	List<Employee> findByDesignationName(String designationName);

}
