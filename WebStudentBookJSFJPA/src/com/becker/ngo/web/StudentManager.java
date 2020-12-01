package com.becker.ngo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped

public class StudentManager {
				
	List<Student> students;
	
	public StudentManager() {
		students = new ArrayList<Student>();
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void loadStudents() {
		this.students = StudentDbUtil.getStudents();	
	}
	
	public String addStudent(Student stu) {
		
		StudentDbUtil.addStudent(stu);
				
		return "List-students";
	}
	
	public String loadStudent(int id) {
		
		Student theStudent = StudentDbUtil.fetchStudent(id);
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> requestMap = externalContext.getRequestMap();
		requestMap.put("student", theStudent);
		
		return "Edit-student";
	}
	
	
	
	public String updateStudent(Student stu) {
		
		StudentDbUtil.updateStudent(stu);
						
		return "List-students";
	}
	
	public String deleteStudent(int id) {
		
		StudentDbUtil.deleteStudent(id);
						
		return "List-students";
	}

}
