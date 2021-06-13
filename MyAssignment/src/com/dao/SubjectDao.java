package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.models.Classes;
import com.models.FirstYearSubject;
import com.models.FourthYearSubject;
import com.models.SecondYearSubject;
import com.models.ThirdYearSubject;

public class SubjectDao {
public List<FirstYearSubject> getAllSubjects() {
		
		List<FirstYearSubject> subList = new ArrayList<FirstYearSubject>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/trainingdb", "root", "oracle@12345");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM FirstYearSubject");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				FirstYearSubject subject=new FirstYearSubject();
				subject.setSubjectname(rs.getString(1));
				subList.add(subject);
			}
			connection.close();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return subList;
	}
public List<SecondYearSubject> getAllSubjects1() {
List<SecondYearSubject> subList = new ArrayList<SecondYearSubject>();

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/trainingdb", "root", "oracle@12345");
	PreparedStatement statement = connection.prepareStatement("SELECT * FROM SecondYearSubject");
	ResultSet rs = statement.executeQuery();
	while(rs.next()) {
		SecondYearSubject subject=new SecondYearSubject();
		subject.setSubjectname(rs.getString(1));
		subList.add(subject);
	}
	connection.close();
} catch(Exception ex) {
	System.out.println(ex.getMessage());
}

return subList;
}
public List<ThirdYearSubject> getAllSubjects2() {
List<ThirdYearSubject> subList = new ArrayList<ThirdYearSubject>();

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/trainingdb", "root", "oracle@12345");
	PreparedStatement statement = connection.prepareStatement("SELECT * FROM ThirdYearSubject");
	ResultSet rs = statement.executeQuery();
	while(rs.next()) {
		ThirdYearSubject subject=new ThirdYearSubject();
		
		subject.setSubjectname(rs.getString(1));
		subList.add(subject);
	}
	connection.close();
} catch(Exception ex) {
	System.out.println(ex.getMessage());
}

return subList;
}
public List<FourthYearSubject> getAllSubjects3() {
List<FourthYearSubject> subList = new ArrayList<FourthYearSubject>();

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/trainingdb", "root", "oracle@12345");
	PreparedStatement statement = connection.prepareStatement("SELECT * FROM FourthYearSubject");
	ResultSet rs = statement.executeQuery();
	while(rs.next()) {
		FourthYearSubject subject=new FourthYearSubject();
		subject.setSubjectname(rs.getString(1));
		subList.add(subject);
	}
	connection.close();
} catch(Exception ex) {
	System.out.println(ex.getMessage());
}

return subList;
}

}

