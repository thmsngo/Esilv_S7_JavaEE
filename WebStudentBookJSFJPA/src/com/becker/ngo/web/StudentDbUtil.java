package com.becker.ngo.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean(eager=true)
//Si on met pas eager, il fait une lazy instanciation c'est à dire qu'il ne passe pas par le constructeur
@ApplicationScoped


public class StudentDbUtil {
		
	
	 private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("JSFJPA");
	 EntityManager em = factory.createEntityManager();
	
	//private EntityManagerFactory factory;
	//private static final String PERSIS_NAME = "JSFJPA";
	//factory = Persistence.createEntityManagerFactory(PERSIS_NAME);
	 
	 public static List<Student> getStudents(){
			
			List<Student> students= new ArrayList<Student>();
			return students;
		}
		
		public static void addStudent(Student student) {
					
		}
			
		
		public static Student fetchStudent(int id) {
			return new Student();
		}
		
		public static void updateStudent(Student student) {
			
		}
		
		public static void deleteStudent(int id) {
						
		}
}
