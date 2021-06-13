package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.*;
import com.dao.*;
/**
 * Servlet implementation class ViewAllRecordServlet
 */
@WebServlet("/ViewAllRecordServlet")
public class ViewAllRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       FirstDao firstDao=new FirstDao();
       SecondDao secondDao=new SecondDao();
       ThirdDao thirdDao=new ThirdDao();
       FourthDao fourthDao=new FourthDao();
       TeacherDao teacherDao=new TeacherDao();
       SubjectDao subjectDao=new SubjectDao();
       ClassesDao classesDao=new ClassesDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllRecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
 			listStudents1(request, response);
 			
 		} catch (Exception ex) {
 			System.out.println(ex.getMessage());
 		}
	}
	private void listStudents1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
 		List<FirstYear> studentList=firstDao.getAllStudents();
 		List<SecondYear> studentList1=secondDao.getAllStudents();
 		List<ThirdYear> studentList2=thirdDao.getAllStudents();
 		List<FourthYear> studentList3=fourthDao.getAllStudents();
 		request.setAttribute("students", studentList);
 		request.setAttribute("students1", studentList1);
 		request.setAttribute("students2", studentList2);
 		request.setAttribute("students3", studentList3);
 		RequestDispatcher dispatcher = request.getRequestDispatcher("allStudent.jsp");
 		dispatcher.forward(request, response);
	}
}
