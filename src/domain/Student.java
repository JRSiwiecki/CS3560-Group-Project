package domain;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Student
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "students_seq")
    @SequenceGenerator(name = "students_seq", sequenceName = "students_broncoId_seq", allocationSize = 1)
    @Column(name = "bronco_id")
	private int broncoId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="course")
	private String course;
	
	public Student(int broncoId, String name, String course)
	{
		this.broncoId = broncoId;
		this.name = name;
		this.course = course;
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

	@Override
	public String toString()
	{
		return "Student [broncoId=" + broncoId + ", name=" + name + ", "
				+ "course=" + course + "]";
	}
	
	
}
