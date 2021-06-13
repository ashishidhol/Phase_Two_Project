package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SecondDao;
import com.models.FirstYear;
import com.models.SecondYear;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet(name = "SecondServlet", value = {"/SecondServlet", "/addNewStudent1", "/insertStudent1","/listStudents1"})
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       SecondDao secondDao=new SecondDao();
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getServletPath();
		System.out.println(action);
    	try {
switch(action) {
			
			case "/addNewStudent1":
				addNewStudent(request,response);
				break;
			case "/insertStudent1":
				insertStudent(request, response);
				break;
			case "/listStudents1":
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
 		SecondYear student=new SecondYear();
 		student.setId(Integer.parseInt(request.getParameter("id")));
		student.setFirstName(request.getParameter("fname"));
		student.setLastName(request.getParameter("lname"));
		student.setAge(Integer.parseInt(request.getParameter("age")));
		student.setEmail(request.getParameter("email"));
		secondDao.insertStudent(student);
		response.sendRedirect("listStudents1");
		
	}
	private void addNewStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("addstudent2.jsp");
		dispatcher.forward(request, response);	
		
	}
	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
 		List<SecondYear> studentList=secondDao.getAllStudents();
 		request.setAttribute("students", studentList);
 		RequestDispatcher dispatcher = request.getRequestDispatcher("second.jsp");
 		dispatcher.forward(request, response);
	}

	}