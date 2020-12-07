package com.jsf.web;


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
	//Constructor 
	public StudentManager() {
	}
	public StudentManager(List<Student> students) {
		this.students = students;
	}
	
	//Getters & Setters
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public void loadStudents() throws Exception
	{
		this.students = StudentDbUtil.getStudents();
	}
	public String loadStudents(int id) throws Exception
	{
		Student theStudent = StudentDbUtil.loadStudent(id);
		ExternalContext externalContext =FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> requestMap = externalContext.getRequestMap();
		requestMap.put("student", theStudent);
		return "Edit-student";
	}
	public String updateStudent(Student stu) throws Exception 
	{
		
		StudentDbUtil.updateStudent(stu);
		return "List-students";
		
	}
	public String deleteStudent(int id)throws Exception 
	{
		
		StudentDbUtil.deleteStudent(id);
		return "List-students";

	}
	public String addStudent(Student stu) throws Exception 
	{
		
		StudentDbUtil.addStudent(stu);
		return "List-students";
		
	}


}
