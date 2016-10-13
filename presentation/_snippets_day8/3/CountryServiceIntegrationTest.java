package com.epam.jpatraining.map;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;

import com.epam.jpatraining.AbstractIntegrationTest;
import com.epam.jpatraining.map.domain.CountyEntity;
import com.epam.jpatraining.map.service.CountryService;

@Commit
public class CountryServiceIntegrationTest extends AbstractIntegrationTest {

	@Autowired
	private CountryService countryService;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Test
	public void testCreateCounty() {
		// Given
		CountyEntity county = new CountyEntity();
		county.setName("TestCounty");
		county.setColor("test color");
		county.setOrigId("Test orig ID");
		county.setPopulation(100);
		county.setSize(100);
		
		// When
		countryService.create(county);
		// Then
		Assert.assertEquals("Cannot create entity.", entityManager.find(CountyEntity.class, county.getId()), county);		
	}
	
	
	
}
