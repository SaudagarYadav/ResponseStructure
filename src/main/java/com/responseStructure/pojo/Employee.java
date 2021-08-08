package com.responseStructure.pojo;

import java.util.List;

public class Employee {

	private String name;
	private String empId;
	private WorkHistory companyDetail;

	public Employee(String name, String empId, WorkHistory companyDetail) {
		super();
		this.name = name;
		this.empId = empId;
		this.companyDetail = companyDetail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public WorkHistory getCompanyDetail() {
		return companyDetail;
	}

	public void setCompanyDetail(WorkHistory companyDetail) {
		this.companyDetail = companyDetail;
	}

}
