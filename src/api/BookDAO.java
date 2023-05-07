package api;

import domain.*;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BookDAO 
{
	public static void createBook(String title, String description, 
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
			
			// Note that doing this will have the Item's ID 
			// be BookID - 1. I can't figure out a way around this.
			Item tempItem = new Item();
			Book tempBook = new Book();
			
			tempItem.setTitle(title);
			tempItem.setDescription(description);
			tempItem.setLocation(location);
			tempItem.setDailyPrice(dailyPrice);
			tempItem.setIsOnLoan(false);
			
			tempBook.setTitle(title);
			tempBook.setDescription(description);
			tempBook.setLocation(location);
			tempBook.setDailyPrice(dailyPrice);
			tempBook.setIsOnLoan(false);
			tempBook.setPages(pages);
			tempBook.setPublisher(publisher);
			tempBook.setPublicationDate(publicationDate);
			tempBook.setAuthor(author);
			
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
	
	public static Book readBook(String title)
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
			
			Book tempBook = new Book();
			
			tempBook.setTitle(title);
			
			// need to use the Class name, not table name
			String hql = "FROM Book WHERE title=:title";
			
			@SuppressWarnings("unchecked")
			List<Book> books = session.createQuery(hql)
					.setParameter("title", tempBook.getTitle())
					.list();
			
			tempBook = (books.isEmpty()) ? null : books.get(0);
			
			session.getTransaction().commit();
			
			return tempBook;
		}
		
		finally
		{
			session.close();
			factory.close();
		}
	}
	
	public static void deleteBook(Book book)
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
			
			// Remember that the ItemID is the BookID - 1.
			Item tempItem = session.get(Item.class, book.getCode() - 1);
					
			session.delete(session.get(Book.class, book.getCode()));
			session.delete(session.get(Item.class, tempItem.getCode()));
			
			session.getTransaction().commit();
		}
		
		finally
		{
			session.close();
			factory.close();
		}
	}
}

