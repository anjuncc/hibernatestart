package a.j.hibernatestart.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import a.j.hibernatestart.model.Student;
import a.j.hibernatestart.model.University;
import a.j.hibernatestart.util.HibernateUtil;

public class ManytoOneDemo {

	public static void main(String[] args) {
		   Student student1 = new Student("Sam","Disilva","Maths");
	        Student student2 = new Student("Joshua", "Brill", "Science");
	        Student student3 = new Student("Peter", "Pan", "Physics");
	         
	        University university = new University("CAMBRIDGE", "ENGLAND");
	 
//	        student1.setUniversity(university);
//	        student2.setUniversity(university);
//	        student3.setUniversity(university);
//	 
//	 
//	        Session session = HibernateUtil.getSessionFactory().openSession();
//	        session.beginTransaction();
//	 
//	        session.persist(university);
//	        session.persist(student1);
//	        session.persist(student2);
//	        session.persist(student3);
	         
	        
	        List<Student> allStudents = new ArrayList<Student>();
	        
	        student1.setUniversity(university);
	        student2.setUniversity(university);
	        student3.setUniversity(university);
	 
	        allStudents.add(student1);
	        allStudents.add(student2);
	        allStudents.add(student3);
	 
	        university.setStudents(allStudents);
	 
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	 
	        session.persist(university);// Students will be presisted automatically, thanks to CASCADE.ALL defined on students
	                                    // property of University class.
	        
	        List<Student> students = (List<Student>)session.createQuery("from Student ").list();
	        for(Student s: students){
	            System.out.println("Details : "+s);
	            System.out.println("Student University Details: "+s.getUniversity());
	        }
	         
	        session.getTransaction().commit();
	        session.close();  
	}

}
