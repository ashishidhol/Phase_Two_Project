package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FourthDao;
import com.models.FirstYear;
import com.models.FourthYear;
import com.models.ThirdYear;

/**
 * Servlet implementation class FourthServlet
 */
@WebServlet(name = "FourthServlet", value = {"/FourthServlet", "/addNewStudent3", "/insertStudent3","/listStudents3"})
public class FourthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   FourthDao fourthDao=new FourthDao();
    public FourthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getServletPath();
		System.out.println(action);
    	try {
switch(action) {
			
			case "/addNewStudent3":
				addNewStudent(request,response);
				break;
			case "/insertStudent3":
				insertStudent(request, response);
				break;
			case "/listStudents3":
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
 		FourthYear student=new FourthYear();
 		student.setId(Integer.parseInt(request.getParameter("id")));
		student.setFirstName(request.getParameter("fname"));
		student.setLastName(request.getParameter("lname"));
		student.setAge(Integer.parseInt(request.getParameter("age")));
		student.setEmail(request.getParameter("email"));
		fourthDao.insertStudent(student);
		response.sendRedirect("listStudents3");
		
	}
	private void addNewStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("addstudent4.jsp");
		dispatcher.forward(request, response);	
		
	}
 	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
 		List<FourthYear> studentList=fourthDao.getAllStudents();
 		request.setAttribute("students", studentList);
 		RequestDispatcher dispatcher = request.getRequestDispatcher("fourth.jsp");
 		dispatcher.forward(request, response);
	}

	}