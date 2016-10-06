package com.epam.jpatraining;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.oxm.XmlMappingException;

import com.epam.jpatraining.xmlprocessor.service.XMLProcessorService;

/**
 * Map creator application
 *
 */
public class App {

	public static void main(String[] args) throws XmlMappingException, IOException {
		try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				"com.epam.jpatraining.config")) {

			XMLProcessorService xmlProcessorService = context.getBean(XMLProcessorService.class);
			xmlProcessorService.importData(
					new StreamSource(App.class.getResourceAsStream("/input/svg-input-hungary.xml")),
					new StreamResult(new FileOutputStream("src/main/resources/input/xml-input-hungary.xml")));

		}

	}
}
