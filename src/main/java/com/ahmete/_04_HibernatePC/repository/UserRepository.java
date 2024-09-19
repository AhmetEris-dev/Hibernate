package com.ahmete._04_HibernatePC.repository;

import com.ahmete._04_HibernatePC.entity.Pc;
import com.ahmete._04_HibernatePC.entity.User;

import java.util.List;

public class UserRepository extends RepositoryManager<User, Long> {
	public UserRepository() {
		super(User.class);
	}
	
	
}