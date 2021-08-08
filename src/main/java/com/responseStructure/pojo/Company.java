package com.responseStructure.pojo;

public class Company {

	private String joiningDate;
	private String lastWorkingDate;
	private String companyName;
	private String position;

	public Company(String joiningDate, String lastWorkingDate, String companyName, String position) {
		super();
		this.joiningDate = joiningDate;
		this.lastWorkingDate = lastWorkingDate;
		this.companyName = companyName;
		this.position = position;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getLastWorkingDate() {
		return lastWorkingDate;
	}

	public void setLastWorkingDate(String lastWorkingDate) {
		this.lastWorkingDate = lastWorkingDate;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
