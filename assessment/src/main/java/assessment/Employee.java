package assessment;


import jakarta.persistence.*;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	
	@OneToOne(mappedBy= "employee")
	private IDCard IdCard;
	
	public Employee() {
		
	}
	
	public Employee(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public IDCard getIdCard() {
		return IdCard;
	}

	public void setIdCard(IDCard idCard) {
		IdCard = idCard;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", IdCard=" + IdCard + "]";
	}
}