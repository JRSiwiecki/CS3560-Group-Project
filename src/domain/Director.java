package domain;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="directors")
public class Director extends Creator
{
	@Column(name="creator_id")
	private int creator_id;
	
	@Column(name="style")
	private String style;
	
	@OneToMany(mappedBy="documentaries",
			cascade= {CascadeType.PERSIST})
	private ArrayList<Documentary> documentaries;
	
	public Director(String name, String nationality, String style)
	{
		super(name, nationality);
		this.creator_id = this.getId();
		this.style = style;
	}
	
	public Director()
	{
		super();
		this.creator_id = this.getId();
	}
	
	public int getCreator_id()
	{
		return creator_id;
	}

	public void setCreator_id(int creator_id)
	{
		this.creator_id = creator_id;
	}

	public String getStyle()
	{
		return style;
	}

	public void setStyle(String style)
	{
		this.style = style;
	}

	public ArrayList<Documentary> getDocumentaries()
	{
		return documentaries;
	}

	public void setDocumentaries(ArrayList<Documentary> documentaries)
	{
		this.documentaries = documentaries;
	}

	@Override
	public String toString()
	{
		return "Director [name=" + this.getName() + ", nationality=" + this.getNationality() +
				", style=" + style + ", documentaries=" + documentaries.toString() + "]";
	}
	
	
}
