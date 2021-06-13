package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ThirdDao;
import com.models.FirstYear;
import com.models.ThirdYear;

/**
 * Servlet implementation class ThirdServlet
 */
@WebServlet(name = "ThirdServlet", value = {"/ThirdServlet", "/addNewStudent2", "/insertStudent2","/listStudents2"})
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   ThirdDao thirdDao=new ThirdDao();
    public ThirdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getServletPath();
		System.out.println(action);
    	try {
switch(action) {
			
			case "/addNewStudent2":
				addNewStudent(request,response);
				break;
			case "/insertStudent2":
				insertStudent(request, response);
				break;
			case "/listStudents2":
				listStudents(request, response);
				break;
			default:
 			listStudents(request, response);
 			break;
 		}
    		
    		
    		
    		listStudents(request, response);
 		} catch (Exception ex) {
 			System.out.println(ex.getMessage());
 		}
 	}

 	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		ThirdYear student=new ThirdYear();
 		student.setId(Integer.parseInt(request.getParameter("id")));
		student.setFirstName(request.getParameter("fname"));
		student.setLastName(request.getParameter("lname"));
		student.setAge(Integer.parseInt(request.getParameter("age")));
		student.setEmail(request.getParameter("email"));
		thirdDao.insertStudent(student);
		response.sendRedirect("listStudents2");
		
	}
	private void addNewStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("addstudent3.jsp");
		dispatcher.forward(request, response);	
		
	}
	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
 		List<ThirdYear> studentList=thirdDao.getAllStudents();
 		request.setAttribute("students", studentList);
 		RequestDispatcher dispatcher = request.getRequestDispatcher("third.jsp");
 		dispatcher.forward(request, response);
	}

	}