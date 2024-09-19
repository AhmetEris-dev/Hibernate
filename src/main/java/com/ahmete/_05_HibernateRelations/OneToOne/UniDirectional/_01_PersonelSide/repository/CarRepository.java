package com.ahmete._05_HibernateRelations.OneToOne.UniDirectional._01_PersonelSide.repository;

import com.ahmete._05_HibernateRelations.OneToOne.UniDirectional._01_PersonelSide.entity.Car;

public class CarRepository extends RepositoryManager<Car,Long>{
	public CarRepository() {
		super(Car.class);
	}
}