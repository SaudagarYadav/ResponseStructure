package com.responseStructure.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "EmployeeRequest")
public class EmployeeRequest {

	private List<String> idList;

	public List<String> getIdList() {
		return idList;
	}

	@XmlElement(name = "id")
	public void setIdList(List<String> idList) {
		this.idList = idList;
	}
}
