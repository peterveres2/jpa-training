package com.epam.jpatraining.map.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.epam.jpatraining.map.domain.CountyEntity;

@NoRepositoryBean
public interface ReadOnlyRepository<T, ID extends Serializable> extends Repository<T, ID> {

	CountyEntity findOne(Long id);
	boolean exists(Long id);
	Iterable<CountyEntity> findAll();
	Iterable<CountyEntity> findAll(Iterable<Long> ids);
	long count();
}
