package com.becker.ngo.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.omg.CORBA.SystemException;

@ManagedBean(eager=true)
//Si on met pas eager, il fait une lazy instanciation c'est à dire qu'il ne passe pas par le constructeur
@ApplicationScoped


public class StudentDbUtil {
		
	
	 private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("JSFJPA");
	 static EntityManager em = factory.createEntityManager();
	
	//private EntityManagerFactory factory;
	//private static final String PERSIS_NAME = "JSFJPA";
	//factory = Persistence.createEntityManagerFactory(PERSIS_NAME);
	 
	 public static List<Student> getStudents(){
			
			List<Student> students;
			
			students = em.createQuery("SELECT s FROM Student AS s").getResultList();
			
			return students;
		}
		
		public static void addStudent(Student student) {
					
			try {
				em.getTransaction().begin();
				em.persist(student);
				em.getTransaction().commit();
			}
			catch(SystemException e){
				e.printStackTrace();
			}
		}
			
		
		public static Student fetchStudent(int id) {
			Student student = em.find(Student.class, id);
			return student;
		}
		
		public static void updateStudent(Student student) {
			
			Student studentToUpdate = em.find(Student.class, student.getId());
			
			try {
				em.getTransaction().begin();
				studentToUpdate.setFirstName(student.getFirstName());
				studentToUpdate.setLastName(student.getLastName());
				studentToUpdate.setEmail(student.getEmail());
				em.getTransaction().commit();
			}
			catch(SystemException e) {
				e.printStackTrace();
			}
			
		}
		
		public static void deleteStudent(int id) {
			
			Student oldStudent = em.find(Student.class, id);
			
			try {
				em.getTransaction().begin();
				em.remove(oldStudent);
				em.getTransaction().commit();
			}
			catch(SystemException e) {
				e.printStackTrace();
			}				
		}
}
