package domain;

public class Director extends Creator
{
	private String style;
	
	public Director(String name, String nationality, String style)
	{
		super(name, nationality);
		this.style = style;
	}
	
	public Director()
	{
		super();
	}

	public String getStyle()
	{
		return style;
	}

	public void setStyle(String style)
	{
		this.style = style;
	}

	@Override
	public String toString()
	{
		return "Director [name=" + this.getName() + ", nationality=" + this.getNationality() +
				", style=" + style + "]";
	}
	
	
}
