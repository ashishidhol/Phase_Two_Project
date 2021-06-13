package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FirstDao;
import com.models.FirstYear;
import com.models.Teacher;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(name = "FirstServlet", value = {"/FirstServlet", "/addNewStudent", "/insertStudent","/listStudents"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       FirstDao firstDao=new FirstDao();
   
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getServletPath();
		System.out.println(action);
    	try {
switch(action) {
			
			case "/addNewStudent":
				addNewStudent(request,response);
				break;
			case "/insertStudent":
				insertStudent(request, response);
				break;
			case "/listStudents":
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
 		FirstYear student=new FirstYear();
 		student.setId(Integer.parseInt(request.getParameter("id")));
		student.setFirstName(request.getParameter("fname"));
		student.setLastName(request.getParameter("lname"));
		student.setAge(Integer.parseInt(request.getParameter("age")));
		student.setEmail(request.getParameter("email"));
		firstDao.insertStudent(student);
		response.sendRedirect("listStudents");
		
	}
	private void addNewStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("addstudent1.jsp");
		dispatcher.forward(request, response);	
		
	}
	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
 		List<FirstYear> studentList=firstDao.getAllStudents();
 		request.setAttribute("students", studentList);
 		RequestDispatcher dispatcher = request.getRequestDispatcher("first.jsp");
 		dispatcher.forward(request, response);
	}

	}