package a.j.hibernatestart.demo;

import java.util.List;

import org.hibernate.Session;

import a.j.hibernatestart.model.Student;
import a.j.hibernatestart.util.HibernateUtil;

public class HibernateStandAloneDemo {
	public static void main(String[] args) {
		HibernateStandAloneDemo application = new HibernateStandAloneDemo();

		/*
		 * Save few objects with hibernate
		 */
		int studentId1 = application.saveStudent("Sam", "Disilva", "Maths");
		int studentId2 = application.saveStudent("Joshua", "Brill", "Science");
		int studentId3 = application.saveStudent("Peter", "Pan", "Physics");
		int studentId4 = application.saveStudent("Bill", "Laurent", "Maths");

		/*
		 * Retrieve all saved objects
		 */
		List<Student> students = application.getAllStudents();
		System.out.println("List of all persisted students >>>");
		for (Student student : students) {
			System.out.println("Persisted Student :" + student);
		}

		/*
		 * Update an object
		 */
		application.updateStudent(studentId4, "ARTS");

		/*
		 * Deletes an object
		 */
		application.deleteStudent(studentId2);

		/*
		 * Retrieve all saved objects
		 */
		List<Student> remaingStudents = application.getAllStudents();
		System.out.println("List of all remained persisted students >>>");
		for (Student student : remaingStudents) {
			System.out.println("Persisted Student :" + student);
		}

	}

	private List<Student> getAllStudents() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Student> employees = (List<Student>) session.createQuery(
				"FROM Student s ORDER BY s.firstName ASC").list();

		session.getTransaction().commit();
		session.close();
		return employees;
	}

	private int saveStudent(String firstName, String lastName, String section) {
		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setSection(section);

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		int id = (Integer) session.save(student);
		session.getTransaction().commit();
		session.close();
		return id;
	}

	private void updateStudent(int id , String section) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Student student = (Student) session.get(Student.class, id);
		student.setSection(section);
		//session.update(student);//No need to update manually as it will be updated automatically on transaction close.
		session.getTransaction().commit();
		session.close();
	}

	private void deleteStudent(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Student student = (Student) session.get(Student.class, id);
		session.delete(student);
		session.getTransaction().commit();
		session.close();
	}
}