package com.ahmete._03_HibernateOgrenci.repository;

import java.util.List;
import java.util.Optional;

public class RepositoryManager<T,ID> implements ICrud<T,ID>{
	@Override
	public T save(T t) {
		return null;
	}
	
	@Override
	public Iterable<T> saveAll(Iterable<T> entities) {
		return null;
	}
	
	@Override
	public Boolean deleteById(ID id) {
		return null;
	}
	
	@Override
	public Optional<T> findById(ID id) {
		return Optional.empty();
	}
	
	@Override
	public Boolean exsitsById(ID id) {
		return null;
	}
	
	@Override
	public List<T> findAll() {
		return List.of();
	}
	
	@Override
	public List<T> findByFieldNameAndValue(String fieldName, Object value) {
		return List.of();
	}
	
	@Override
	public List<T> findByFilledFields(T t) {
		return List.of();
	}
}