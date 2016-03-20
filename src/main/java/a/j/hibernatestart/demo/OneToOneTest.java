package a.j.hibernatestart.demo;

import java.util.List;

import org.hibernate.Session;

import a.j.hibernatestart.model.Address;
import a.j.hibernatestart.model.Student;
import a.j.hibernatestart.util.HibernateUtil;

public class OneToOneTest {
	public static void main(String[] args) {
//		Student student = new Student("Sam", "Disilva", "Maths");
//		Address address = new Address("10 Silver street", "NYC", "USA");
//
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//
//		session.persist(student);
//
//		address.setId(student.getId());
//		student.setAddress(address);
//		session.save(student);
//
//		List<Student> students = (List<Student>) session.createQuery("from Student ").list();
//		for (Student s : students) {
//			System.out.println("Details : " + s);
//		}
//		session.getTransaction().commit();
//		session.close();
		
		 Student student = new Student("Sam","Disilva","Maths");
	        Address address = new Address("10 Silver street","NYC","USA");
	         
	         
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	 
	        session.persist(address);
	        student.setAddress(address);
	        session.persist(student);
	 
	        List<Student> students = (List<Student>)session.createQuery("from Student ").list();
	        for(Student s: students){
	            System.out.println("Details : "+s);
	        }
	         
	        session.getTransaction().commit();
	        session.close();  
	}
}
