package com.epam.jpatraining.map;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.annotation.Commit;

import com.epam.jpatraining.AbstractIntegrationTest;
import com.epam.jpatraining.map.domain.CountyEntity;
import com.epam.jpatraining.map.domain.Statistics;
import com.epam.jpatraining.map.service.CountryService;
import com.google.common.collect.Iterables;

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
		countryService.save(county);
		// Then
		Assert.assertEquals("Cannot create entity.", entityManager.find(CountyEntity.class, county.getId()), county);		
	}
	
	@Test
	public void testLoadCounty() {
		// Given
				
		
		// When 
		Iterable<CountyEntity> allCounties = countryService.findAll();
		
		// Then
		Assert.assertEquals("Cannot load all counties", Iterables.size(allCounties), 20);	
	}
	
	
	@Test
	public void testLoadStatistics() {
		// Given
				
		
		// When 
		Statistics statistics = countryService.getStatistics();
		
		// Then
		System.out.println(statistics);
	}
	
	@Test
	public void testFindAllWithPageAble() {
		PageRequest request =
	            new PageRequest(2, 5, Sort.Direction.ASC, "name"); 
		Iterable<CountyEntity> result = countryService.findAll(request);
		
		result.forEach(county -> System.out.println(county));
	}
	
	
}
