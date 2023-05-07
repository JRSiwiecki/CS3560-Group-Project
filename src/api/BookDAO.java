package api;

import domain.*;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BookDAO 
{
	public static void createBook(int code, String title, String description, 
			String location, double dailyPrice, boolean isOnLoan,
			int pages, String publisher, Date publicationDate, Creator author,
			Loan currentLoan, Author author) 
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
			
			Loan tempLoan = new Loan();
			
			// Note that doing this will have the Item ID 
			// be bookID - 1. I can't figure out a way around this.
			Item tempItem = new Item(code, title, description, location, dailyPrice, isOnLoan, tempLoan);
			Book tempBook = new Book(code, title, description, location, dailyPrice, 
					isOnLoan, pages, publisher, publicationDate, author, tempLoan);
			
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

