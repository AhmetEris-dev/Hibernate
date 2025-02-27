package com.ahmete._03_HibernateOgrenci.repository;

import java.util.List;
import java.util.Optional;

public interface ICrud<T,ID> {
	T save(T t);
	Iterable<T> saveAll(Iterable<T> entities);
	
	Boolean deleteById(ID id);
	
	Optional<T> findById(ID id);
	
	Boolean exsitsById(ID id);
	
	List<T> findAll();
	
	List<T> findByFieldNameAndValue(String fieldName,Object value);
	
	List<T> findByFilledFields(T t);
}