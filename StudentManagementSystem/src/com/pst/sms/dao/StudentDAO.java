package com.pst.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pst.sms.DTO.StudentDTO;
import com.pst.sms.bo.StudentBO;
import com.pst.sms.util.DbConnection;

public class StudentDAO {
	private final String SAVE_STUDENT = "insert into student(rollnumber, studentName, gender, course)values(?, ?, ?, ?)";
	private final String VIEW_STUDENT = "select rollnumber, studentName, gender, course from student ";
	private final String DELETE_STUDENT = "delete from student where rollNumber=?";

	public int addStudent(StudentBO studentBO){
		// do database operations
	
		int i = 0;
		try {
			Connection conn = DbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SAVE_STUDENT);
			ps.setInt(1, studentBO.getRollNumber());
			ps.setString(2, studentBO.getName());
			ps.setString(3, studentBO.getGender());
			ps.setString(4, studentBO.getCourse());
			
			i = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
	
	public List<StudentDTO> viewStudents() {
		StudentDTO studentDTO = null;
		List<StudentDTO> studentList = new ArrayList<>();
		try{
			Connection conn = DbConnection.getConnection();
			PreparedStatement ps =  conn.prepareStatement(VIEW_STUDENT);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				studentDTO = new StudentDTO();
				studentDTO.setRollNumber(rs.getInt(1));
				studentDTO.setName(rs.getString(2));
				studentDTO.setGender(rs.getString(3));
				studentDTO.setCourse(rs.getString(4));
				studentList.add(studentDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return studentList;
	}
	
	
	public boolean delete(int rollNumber) {
		boolean status = true;
		try {
		Connection conn = DbConnection.getConnection();
		PreparedStatement ps =  conn.prepareStatement(DELETE_STUDENT);
		ps.setInt(1, rollNumber);
		status = ps.execute();
		System.out.println("status:: " + status );
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
}
