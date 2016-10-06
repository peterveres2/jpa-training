package com.epam.jpatraining.xmlprocessor.dao;

import java.io.IOException;

import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Component;

import com.epam.jpatraining.xmlprocessor.domain.SVG;

@Component
public class SVGDao {

	@Autowired
	private Unmarshaller unmarshaller;
	
	
	public SVG read(Source source) throws XmlMappingException, IOException {
		return (SVG)unmarshaller.unmarshal(source);
	}
}
