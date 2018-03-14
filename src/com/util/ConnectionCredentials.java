package com.util;

public class ConnectionCredentials {
	private String user = "root";
	private String password = "root";
	private String url = "jdbc:mysql://localhost:3306/workoutdiary";

	public String getPassword() {
		return password;
	}

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}
}
