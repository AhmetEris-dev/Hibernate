package com.ahmete._04_HibernatePC.service;

import com.ahmete._04_HibernatePC.entity.Pc;
import com.ahmete._04_HibernatePC.entity.User;
import com.ahmete._04_HibernatePC.repository.UserRepository;
import com.ahmete._04_HibernatePC.entity.Component;
import java.util.List;

public class UserService extends ServiceManager<User, Long> {
	private final UserRepository userRepository;
	private final PcService pcService;
	private final ComponentService componentService;
	
	public UserService() {
		this(new UserRepository());
		
	}
	
	private UserService(UserRepository userRepository) {
		super(userRepository);
		this.userRepository = userRepository;
		this.pcService=new PcService();
		this.componentService=new ComponentService();
	}
	
	public List<Pc> findUsersPcByUserId(Long id){
		findById(id).ifPresent(user -> System.out.println(user.getName()));
		System.out.println("-------------------");
		List<Pc> userPCs = pcService.findByFieldNameAndValue("userid", id);
		
		if (userPCs.isEmpty()) {
			System.out.println("Bu kullanıcının bilgisayarı yok.");
		} else {
			userPCs.forEach(System.out::println);
		}
		return userPCs;
	}
	
	public void findUsersPcAndComponentByUserId(Long id) {
		if(!existById(id)){
			System.out.println("Böyle bir kullanıcı yok");
			return;
		}
		findById(id).ifPresent(user -> System.out.println(user.getName()));
		System.out.println("-------------------");
		List<Pc> userPCs = pcService.findByFieldNameAndValue("userid", id);
		
		if (userPCs.isEmpty()) {
			System.out.println("Bu kullanıcının bilgisayarı yok.");
		} else {
			userPCs.forEach(pc -> {
				System.out.println(pc.getMarka());
				System.out.println("---------------------------------------------");
				List<Component> componentList = componentService.findByFieldNameAndValue("pcid", pc.getId());
				componentList.forEach(component -> {
					System.out.println(component.getMarka()+" "+component.getComponentType().name());
				});
				
			});
		}
		
	}
	
	public void findAllUsersPcAndComponents() {
	
		List<User> userList = findAll();
		
		userList.forEach(user -> {
			System.out.println(user.getName());
			System.out.println("---------------------------------");
			List<Pc> userPCsList = pcService.findByFieldNameAndValue("userid", user.getId());
			if (userPCsList.isEmpty()) {
				System.out.println("Bu kullanıcının bilgisayarı yok");
			}else {
				userPCsList.forEach(pc -> {
					System.out.println(pc.getMarka());
					System.out.println("---------------------------------------------");
					List<Component> componentList = componentService.findByFieldNameAndValue("pcid", pc.getId());
					componentList.forEach(component -> {
						System.out.println(component.getMarka()+" "+component.getComponentType().name());
					});
					
				});
			}
		});
	}
	
}