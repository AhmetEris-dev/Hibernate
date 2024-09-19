package com.ahmete._04_HibernatePC.repository;

import com.ahmete._04_HibernatePC.entity.Pc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class PcRepository extends RepositoryManager<Pc,Long>{
	private final EntityManagerFactory emf;
	
	public PcRepository() {
		super(Pc.class);
		this.emf = Persistence.createEntityManagerFactory("pu_hibernate");
	}
	
	
}