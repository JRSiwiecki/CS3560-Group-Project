package domain;

import javax.persistence.*;
import java.sql.Date;

public class Book extends Item
{
	private int pages;
	private String publisher;
	private Date publicationDate;
	private Creator author;
	
	public Book(int code, String title, String description, 
			String location, double dailyPrice, BorrowStatus status,
			int pages, String publisher, Date publicationDate, Creator author,
			Loan currentLoan)
	{
		super(code, title, description, location, dailyPrice, status, currentLoan);
		this.pages = pages;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
		this.author = author;
	}
	
	public Book()
	{
		super();
	}
	
	public int getPages()
	{
		return pages;
	}
	public void setPages(int pages)
	{
		this.pages = pages;
	}
	public String getPublisher()
	{
		return publisher;
	}
	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}
	public Date getPublicationDate()
	{
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate)
	{
		this.publicationDate = publicationDate;
	}
	public Creator getAuthor()
	{
		return author;
	}
	public void setAuthor(Creator author)
	{
		this.author = author;
	}

	@Override
	public String toString()
	{
		return "Book [pages=" + pages + ", publisher=" + publisher + ", "
				+ "publicationDate=" + publicationDate
				+ ", author=" + author + "]";
	}
	
	
}
