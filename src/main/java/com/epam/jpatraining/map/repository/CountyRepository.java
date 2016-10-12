package com.epam.jpatraining.map.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.epam.jpatraining.map.domain.CountyEntity;
import com.epam.jpatraining.map.domain.Statistics;

public interface CountyRepository extends PagingAndSortingRepository<CountyEntity, Long>{

	CountyEntity findByName(String name);

	CountyEntity findByOrigId(String origId);

	@Query("select max(c.size) from county c")
	Integer findLargestCountySize();

	@Query("select "
		+ "new com.epam.jpatraining.map.domain.Statistics(max(c.size), min(c.size), avg(c.size), max(c.population), min(c.population), avg(c.population)) "
		+ "from county c")
	Statistics getStatistics();


}