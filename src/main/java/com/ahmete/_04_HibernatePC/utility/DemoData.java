package com.ahmete._04_HibernatePC.utility;

import com.ahmete._04_HibernatePC.entity.Component;
import com.ahmete._04_HibernatePC.entity.Pc;
import com.ahmete._04_HibernatePC.entity.User;
import com.ahmete._04_HibernatePC.enums.EComponentType;
import com.ahmete._04_HibernatePC.repository.ComponentRepository;
import com.ahmete._04_HibernatePC.repository.PcRepository;
import com.ahmete._04_HibernatePC.repository.UserRepository;

public class DemoData {
	UserRepository userRepository;
	PcRepository pcRepository;
	ComponentRepository componentRepository;
	
	public DemoData() {
		this.userRepository = new UserRepository();
		this.pcRepository = new PcRepository();
		this.componentRepository = new ComponentRepository();
	}
	
	public void createDemoData() {
		createUsers();
		createPcs();
		createComponents();
	}
	
	private void createComponents() {
		componentRepository.save(Component.builder().pcid(1L).componentType(EComponentType.GRAPHICCARD).marka("NVIDIA").build());
		componentRepository.save(Component.builder().pcid(1L).componentType(EComponentType.MAINBOARD).marka("MCI").build());
		componentRepository.save(Component.builder().pcid(1L).componentType(EComponentType.HARDDISK).marka("SandDisk").build());
		componentRepository.save(Component.builder().pcid(1L).componentType(EComponentType.RAM).marka("SandDisk").build());
		componentRepository.save(Component.builder().pcid(1L).componentType(EComponentType.CPU).marka("Intel").build());
		
		componentRepository.save(Component.builder().pcid(2L).componentType(EComponentType.GRAPHICCARD).marka("NVIDIA").build());
		componentRepository.save(Component.builder().pcid(2L).componentType(EComponentType.MAINBOARD).marka("MCI").build());
		componentRepository.save(Component.builder().pcid(2L).componentType(EComponentType.HARDDISK).marka("SandDisk").build());
		componentRepository.save(Component.builder().pcid(2L).componentType(EComponentType.RAM).marka("SandDisk").build());
		componentRepository.save(Component.builder().pcid(2L).componentType(EComponentType.CPU).marka("Intel").build());
		
		componentRepository.save(Component.builder().pcid(3L).componentType(EComponentType.GRAPHICCARD).marka("NVIDIA").build());
		componentRepository.save(Component.builder().pcid(3L).componentType(EComponentType.MAINBOARD).marka("MCI").build());
		componentRepository.save(Component.builder().pcid(3L).componentType(EComponentType.HARDDISK).marka("SandDisk").build());
		componentRepository.save(Component.builder().pcid(3L).componentType(EComponentType.RAM).marka("SandDisk").build());
		componentRepository.save(Component.builder().pcid(3L).componentType(EComponentType.CPU).marka("Intel").build());
		
		componentRepository.save(Component.builder().pcid(4L).componentType(EComponentType.GRAPHICCARD).marka("NVIDIA").build());
		componentRepository.save(Component.builder().pcid(4L).componentType(EComponentType.MAINBOARD).marka("MCI").build());
		componentRepository.save(Component.builder().pcid(4L).componentType(EComponentType.HARDDISK).marka("SandDisk").build());
		componentRepository.save(Component.builder().pcid(4L).componentType(EComponentType.RAM).marka("SandDisk").build());
		componentRepository.save(Component.builder().pcid(4L).componentType(EComponentType.CPU).marka("Intel").build());
		
	}
	
	private void createPcs() {
		pcRepository.save(Pc.builder().userid(1L).marka("Monster").build());
		pcRepository.save(Pc.builder().userid(1L).marka("Lenova").build());
		pcRepository.save(Pc.builder().userid(1L).marka("MSI").build());
		pcRepository.save(Pc.builder().userid(2L).marka("MSI").build());
		
		
	}
	
	private void createUsers() { //3 tane user 1 tanesinin 3 pcsi, 1 tanesinin 1 pc, 1 tanesinin pc'si yok
		userRepository.save(User.builder().name("Ahmet").surname("Eriş").username("ahmete").password("123456789")
		                        .build());
		userRepository.save(User.builder().name("Murat").surname("Saçak").username("murats").password("123456789")
		                        .build());
		userRepository.save(User.builder().name("Alex").surname("Walker").username("alexw").password("123456789")
		                        .build());
		
	}
}