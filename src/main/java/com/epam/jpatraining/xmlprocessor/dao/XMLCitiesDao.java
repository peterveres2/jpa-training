package com.epam.jpatraining.xmlprocessor.dao;


import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Component;

import com.epam.jpatraining.xmlprocessor.domain.XMLCities;

@Component
public class XMLCitiesDao {

	@Autowired
	private Marshaller marshaller;
	
	@Autowired
	private Unmarshaller unmarshaller;

	
	public void write(XMLCities xmlCities, Result result) throws XmlMappingException, IOException {
		marshaller.marshal(xmlCities, result);
	}

	public XMLCities read(Source source) throws IOException {
		return (XMLCities) unmarshaller.unmarshal(source);
	}
	
}
