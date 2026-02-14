package assessment;


import jakarta.persistence.*;

public class Main {
	public static void main( String[] args ) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskPU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Employee emp = new Employee("Sai", "svarshith@gmail.com");
        IDCard card = new IDCard("IDC101", "2026-02-14",emp);

        emp.setIdCard(card);
        em.persist(card);   

        em.getTransaction().commit();

        System.out.println("Employee Created Successfully");

        Employee fetchedEmp = em.find(Employee.class, 1L);
        System.out.println("Employee Details:");
        System.out.println("ID: " + fetchedEmp.getId());
        System.out.println("Name: " + fetchedEmp.getName());
        System.out.println("Email: " + fetchedEmp.getEmail());

        IDCard fetchedCard = fetchedEmp.getIdCard();
        System.out.println("\nID Card Details:");
        System.out.println("Card Number: " + fetchedCard.getCardNumber());
        System.out.println("Issue Date: " + fetchedCard.getIssueDate());

        em.close();
        emf.close();
	}
}
