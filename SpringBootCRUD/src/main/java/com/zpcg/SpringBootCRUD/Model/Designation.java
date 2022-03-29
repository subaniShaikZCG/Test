package com.zpcg.SpringBootCRUD.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="EmpDesignation")
public class Designation {
	
	@Id
	@GeneratedValue
//	@OneToOne(name="empId")
	private int desId;
	private String designationName;
	private String description;
	
}
