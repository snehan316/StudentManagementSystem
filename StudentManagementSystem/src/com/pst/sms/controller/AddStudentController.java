package com.pst.sms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pst.sms.VO.StudentVO;
import com.pst.sms.service.StudentService;

/**
 * Servlet implementation class AddStudentController
 */
@WebServlet("/AddStudentController")
public class AddStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	StudentVO studentVO = null;
  	StudentService studentService =null;
  	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rollNumber =Integer.parseInt( request.getParameter("roll_number"));
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String course = request.getParameter("course");
		
		studentVO = new StudentVO();
		studentVO.setRollNumber(rollNumber);
		studentVO.setName(name);
		studentVO.setGender(gender);
		studentVO.setCourse(course);
		
		studentService = new StudentService();
		studentService.saveData(studentVO);

	}
}
