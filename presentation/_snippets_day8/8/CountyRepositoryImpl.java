package com.epam.jpatraining.map.repository;

import org.springframework.stereotype.Component;

public class CountyRepositoryImpl implements CountyRepositoryCustom {

	@Override
	public String sayHello() {		
		return "Hello";
	}

}
