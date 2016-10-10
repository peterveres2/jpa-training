package com.epam.jpatraining;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.oxm.XmlMappingException;

import com.epam.jpatraining.map.domain.CountyEntity;
import com.epam.jpatraining.map.service.MapService;

/**
 * Map creator application
 *
 */
public class App {

	public static void main(String[] args) throws XmlMappingException, IOException, SQLException {
		try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				"com.epam.jpatraining.config")) {

			MapService mapService = context.getBean(MapService.class);
			
			mapService.importData();
			
			
			CountyEntity bp = mapService.findById(1021);
			
			System.out.println("Number of path commands: " + bp.getPathCommands().size());
			
		}

	}
}
