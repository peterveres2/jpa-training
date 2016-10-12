package com.epam.jpatraining.map.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jpatraining.map.domain.CountyEntity;
import com.epam.jpatraining.map.domain.Statistics;
import com.epam.jpatraining.map.repository.CountyRepository;

@Component
public class CountryService {

	@Autowired
	CountyRepository countyRepository;

	public CountyEntity findById(long id) {
		return countyRepository.findOne(id);
	}

	
	@Transactional
	public CountyEntity findCountyByOrigIdOrName(String value) {
		return countyRepository.findByOrigIdOrName(value, value);
	}
	
	public Integer findLargestCounty() {
		return countyRepository.findLargestCountySize();
	}
		
	@Transactional
	public void save(CountyEntity countyEntity) {
		countyRepository.saveAndFlush(countyEntity);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	public Iterable<CountyEntity> findAll(Pageable pageable) {
		return countyRepository.findAll(pageable);
	}

	public Iterable<CountyEntity> findAll() {
		return countyRepository.findAll();
	}

	
	public Statistics getStatistics() {
		return countyRepository.getStatistics();
	}
	
	

}
