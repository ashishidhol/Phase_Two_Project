package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.models.FirstYear;
import com.models.Teacher;


public class FirstDao {
public List<FirstYear> getAllStudents() {
		
		List<FirstYear> studentList = new ArrayList<FirstYear>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/trainingdb", "root", "oracle@12345");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM FirstYear");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				FirstYear student=new FirstYear();
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


public void insertStudent(FirstYear teach) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/trainingdb", "root", "oracle@12345");
		PreparedStatement statement = connection.prepareStatement("INSERT INTO FirstYear(id,firstname,lastname,age,email) values(?,?,?,?,?)");
		
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


