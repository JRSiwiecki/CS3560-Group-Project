package domain;

public class Receipt
{
	private Loan loan;
	
	public Receipt(Loan loan)
	{
		this.loan = loan;
	}
	
	public Receipt()
	{
		
	}

	public Loan getLoan()
	{
		return loan;
	}

	public void setLoan(Loan loan)
	{
		this.loan = loan;
	}
	
	
}
