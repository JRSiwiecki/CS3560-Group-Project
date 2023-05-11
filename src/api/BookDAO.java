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
	
	public static Book readBookByID(int bookId)
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
			
			Book tempBook = session.get(Book.class, bookId);
			
			return tempBook;
		}
		
		finally
		{
			session.close();
			factory.close();
		}
	}
	
	public static void updateBook(Book book)
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
			
			// bookCode should be itemCode + 1
			int itemCode = book.getCode();
			int bookCode = itemCode + 1;
			
			Item tempItem = session.get(Item.class, itemCode);
			
			tempItem.setTitle(book.getTitle());
			tempItem.setDescription(book.getDescription());
			tempItem.setLocation(book.getLocation());
			tempItem.setDailyPrice(book.getDailyPrice());
			tempItem.setIsOnLoan(book.getIsOnLoan());
			
			Book tempBook = session.get(Book.class, itemCode);
			
			tempBook.setTitle(book.getTitle());
			tempBook.setDescription(book.getDescription());
			tempBook.setLocation(book.getLocation());
			tempBook.setDailyPrice(book.getDailyPrice());
			tempBook.setIsOnLoan(book.getIsOnLoan());
			tempBook.setPages(book.getPages());
			tempBook.setPublisher(book.getPublisher());
			tempBook.setPublicationDate(book.getPublicationDate());
			tempBook.setAuthor(book.getAuthor());
				
			// Update book entry first
//			hql = "UPDATE Book SET title=:title, description=:description, location=:location, daily_price=:dailyPrice, is_on_loan=:isOnLoan, pages=:pages, publisher=:publisher, publication_date=:publicationDate, author_id=:authorId WHERE code=:code";
//			
//			session.createQuery(hql)
//				.setParameter("title", book.getTitle())
//				.setParameter("description", book.getDescription())
//				.setParameter("location", book.getLocation())
//				.setParameter("dailyPrice", book.getDailyPrice())
//				.setParameter("isOnLoan", book.getIsOnLoan())
//				.setParameter("pages", book.getPages())
//				.setParameter("publisher", book.getPublisher())
//				.setParameter("publicationDate", book.getPublicationDate())
//				.setParameter("authorId", book.getAuthor().getId())
//				.setParameter("code", bookCode)
//				.executeUpdate();
			
			// Update item entry second
			// For the time being, this is fine but it should update both items.
			// Currently, if you try to update daily_price or is_on_loan or both, it doesn't work.
			// hql = "UPDATE Item SET title=:title, description=:description, location=:location, daily_price=:dailyPrice, is_on_loan=:isOnLoan WHERE code=:code";
//			hql = "UPDATE Item SET title=:title, description=:description, location=:location WHERE code=:code";
//			
//			session.createQuery(hql)
//				.setParameter("title", tempItem.getTitle())
//				.setParameter("description", tempItem.getDescription())
//				.setParameter("location", tempItem.getLocation())
////				.setParameter("dailyPrice", tempItem.getDailyPrice())
////				.setParameter("isOnLoan", tempItem.getIsOnLoan())
//				.setParameter("code", itemCode)
//				.executeUpdate();
//			
//			// this does NOT work but it doesn't crash so
//			hql = "UPDATE Item SET dailyPrice=:daily_price, isOnLoan=:is_on_loan WHERE code=:code";
//			
//			session.createQuery(hql)
//				.setParameter("daily_price", tempItem.getDailyPrice())
//				.setParameter("is_on_loan", tempItem.getIsOnLoan())
//				.setParameter("code", itemCode)
//			.executeUpdate();
			
			
			session.getTransaction().commit();
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

