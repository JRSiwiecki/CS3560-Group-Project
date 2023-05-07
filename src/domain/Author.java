package domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="authors")
public class Author extends Creator
{
	
	@Column(name="subject")
	private String subject;
	
	@OneToMany(mappedBy="author",
			cascade= {CascadeType.PERSIST})
	private List<Book> books;
	
	public Author(String name, String nationality, String subject)
	{
		super(name, nationality);
		this.subject = subject;
	}
	
	public Author()
	{
		super();
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	
	public List<Book> getBooks()
	{
		return books;
	}

	public void setBooks(List<Book> books)
	{
		this.books = books;
	}

	@Override
	public String toString()
	{
		return "Author [name=" + this.getName() + ", nationality=" + this.getNationality() +
				", subject=" + subject + ", books=" + books.toString() + "]";
	}
	
}
