package com.ahmete._04_HibernatePC;

import com.ahmete._04_HibernatePC.entity.Pc;
import com.ahmete._04_HibernatePC.entity.User;
import com.ahmete._04_HibernatePC.enums.EComponentType;
import com.ahmete._04_HibernatePC.repository.PcRepository;
import com.ahmete._04_HibernatePC.repository.UserRepository;
import com.ahmete._04_HibernatePC.service.ComponentService;
import com.ahmete._04_HibernatePC.service.PcService;
import com.ahmete._04_HibernatePC.service.UserService;
import com.ahmete._04_HibernatePC.utility.DemoData;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Optional;

public class Runner {
	public static void main(String[] args) {
//		DemoData demoData = new DemoData();
//		demoData.createDemoData();
		
		UserService userService = new UserService();
		PcService pcService = new PcService();
		ComponentService componentService = new ComponentService();
		UserRepository userRepository = new UserRepository();
//		userRepository.save(User.builder().name("Barış").build());
//		userRepository.save(User.builder().name("Emre").build());
//		userRepository.save(User.builder().name("Can").build());
//
//		userRepository.findAll().forEach(System.out::println);
	userRepository.save(User.builder().name("ahmet").surname("eriş").password("123456789").build());
//		userService.findUsersPcByUserId(3L);
		
//		userService.findUsersPcAndComponentByUserId(1L);
		
//		userService.findAllUsersPcAndComponents();
		
		componentService.getPcNameByComponent(EComponentType.CPU);
		
		
		
	}
}