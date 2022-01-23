package com.pst.sms.service;

import java.util.List;

import com.pst.sms.DTO.StudentDTO;
import com.pst.sms.VO.StudentVO;
import com.pst.sms.bo.StudentBO;
import com.pst.sms.dao.StudentDAO;

public class StudentService {

	StudentDAO studentDAO = null;
	StudentBO studentBO = null;
	public int saveData(StudentVO studentVO) {
		//business logic
		studentDAO = new StudentDAO();
		studentBO = new StudentBO();
		
		studentBO.setRollNumber(studentVO.getRollNumber());
		studentBO.setName(studentVO.getName());
		studentBO.setGender(studentVO.getGender());
		studentBO.setCourse(studentVO.getCourse());
		
		int i = studentDAO.addStudent(studentBO);
		return i;
	}
	
	public List<StudentDTO> getAllStudents() {
		studentDAO = new StudentDAO();
		return studentDAO.viewStudents();
	}
	
	public boolean removeStudent(int rollNumber) {
		studentDAO = new StudentDAO();
		return studentDAO.delete(rollNumber);
	}
}
