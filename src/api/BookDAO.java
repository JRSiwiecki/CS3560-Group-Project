package api;

import domain.*;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BookDAO 
{
	public static void createBook(int code, String title, String description, 
			String location, double dailyPrice,
			int pages, String publisher, Date publicationDate, Author author) 
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
			
			Item tempItem = new Item();
			Book tempBook = new Book();
			
			session.save(tempItem);
			session.save(tempBook);
			
			session.getTransaction().commit();
		}
		
		finally
		{
			session.close();
			factory.close();
		}
	}
}

