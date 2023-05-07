package domain;

import javax.persistence.*;

public class Creator
{
	private String name;
	private String nationality;
	
	public Creator(String name, String nationality)
	{
		this.name = name;
		this.nationality = nationality;
	}
	
	public Creator()
	{
		
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getNationality()
	{
		return nationality;
	}

	public void setNationality(String nationality)
	{
		this.nationality = nationality;
	}
	
}
