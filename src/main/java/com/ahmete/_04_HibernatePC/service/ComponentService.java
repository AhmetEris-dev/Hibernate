package com.ahmete._04_HibernatePC.service;

import com.ahmete._04_HibernatePC.entity.Component;
import com.ahmete._04_HibernatePC.entity.Pc;
import com.ahmete._04_HibernatePC.enums.EComponentType;
import com.ahmete._04_HibernatePC.repository.ComponentRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public class ComponentService extends ServiceManager<Component,Long> {
	
	private final ComponentRepository componentRepository;
	private final PcService pcService;
	
	public ComponentService() {
		this(new ComponentRepository());
	}
	
	private ComponentService(ComponentRepository componentRepository) {
		super(componentRepository);
		this.componentRepository = componentRepository;
		this.pcService = new PcService();
	}
	
	public void getPcNameByComponent(EComponentType componentType) {
		List<Component> componentList =componentRepository.findByFieldNameAndValue("componentType", componentType);
		
		Set<String> pcNameSet = new HashSet<>();
		
		componentList.forEach(component -> {
			Optional<Pc> pc =pcService.findById(component.getPcid());
			pc.ifPresent(p -> {
				pcNameSet.add(p.getMarka());
			});
		});
	    pcNameSet.forEach(System.out::println);
	}
	
	
	
}