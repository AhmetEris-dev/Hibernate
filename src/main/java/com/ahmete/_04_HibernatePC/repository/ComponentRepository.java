package com.ahmete._04_HibernatePC.repository;

import com.ahmete._04_HibernatePC.entity.Component;

public class ComponentRepository extends RepositoryManager<Component,Long> {
	public ComponentRepository() {
		super(Component.class);
	}
}