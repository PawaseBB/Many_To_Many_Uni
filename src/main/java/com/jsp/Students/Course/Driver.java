package com.jsp.Students.Course;


import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("bhushan");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student student=new Student();
		student.setName("Bhushan");
		student.setEmail("bhushan@gmail.com");
		
		Courses courses1=new Courses();
		courses1.setName("java");
		courses1.setDuration(60);
		
		Courses courses2=new Courses();
		courses2.setName("SQL");
		courses2.setDuration(40);
		
		Courses courses3=new Courses();
		courses3.setName("HTML");
		courses3.setDuration(30);
		
		ArrayList<Courses> courses=new ArrayList<Courses>();
		
		courses.add(courses1);
		courses.add(courses2);
		courses.add(courses3);
		
		student.setCourses(courses);
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityManager.persist(courses1);
		entityManager.persist(courses2);
		entityManager.persist(courses3);
		
		entityTransaction.commit();
	}

}
