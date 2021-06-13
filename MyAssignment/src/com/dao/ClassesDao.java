package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.models.Classes;


public class ClassesDao {
public List<Classes> getAllclasses() {
		
		List<Classes> classList = new ArrayList<Classes>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/trainingdb", "root", "oracle@12345");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM classes");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Classes classes=new Classes();
				classes.setClassid(rs.getInt(1));
				classes.setClassname(rs.getString(2));
				classList.add(classes);
			}
			connection.close();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return classList;
	}

	}

