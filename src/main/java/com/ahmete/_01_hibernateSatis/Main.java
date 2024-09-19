package com.ahmete._01_hibernateSatis;

import com.ahmete._01_hibernateSatis.entity.BaseEntity;
import com.ahmete._01_hibernateSatis.entity.Musteri;
import com.ahmete._01_hibernateSatis.enums.ECinsiyet;
import com.ahmete._01_hibernateSatis.enums.EYetki;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_hibernate");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		BaseEntity baseEntity=new BaseEntity(1, System.currentTimeMillis(), System.currentTimeMillis());
		
		
		Musteri mehmetBerkay = new Musteri("Mehmet Berkay");
		mehmetBerkay.setCinsiyet(ECinsiyet.BELIRTMEK_ISTEMIYORUM);
		mehmetBerkay.setYetki(EYetki.ADMIN);
		mehmetBerkay.setBaseEntity(baseEntity);
		
		Musteri emirhanErgun = new Musteri("Ergun");
		emirhanErgun.setHobiler(List.of("Satranç", "Bilgisayar", "Müzik"));
		
		Musteri yasin = new Musteri("Yasin");
		yasin.setCinsiyet(ECinsiyet.ERKEK);
		yasin.setYetki(EYetki.USER);
		yasin.setHobiler(List.of("F1","NBA"));

//		Satis su = new Satis(1L, "su");
//		Satis dondurma = new Satis(2L, "dondurma");
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(mehmetBerkay);
		entityManager.persist(emirhanErgun);
		entityManager.persist(yasin);
//		entityManager.persist(su);
//		entityManager.persist(dondurma);
		
		entityManager.getTransaction().commit();
		
		
		entityManager.close();
		entityManagerFactory.close();
		
		
	}
}