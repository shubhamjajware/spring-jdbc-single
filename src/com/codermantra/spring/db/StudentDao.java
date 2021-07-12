package com.codermantra.spring.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;

public class StudentDao {
	
	private String driver;
	private String url;
	private String user;
	private String password;
	Connection con;
	
	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@PostConstruct
	public void createDbConnection() throws ClassNotFoundException, SQLException {
		//Load driver
				Class.forName(driver);
				
				//Get a connection
				con = DriverManager.getConnection(url, user, password); 
		
	}

	public void selectAllrows() throws ClassNotFoundException, SQLException {
		
		System.out.println("Retrieving all student details");
		//createDbConnection();
		
		
		//Execute query
		Statement stmt = con.createStatement();
		
		//
		ResultSet rs = stmt.executeQuery("SELECT * FROM ESNew.HostelStudentInfo");
		
		while(rs.next()) {
			int studentId = rs.getInt(1);
			String studentName = rs.getString(2);
			String studentFee = rs.getString(3);
			String foodType = rs.getString(4);
			
			System.out.println(studentId+" || "+studentName+" || "+studentFee+" || "+foodType);
		}
		closeConnection();
	}
	
	public void deleteAllRows(int studentId) throws ClassNotFoundException, SQLException {
				
				createDbConnection();
				//Execute query
				Statement stmt = con.createStatement();
				//
				/* ResultSet rs = */
				stmt.executeUpdate("delete from ESNew.HostelStudentInfo where Student_id = "+studentId);
				
				System.out.println("Row deleted with id = "+studentId);
				
				closeConnection();
	}
	
	public void closeConnection() throws SQLException {
		con.close();
	}
	
	
	

}
