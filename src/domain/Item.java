package domain;

import javax.persistence.*;

@Entity
@Table(name="items")
public class Item
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "items_seq")
    @SequenceGenerator(name = "items_seq", sequenceName = "items_code_seq", allocationSize = 1)
    @Column(name = "code")
	private int code;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="location")
	private String location;
	
	@Column(name="daily_price")
	private double dailyPrice;
	
	@Column(name="is_on_loan")
	private boolean isOnLoan;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="loan_id")
	private Loan currentLoan;

	public Item (int code, String title, String description, 
			String location, double dailyPrice, boolean isOnLoan,
			Loan currentLoan)
	{
		this.code = code;
		this.title = title;
		this.description = description;
		this.location = location;
		this.dailyPrice = dailyPrice;
		this.isOnLoan = isOnLoan;
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

	public boolean getIsOnLoan()
	{
		return isOnLoan;
	}

	public void setIsOnLoan(boolean isOnLoan)
	{
		this.isOnLoan = isOnLoan;
	}

	public Loan getCurrentLoan()
	{
		return currentLoan;
	}

	public void setCurrentLoan(Loan currentLoan)
	{
		this.currentLoan = currentLoan;
	}

	@Override
	public String toString()
	{
		return "Item [code=" + code + ", title=" + title + ", "
				+ "description=" + description + ", location=" + location
				+ ", dailyPrice=" + dailyPrice + ", isOnLoan=" + isOnLoan + 
				", currentLoan=" + currentLoan + "]";
	}
	
	
	
}
