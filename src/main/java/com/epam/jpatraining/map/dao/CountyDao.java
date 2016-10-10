package com.epam.jpatraining.map.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.epam.jpatraining.map.domain.CountyEntity;

@Component
public class CountyDao {

	@PersistenceContext
	EntityManager entityManager;
	
	public void save(CountyEntity county) {
		entityManager.persist(county);
	}
}
