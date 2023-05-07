package api;

import domain.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AuthorDAO 
{
	public static void createAuthor(String name, String nationality, String subject) 
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
			// be AuthorID - 1. I can't figure out a way around this.
			Creator tempCreator = new Creator(name, nationality);
			Author tempAuthor = new Author(name, nationality, subject);
			
			session.save(tempCreator);
			session.save(tempAuthor);
			
			session.getTransaction().commit();
		}
		
		finally
		{
			session.close();
			factory.close();
		}
	}
	
	public static Author readAuthor(String name)
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
			
			Author tempAuthor = new Author();
			
			tempAuthor.setName(name);
			
			// need to use the Class name, not table name
			// ie uppercase Author like the class
			// not lowercase authors like the table in pgAdmin
			String hql = "FROM Author WHERE name=:name";
			
			
			@SuppressWarnings("unchecked")
			List<Author> authors = session.createQuery(hql)
					.setParameter("name", tempAuthor.getName())
					.list();
			
			tempAuthor = (authors.isEmpty()) ? null : authors.get(0);
			
			session.getTransaction().commit();
			
			return tempAuthor;
		}
		
		finally
		{
			session.close();
			factory.close();
		}
	}
	
	public static void updateAuthor(Author author)
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
			
			// Retrieve the author from the database using their name
			String hql = "FROM Author WHERE name=:name";
			Author tempAuthor = (Author) session.createQuery(hql)
			                                    .setParameter("name", author.getName())
			                                    .uniqueResult();
			
			tempAuthor = session.get(Author.class, tempAuthor.getId());
					
			// Update the author object with the correct ID
			author.setId(tempAuthor.getId());
			
			hql = "UPDATE Author SET name=:name, phone=:phone, email=:email WHERE id=:id";
			
			session.createQuery(hql)
				.setParameter("name", author.getName())
				.setParameter("phone", author.getNationality())
				.setParameter("email", author.getSubject())
				.setParameter("id", author.getId())
				.executeUpdate();
			
			session.getTransaction().commit();
		}
		
		finally
		{
			session.close();
			factory.close();
		}
	}
	
	public void deleteAuthor(Author author)
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
			
			// Retrieve the customer from the database using their name
			String hql = "FROM Author WHERE name=:name";
			Author tempAuthor = (Author) session.createQuery(hql)
			                                    .setParameter("name", author.getName())
			                                    .uniqueResult();

			// Update the customer object with the correct ID
			author.setId(tempAuthor.getId());
			
			session.delete(session.get(Author.class, author.getId()));
			
			session.getTransaction().commit();
		}
		
		finally
		{
			session.close();
			factory.close();
		}
	}
}

