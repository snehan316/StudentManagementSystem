package com.pst.sms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pst.sms.DTO.StudentDTO;
import com.pst.sms.service.StudentService;

@WebServlet("/SearchStudentController")
public class SearchStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	StudentService service = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rollNumber = Integer.parseInt(request.getParameter("rollNumber"));
		service= new StudentService();
		StudentDTO studentDTO =  service.searchStudent(rollNumber);
		request.setAttribute("dto", studentDTO);
		
		request.getRequestDispatcher("./update_student.jsp").forward(request, response);
		
	}

}
