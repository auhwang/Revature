package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connections {
	private static Connection conn = null;
	private final static String FILE_NAME = "dbprops.properties";
	private static Properties prop = null;
	
	public static Connection getConnection() {
		try {
			
			//HARD CORDED CONNECTION
//			Class.forName("driver here");
//			conn = DriverManager.getConnection(
//					"url here", //url
//					//MAC USERS
//					//"url here"
//					"username", //username
//					"password" //password
//					);
			
			//Connection via property file
			/*
			 * A property file aids in making for a more dynamic application. As
			 * opposed to having to change the actual code for connection details,
			 * re-compile, then redeploy, a process that could take a day in most 
			 * enterprises. Is now simply having to change an on-computer text file.
			 */
			
			prop = new Properties();
			prop.load(new FileInputStream(FILE_NAME));
			
			//load from properties file
//			
//			Class.forName(prop.getProperty("class"));
//			conn = DriverManager.getConnection(
//					prop.getProperty("url"),
//					prop.getProperty("username"),
//					prop.getProperty("password"));
			
			//Environment variable setup using .bash_profile
			//may have to launch IDE through terminal
			String props[] = System.getenv("AWSVARS").split(";");
			Class.forName(props[0]);
			conn = DriverManager.getConnection(props[1],props[2],props[3]);
			
			System.out.println("DATABASE CONNECTION SUCCESS!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DATABASE CONNECTION FAILED.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ORACLE DRIVER CLASS NOT FOUND.");
		} catch (IOException e){
			e.printStackTrace();
		}
		return conn;
	}
}
