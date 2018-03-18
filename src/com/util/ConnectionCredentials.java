package com.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectionCredentials {

	private String user;
	private String password;
	private String url;
	private List<String> list;

	public ConnectionCredentials() {
		File file = new File("config.conf");
		list = new ArrayList<>();
		Scanner input;

		try {
			input = new Scanner(file);
			while (input.hasNextLine()) {
				list.add(input.nextLine());
			}

			user = list.get(0);
			password = list.get(1);
			url = list.get(2);

		} catch (FileNotFoundException e) {
			System.err.println(e);
		}
	}

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
