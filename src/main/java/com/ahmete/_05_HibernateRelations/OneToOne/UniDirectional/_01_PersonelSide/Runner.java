package com.ahmete._05_HibernateRelations.OneToOne.UniDirectional._01_PersonelSide;

import com.ahmete._05_HibernateRelations.OneToOne.UniDirectional._01_PersonelSide.entity.Car;
import com.ahmete._05_HibernateRelations.OneToOne.UniDirectional._01_PersonelSide.entity.Personel;
import com.ahmete._05_HibernateRelations.OneToOne.UniDirectional._01_PersonelSide.repository.CarRepository;
import com.ahmete._05_HibernateRelations.OneToOne.UniDirectional._01_PersonelSide.repository.PersonelRepository;

public class Runner {
	public static void main(String[] args) {
		CarRepository carRepository=new CarRepository();
		PersonelRepository personelRepository=new PersonelRepository();
		
		Car car1= Car.builder().model("Mercedes").build();
		Personel personel1= Personel.builder().Name("Ahmet").car(car1).build();
		
		carRepository.save(car1);
		personelRepository.save(personel1);
		
	}
}