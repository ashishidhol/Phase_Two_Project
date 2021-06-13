package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SubjectDao;
import com.models.FirstYearSubject;
import com.models.FourthYearSubject;
import com.models.SecondYearSubject;
import com.models.ThirdYearSubject;


/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    SubjectDao subjectDao=new SubjectDao();
    public SubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listSubject(request, response);
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
 			listSubject(request, response);
 			
 		} catch (Exception ex) {
 			System.out.println(ex.getMessage());
 		}
	}

	private void listSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FirstYearSubject> subList=subjectDao.getAllSubjects();
		List<SecondYearSubject> subList1=subjectDao.getAllSubjects1();
		List<ThirdYearSubject> subList2=subjectDao.getAllSubjects2();
		List<FourthYearSubject> subList3=subjectDao.getAllSubjects3();
 		request.setAttribute("subjects", subList);
 		request.setAttribute("subjects1", subList1);
 		request.setAttribute("subjects2", subList2);
 		request.setAttribute("subjects3", subList3);
 		RequestDispatcher dispatcher = request.getRequestDispatcher("subjects.jsp");
 		dispatcher.forward(request, response);
		
	}
	
}
