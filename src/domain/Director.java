package domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="directors")
public class Director extends Creator
{
	
	@Column(name="style")
	private String style;
	
	@OneToMany(mappedBy="director",
			cascade= {CascadeType.PERSIST})
	private List<Documentary> documentaries;
	
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

	public List<Documentary> getDocumentaries()
	{
		return documentaries;
	}

	public void setDocumentaries(List<Documentary> documentaries)
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
