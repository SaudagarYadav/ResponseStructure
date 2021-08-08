package com.responseStructure.util;

import java.io.IOException;
import java.util.Properties;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SSHJService {
	
	// This 4 credentials you will get from creating file store in remote location or on cloud  
	static String remoteHost = "172.29.176.5";
	static int port = 890;
	static String username = "cep-sftp-dev-retail-user";
	static String password = "Leeo#67!#14";

	
	public static boolean uploadFile(String localFilePath, String remoteFilePath)
			throws JSchException, SftpException, IOException {

		ChannelSftp channelSftp = getSftpConnection();
		channelSftp.put(localFilePath, remoteFilePath);
		channelSftp.disconnect();
		return true;
	}
	
	private static ChannelSftp getSftpConnection() throws JSchException, SftpException, IOException {

		Properties config = new java.util.Properties();
		config.put("StrictHostKeyChecking", "no");

		JSch ssh = new JSch();
		Session session = ssh.getSession(username, remoteHost, port);
		session.setConfig(config);
		session.setPassword(password);
		session.connect();

		ChannelSftp sftp = (ChannelSftp) session.openChannel("sftp");
		sftp.connect();

		return sftp;
	}

}
