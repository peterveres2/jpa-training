package com.epam.jpatraining;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.oxm.XmlMappingException;

import com.epam.jpatraining.map.service.MapImportService;

/**
 * Map creator application
 *
 */
public class App {

	public static void main(String[] args) throws XmlMappingException, IOException, SQLException {
		try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				"com.epam.jpatraining.config")) {

			
			MapImportService mapImportService = context.getBean(MapImportService.class);
			
			mapImportService.importData();
			 
		}

	}
}
