package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ClassesDao;
import com.models.Classes;
import com.models.Teacher;

/**
 * Servlet implementation class ClassesServlet
 */
@WebServlet("/ClassesServlet")
public class ClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ClassesDao classesDao=new ClassesDao();
    public ClassesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
 			listClasses(request, response);
 		} catch (Exception ex) {
 			System.out.println(ex.getMessage());
 		}
 	}

 	private void listClasses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
 		List<Classes> classList=classesDao.getAllclasses();
 		request.setAttribute("classes", classList);
 		RequestDispatcher dispatcher = request.getRequestDispatcher("classes.jsp");
 		dispatcher.forward(request, response);
	}

	}

