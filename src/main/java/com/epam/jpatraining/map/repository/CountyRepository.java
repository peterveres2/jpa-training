package com.epam.jpatraining.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.epam.jpatraining.map.domain.CountyEntity;
import com.epam.jpatraining.map.domain.Statistics;

public interface CountyRepository extends JpaRepository<CountyEntity, Long>{

//	CountyEntity findByName(String name);
//
//	CountyEntity findByOrigId(String origId);
	
	CountyEntity findByOrigIdOrName(String origId, String name);

	@Query("select max(c.size) from county c")
	Integer findLargestCountySize();

	@Query("select "
		+ "new com.epam.jpatraining.map.domain.Statistics(max(c.size), min(c.size), avg(c.size), max(c.population), min(c.population), avg(c.population)) "
		+ "from county c")
	Statistics getStatistics();


}