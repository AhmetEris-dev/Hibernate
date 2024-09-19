package com.ahmete._05_HibernateRelations.OneToOne.UniDirectional._01_PersonelSide.repository;

import com.ahmete._05_HibernateRelations.OneToOne.UniDirectional._01_PersonelSide.entity.Personel;

public class PersonelRepository extends RepositoryManager<Personel,Long> {
	public PersonelRepository() {
		super(Personel.class);
	}
}