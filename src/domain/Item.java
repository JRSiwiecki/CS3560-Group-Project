package domain;

public class Item
{
	private int code;
	private String title;
	private String description;
	private String location;
	private double dailyPrice;
	private BorrowStatus status;
	private Loan currentLoan;
	
	enum BorrowStatus {
		BORROWED,
		AVAILABLE
	}

	public Item (int code, String title, String description, 
			String location, double dailyPrice, BorrowStatus status,
			Loan currentLoan)
	{
		this.code = code;
		this.title = title;
		this.description = description;
		this.location = location;
		this.dailyPrice = dailyPrice;
		this.status = status;
		this.currentLoan = currentLoan;
	}
	
	public Item()
	{
		
	}
	
	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public double getDailyPrice()
	{
		return dailyPrice;
	}

	public void setDailyPrice(double dailyPrice)
	{
		this.dailyPrice = dailyPrice;
	}

	public BorrowStatus getStatus()
	{
		return status;
	}

	public void setStatus(BorrowStatus status)
	{
		this.status = status;
	}

	public Loan getCurrentLoan()
	{
		return currentLoan;
	}

	public void setCurrentLoan(Loan currentLoan)
	{
		this.currentLoan = currentLoan;
	}
	
}
