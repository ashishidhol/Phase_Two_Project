package com.web;

import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SubjectDao;
import com.dao.TeacherDao;
import com.models.*;

@WebServlet(name = "TeacherServlet", value = {"/TeacherServlet", "/assignSubject","/assignSubject1","/assignSubject2","/assignSubject3", "/insertSubject","/listTeachers"})
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    SubjectDao subjectDao=new SubjectDao();
	TeacherDao teacherDao=new TeacherDao();
    public TeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	subject_assign(request, response);
    }
    protected void doGet1(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	subject_assign1(request, response);
    }
    protected void doGet2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	subject_assign2(request, response);
    }
    protected void doGet3(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	subject_assign3(request, response);
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String action = request.getServletPath();
		System.out.println(action);
    	try {
switch(action) {
			
			case "/assignSubject":
				subject_assign(request,response);
				break;
			case "/assignSubject1":
				subject_assign1(request,response);
				break;
			case "/assignSubject2":
				subject_assign2(request,response);
				break;
			case "/assignSubject3":
				subject_assign3(request,response);
				break;
				
			case "/insertSubject":
				insertSubject(request, response);
				break;
			case "/listTeachers":
				listTeachers(request, response);
				break;
			default:
 			listTeachers(request, response);
 			break;
 		} }
catch (Exception ex) {
 			System.out.println(ex.getMessage());
 		}
 	}
    
    
 	private void insertSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Teacher teacher=new Teacher();
 		teacher.setId(Integer.parseInt(request.getParameter("id")));
		teacher.setName(request.getParameter("name"));
		teacher.setGender(request.getParameter("gender"));
		teacher.setAssign_class(request.getParameter("assign_class"));
		teacher.setSub_assign(request.getParameter("assign_subject"));
		teacherDao.assignSubject(teacher);
		response.sendRedirect("listTeachers");
		
	}
 	 	
 	 
	private void subject_assign(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FirstYearSubject> subList=subjectDao.getAllSubjects();
		
 		request.setAttribute("subjects", subList);
 		RequestDispatcher dispatcher = request.getRequestDispatcher("subject_assign.jsp");
		dispatcher.forward(request, response);	
		
	}
	private void subject_assign1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<SecondYearSubject> subList1=subjectDao.getAllSubjects1();
		request.setAttribute("subjects1", subList1);
 		RequestDispatcher dispatcher = request.getRequestDispatcher("subject_assign1.jsp");
		dispatcher.forward(request, response);	
		
	}
private void subject_assign2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ThirdYearSubject> subList2=subjectDao.getAllSubjects2();
		request.setAttribute("subjects2", subList2);
 		RequestDispatcher dispatcher = request.getRequestDispatcher("subject_assign2.jsp");
		dispatcher.forward(request, response);	
		
	}
private void subject_assign3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	List<FourthYearSubject> subList3=subjectDao.getAllSubjects3();
	request.setAttribute("subjects3", subList3);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subject_assign3.jsp");
	dispatcher.forward(request, response);	
	
}
	private void listTeachers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
 		List<Teacher> teacherList=teacherDao.getAllteachers();
 		request.setAttribute("teachers", teacherList);
 		RequestDispatcher dispatcher = request.getRequestDispatcher("teachers.jsp");
 		dispatcher.forward(request, response);
	}

	}
