package com.responseStructure.dao;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.responseStructure.pojo.Company;
import com.responseStructure.pojo.Employee;
import com.responseStructure.pojo.EmployeeDetails;
import com.responseStructure.pojo.EmployeeRequest;
import com.responseStructure.pojo.WorkHistory;

public class EmployeeDAO {

	/**
	 * Write DB connection logic and get data from DB. for demo, returning request
	 * data.
	 * 
	 * @param requestData
	 * @return
	 * @throws JAXBException
	 */
	public static EmployeeDetails getEmployeeData(EmployeeRequest requestData) throws JAXBException {
		final EmployeeDetails details = new EmployeeDetails();
		details.setEmployee(getEmployeeDetail(requestData));
		return details;
	}

	/**
	 * Static data
	 * 
	 * @param requestData
	 * @return
	 * @throws JAXBException
	 */
	private static List<Employee> getEmployeeDetail(final EmployeeRequest requestData) throws JAXBException {
		List<Employee> employeeList = new ArrayList<>();
		requestData.getIdList().forEach(id -> employeeList.add(new Employee("EmployeeName-" + id, id, getWorkHistory())));
		return employeeList;
	}

	/**
	 * Static data
	 *
	 * 
	 * @return
	 */
	private static WorkHistory getWorkHistory() {
		final WorkHistory workHistory = new WorkHistory();
		final List<Company> CompanyList = new ArrayList<>();
		CompanyList.add(new Company("21-01-2016", "25-06-2018", "Company1", "Jr. Software developer"));
		CompanyList.add(new Company("15-07-2018", "01-06-2019", "Company2", "Software developer"));
		CompanyList.add(new Company("15-06-2019", "Present", "Company3", "Sr. Software developer"));
		workHistory.setCompanies(CompanyList);
		return workHistory;
	}
}
