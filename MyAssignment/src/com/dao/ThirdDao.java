package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.models.ThirdYear;



public class ThirdDao {
public List<ThirdYear> getAllStudents() {
		
		List<ThirdYear> studentList = new ArrayList<ThirdYear>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/trainingdb", "root", "oracle@12345");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM ThirdYear");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				ThirdYear student=new ThirdYear();
				student.setId(rs.getInt(1));
				student.setFirstName(rs.getString(2));
				student.setLastName(rs.getString(3));
				student.setAge(rs.getInt(4));
				student.setEmail(rs.getString(5));
				
				studentList.add(student);
			}
			connection.close();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return studentList;
	}

public void insertStudent(ThirdYear teach) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/trainingdb", "root", "oracle@12345");
		PreparedStatement statement = connection.prepareStatement("INSERT INTO ThirdYear(id,firstname,lastname,age,email) values(?,?,?,?,?)");
		
statement.setInt(1, teach.getId());
statement.setString(2, teach.getFirstName());
statement.setString(3,teach.getLastName());
statement.setInt(4,teach.getAge());
statement.setString(5, teach.getEmail());
int rows = statement.executeUpdate();
		if(rows > 1) {
			System.out.println("Student added Successfully.");
		} else {
			System.out.println("There is some error while inserting student.");
		}
connection.close();
} catch(Exception ex) {
System.out.println(ex.getMessage());
}

}

}


