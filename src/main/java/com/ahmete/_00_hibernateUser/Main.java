package com.ahmete._00_hibernateUser;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_hibernate");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//public User(Long id, String name, String surname, String email, String username, String password)
		
		//User user1=new User(1L,"Barış","Demirci","bdemirci@gmail.com","bdemirci","123");
		//User user2=new User(2L,"Alper","Güler","alper@gmail.com","aguler","123");
		User user3=new User("Alper", "Güler", "alper@gmail.com", "aguler", "123");
		
		entityManager.getTransaction().begin();
		
		
		entityManager.persist(user3);
		//user3.setEmail("DENEME");
		
		
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}
}