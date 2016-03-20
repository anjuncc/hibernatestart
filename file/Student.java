package a.j.hibernatestart.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6566411862489064491L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "STUDENT_ID")
	private int id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "SECTION")
	private String section;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
	/*
	 * 共享主键
	@OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;
    */
 
	//独立主键
//	@OneToOne
//    @JoinColumn(name="HOME_ADDRESS_ID")
//    private Address address;
	
	 @OneToOne(mappedBy="student", cascade = CascadeType.ALL)
	    private Address address;
	
    public Student() {
 
    }
 
    public Student(String firstName, String lastName, String section) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.section = section;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", section=" + section + "]";
	}

	

}