package domain;

import javax.persistence.*;
import java.sql.Date;

public class Documentary extends Item
{
	
	// length is an integer representing time in minutes
	private int length;
	private Date releaseDate;
	private Creator director;
	
	public Documentary(int code, String title, String description, 
			String location, double dailyPrice, BorrowStatus status,
			int length, Date releaseDate, Creator director,
			Loan currentLoan)
	{
		super(code, title, description, location, dailyPrice, status, currentLoan);
		this.length = length;
		this.releaseDate = releaseDate;
		this.director = director;
	}
	
	public Documentary()
	{
		super();
	}
	
	public int getLength()
	{
		return length;
	}
	public void setLength(int length)
	{
		this.length = length;
	}
	public Date getReleaseDate()
	{
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate)
	{
		this.releaseDate = releaseDate;
	}
	public Creator getDirector()
	{
		return director;
	}
	public void setDirector(Creator director)
	{
		this.director = director;
	}

	@Override
	public String toString()
	{
		return "Documentary [length=" + length + ", "
				+ "releaseDate=" + releaseDate + ", director=" + director + "]";
	}
	
	
	
}
