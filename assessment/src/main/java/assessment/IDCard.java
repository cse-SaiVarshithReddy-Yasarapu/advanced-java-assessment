package assessment;


import jakarta.persistence.*;

@Entity
public class IDCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cardNumber;
	private String issueDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id") 
	private Employee employee;
	
	public IDCard() {
		
	}

	public IDCard(String cardNumber, String issueDate,Employee employee) {
		this.cardNumber = cardNumber;
		this.issueDate = issueDate;
		this.employee = employee;
	}

	public Long getId() {
		return id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "IDCard [id=" + id + ", cardNumber=" + cardNumber + ", issueDate=" + issueDate + "]";
	}
	
}