package domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="books")
public class Book extends Item
{
	@Column(name="item_code")
	private int itemCode;
	
	@Column(name="pages")
	private int pages;
	
	@Column(name="publisher")
	private String publisher;
	
	@Column(name="publication_date")
	private Date publicationDate;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="author_id")
	private Creator author;
	
	public Book(int code, String title, String description, 
			String location, double dailyPrice, boolean isOnLoan,
			int pages, String publisher, Date publicationDate, Creator author,
			Loan currentLoan)
	{
		super(code, title, description, location, dailyPrice, isOnLoan, currentLoan);
		itemCode = this.getCode();
		this.pages = pages;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
		this.author = author;
	}
	
	public Book()
	{
		super();
		itemCode = this.getCode();
	}
	
	public int getItemCode()
	{
		return itemCode;
	}

	public void setItemCode(int itemCode)
	{
		this.itemCode = itemCode;
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
		return "Book [code=" + this.getCode() + ", title=" + this.getTitle() 
				+ 	", description=" + this.getDescription() + ", location=" + this.getLocation()
				+ 	", dailyPrice=" + this.getDailyPrice() + ", isOnLoan=" + this.getIsOnLoan() 
				+  ", currentLoan=" + this.getCurrentLoan().toString() + ", pages=" + pages 
				+ ", publisher=" + publisher 
				+ ", publicationDate=" + publicationDate
				+ ", author=" + author.toString() + "]";
	}
	
	
}
