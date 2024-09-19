package com.ahmete._02_hibernateNative;

import com.ahmete._02_hibernateNative.entity.Musteri;
import com.ahmete._02_hibernateNative.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Runner {
	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		
		Musteri m1=new Musteri("Arda", "Güler", "Madrid");
		
		Transaction transaction = session.beginTransaction();
		session.persist(m1);
		
		transaction.commit();
		session.close();
	}
}