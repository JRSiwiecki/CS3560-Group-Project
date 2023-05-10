package api;

import domain.*;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoanDAO
{
	public static boolean createLoan(String itemName, String studentName, Date startDate, Date endDate, boolean itemIsBook)
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
		
			Student tempStudent = StudentDAO.readStudent(studentName);
			
			// need to use the Class name, not table name
			String hql = "FROM Loan WHERE name=:name";
						
			@SuppressWarnings("unchecked")
			List<Book> students = session.createQuery(hql)
								.setParameter("name", tempStudent.getName())
								.list();
			
			for (int i = 0; i < students.size(); i++)
			{
				
			}
			
			Documentary tempDocumentary;
			Book tempBook;
			
			tempLoan.setStartDate(startDate);
			tempLoan.setDueDate(endDate);
			tempLoan.setStudent(tempStudent);
			
			// If the loan item is a book, create the book
			if (itemIsBook)
			{
				tempBook = BookDAO.readBook(itemName);
				
				// if the book is already on loan, then we can't check it out!
				if (tempBook.getIsOnLoan())
				{
					return false;
				}
				
				tempBook.setIsOnLoan(true);
				
				BookDAO.updateBook(tempBook);
				
				tempLoan.setItem(tempBook);
				
			}
			
			// else create the documentary
			else
			{
				tempDocumentary = DocumentaryDAO.readDocumentary(itemName);
				
				// if the documentary is already on loan, then we can't check it out!
				if (tempDocumentary.getIsOnLoan())
				{
					return false;
				}
				
				tempDocumentary.setIsOnLoan(true);
				
				DocumentaryDAO.updateDocumentary(tempDocumentary);
				
				tempLoan.setItem(tempDocumentary);
			}		

			
			session.save(tempLoan);
			
			session.getTransaction().commit();
			
			return true;
		}
	
		finally
		{
			session.close();
			factory.close();
		}
	}
}
