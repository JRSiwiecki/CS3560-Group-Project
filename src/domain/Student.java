package domain;

import java.util.ArrayList;

public class Student
{
	private int broncoId;
	private String name;
	private String course;
	private ArrayList<Loan> loans;
	
	public Student(int broncoId, String name, String course, ArrayList<Loan> loans)
	{
		this.broncoId = broncoId;
		this.name = name;
		this.course = course;
		this.loans = loans;
	}
	
	public Student(int broncoId, String name, String course)
	{
		this.broncoId = broncoId;
		this.name = name;
		this.course = course;
		loans = new ArrayList<Loan>();
	}
	
	public Student()
	{
		
	}
	
	public int getBroncoId()
	{
		return broncoId;
	}
	public void setBroncoId(int broncoId)
	{
		this.broncoId = broncoId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getCourse()
	{
		return course;
	}
	public void setCourse(String course)
	{
		this.course = course;
	}
	public ArrayList<Loan> getLoans()
	{
		return loans;
	}
	public void setLoans(ArrayList<Loan> loans)
	{
		this.loans = loans;
	}
	
	public void addLoan(Loan loan)
	{
		loans.add(loan);
	}
	
	public void removeLoan(Loan loan)
	{
		loans.remove(loan);
	}

	@Override
	public String toString()
	{
		return "Student [broncoId=" + broncoId + ", name=" + name + ", "
				+ "course=" + course + ", loans=" + loans.toString() + "]";
	}
	
	
}
