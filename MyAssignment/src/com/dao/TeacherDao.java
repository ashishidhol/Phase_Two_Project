package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import com.models.Teacher;

public class TeacherDao {
public List<Teacher> getAllteachers() {
		
		List<Teacher> teacherList = new ArrayList<Teacher>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/trainingdb", "root", "oracle@12345");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM teacher");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Teacher teacher=new Teacher();
				teacher.setId(rs.getInt(1));
				teacher.setName(rs.getString(2));
				teacher.setGender(rs.getString(3));
				teacher.setAssign_class(rs.getString(4));
				teacher.setSub_assign(rs.getString(5));
				teacherList.add(teacher);
			}
			connection.close();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return teacherList;
	}

			public void assignSubject(Teacher teach) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection
							("jdbc:mysql://localhost:3306/trainingdb", "root", "oracle@12345");
					PreparedStatement statement = connection.prepareStatement("INSERT INTO teacher(id,name,gender,assign_class,assign_subject) values(?,?,?,?,?)");
					
			statement.setInt(1, teach.getId());
			statement.setString(2, teach.getName());
			statement.setString(3,teach.getGender());
			statement.setString(4, teach.getAssign_class());
			statement.setString(5, teach.getSub_assign());
			int rows = statement.executeUpdate();
					if(rows > 1) {
						System.out.println("Subject assign Successfully.");
					} else {
						System.out.println("There is some error while inserting values.");
					}
			connection.close();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		
	}

	}
