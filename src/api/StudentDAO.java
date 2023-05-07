package api;

import domain.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDAO 
{
	public static void createStudent(String broncoId, String name, String course) 
	{
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Author.class)
								.addAnnotatedClass(Book.class)
								.addAnnotatedClass(Creator.class)
								.addAnnotatedClass(Director.class)
								.addAnnotatedClass(Documentary.class)
								.addAnnotatedClass(Item.class)
								.addAnnotatedClass(Loan.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
			
			Student tempStudent = new Student(broncoId, name, course);
			
			session.save(tempStudent);
			
			session.getTransaction().commit();
		}
		
		finally
		{
			session.close();
			factory.close();
		}
	}
	
	public static Student readStudent(String name)
	{
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Author.class)
				.addAnnotatedClass(Book.class)
				.addAnnotatedClass(Creator.class)
				.addAnnotatedClass(Director.class)
				.addAnnotatedClass(Documentary.class)
				.addAnnotatedClass(Item.class)
				.addAnnotatedClass(Loan.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try
		{
			session.beginTransaction();
			
			Student tempStudent = new Student();
			
			tempStudent.setName(name);
			
			// need to use the Class name, not table name
			String hql = "FROM Student WHERE name=:name";
			
			
			@SuppressWarnings("unchecked")
			List<Student> students = session.createQuery(hql)
					.setParameter("name", tempStudent.getName())
					.list();
			
			tempStudent = (students.isEmpty()) ? null : students.get(0);
			
			session.getTransaction().commit();
			
			return tempStudent;
		}
		
		finally
		{
			session.close();
			factory.close();
		}
	}
	
	public static void updateStudent(Student student)
	{
		return;
	}
	
	public static void deleteStudent(Student student)
	{
		return;
	}
}

