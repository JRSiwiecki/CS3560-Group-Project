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
			
			if (tempStudent == null)
			{
				return false;
			}
		
			Documentary tempDocumentary;
			Book tempBook;
			
			tempLoan.setStartDate(startDate);
			tempLoan.setDueDate(endDate);
			
			// If the loan item is a book, create the book
			if (itemIsBook)
			{
				tempBook = BookDAO.readBook(itemName);
				
				// if the book doesn't exist, there is nothing to loan!
				if (tempBook == null)
				{
					return false;
				}
				
				// if the book is already on loan, then we can't check it out!
				if (tempBook.getIsOnLoan())
				{
					return false;
				}
				
				// if the student already has an open loan, they can't check out the item!
				if (tempStudent.getHasCurrentLoan())
				{
					return false;
				}
				
				tempStudent.setHasCurrentLoan(true);
				
				tempBook.setIsOnLoan(true);
				tempLoan.setStudent(tempStudent);
				
				BookDAO.updateBook(tempBook);
				StudentDAO.updateStudent(tempStudent);
				
				tempLoan.setItem(tempBook);
				
			}
			
			// else create the documentary
			else
			{
				tempDocumentary = DocumentaryDAO.readDocumentary(itemName);
				
				// if the book doesn't exist, there is nothing to loan!
				if (tempDocumentary == null)
				{
					return false;
				}
				
				// if the documentary is already on loan, then we can't check it out!
				if (tempDocumentary.getIsOnLoan())
				{
					return false;
				}
				
				// if the student already has an open loan, they can't check out the item!
				if (tempStudent.getHasCurrentLoan())
				{
					return false;
				}
				
				tempStudent.setHasCurrentLoan(true);
				
				tempDocumentary.setIsOnLoan(true);
				tempLoan.setStudent(tempStudent);
				
				DocumentaryDAO.updateDocumentary(tempDocumentary);
				StudentDAO.updateStudent(tempStudent);
				
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
