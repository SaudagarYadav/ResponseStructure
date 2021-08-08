package com.responseStructure.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.ServletContext;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.responseStructure.dao.EmployeeDAO;
import com.responseStructure.pojo.EmployeeDetails;
import com.responseStructure.pojo.EmployeeRequest;
import com.responseStructure.util.SSHJService;
import com.responseStructure.util.XMLService;

public class EmployeeService {

	final String fileName = "EmployeeDetail.xml";
	final String localFilePath = "";
	final String remoteFilePath = "/retaildev/";
	
	/**
	 * Write business logic in this method
	 * 
	 * @param requestData
	 * @return 
	 * @throws JAXBException
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws SftpException 
	 * @throws JSchException 
	 */
	public String getEmployeeData(EmployeeRequest requestData) throws JAXBException, IOException, URISyntaxException, JSchException, SftpException {

		// Step 2: Call dao method to get data from data as per request
		EmployeeDetails employeeData = EmployeeDAO.getEmployeeData(requestData);

		// Step 3: Covert bean from XML
		final String xmlData = XMLService.createXML(EmployeeDetails.class, employeeData, "EmployeeDetails");

		// Step 4: Create XML file and store as per requirnment
		createFile(localFilePath+fileName, xmlData);
		
		// Step 5: Upload file at Remote location
		final boolean uploadStatus = SSHJService.uploadFile(localFilePath+fileName, remoteFilePath+fileName);
		if (uploadStatus) {
			System.out.println("Uploaded Successfully");
		} else {
			System.out.println("Upload failed");
		}
		return xmlData;
	}

	/**
	 * This method is responsible for creating file at provided location
	 * 
	 * @param fileName
	 * @param fileContent
	 * @throws IOException
	 */
	public static void createFile(final String fileName, final String fileContent) throws IOException {
		FileWriter writer = null;
		try {
			final File file = new File(fileName);
			writer = new FileWriter(fileName);
			writer.write(fileContent);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}

}
