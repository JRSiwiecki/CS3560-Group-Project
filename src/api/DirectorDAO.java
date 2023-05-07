package api;

import domain.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DirectorDAO 
{
	public static void createDirector(String name, String nationality, String style) 
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
			
			// Note that doing this will have the Creator's ID 
			// be DirectorID - 1. I can't figure out a way around this.
			Creator tempCreator = new Creator(name, nationality);
			Director tempDirector = new Director(name, nationality, style);
			
			session.save(tempCreator);
			session.save(tempDirector);
			
			session.getTransaction().commit();
		}
		
		finally
		{
			session.close();
			factory.close();
		}
	}
	
	public static Director readDirector(String name)
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
			
			Director tempDirector = new Director();
			
			tempDirector.setName(name);
			
			// need to use the Class name, not table name
			// ie uppercase Author like the class
			// not lowercase authors like the table in pgAdmin
			String hql = "FROM Director WHERE name=:name";
			
			
			@SuppressWarnings("unchecked")
			List<Director> directors = session.createQuery(hql)
					.setParameter("name", tempDirector.getName())
					.list();
			
			tempDirector = (directors.isEmpty()) ? null : directors.get(0);
			
			session.getTransaction().commit();
			
			return tempDirector;
		}
		
		finally
		{
			session.close();
			factory.close();
		}
	}
}

