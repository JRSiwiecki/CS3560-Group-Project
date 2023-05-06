package domain;

import java.sql.Date;

public class Loan
{
	private int number;
	private Date startDate;
	private Date dueDate;
	private Item item;
	
	public Loan(int number, Date startDate, Date dueDate, Item item)
	{
		this.number = number;
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.item = item;
	}
	
	public Loan()
	{
		
	}
	
	public int getNumber()
	{
		return number;
	}
	public void setNumber(int number)
	{
		this.number = number;
	}
	public Date getStartDate()
	{
		return startDate;
	}
	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}
	public Date getDueDate()
	{
		return dueDate;
	}
	public void setDueDate(Date dueDate)
	{
		this.dueDate = dueDate;
	}
	public Item getItem()
	{
		return item;
	}
	public void setItem(Item item)
	{
		this.item = item;
	}

	@Override
	public String toString()
	{
		return "Loan [number=" + number + ", startDate=" + startDate + ", "
				+ "dueDate=" + dueDate + ", item=" + item + "]";
	}
	
	
}
