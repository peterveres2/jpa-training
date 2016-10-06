package com.epam.jpatraining.xmlprocessor.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.transform.Result;
import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Component;

import com.epam.jpatraining.common.SVGPathCommandType;
import com.epam.jpatraining.xmlprocessor.dao.SVGDao;
import com.epam.jpatraining.xmlprocessor.dao.XMLCitiesDao;
import com.epam.jpatraining.xmlprocessor.domain.SVG;
import com.epam.jpatraining.xmlprocessor.domain.SVG.Path;
import com.epam.jpatraining.xmlprocessor.domain.XMLCities;
import com.epam.jpatraining.xmlprocessor.domain.XMLCity;
import com.epam.jpatraining.xmlprocessor.domain.XMLPathCommand;

@Component
public class XMLProcessorService {

	static final Pattern pattern = Pattern.compile("[M|L|l]-?(0|([1-9]\\d*))(\\.\\d+)?.-?(0|([1-9]\\d*))(\\.\\d+)?");
	
	@Autowired
	private XMLCitiesDao xmlCitiesDao;
	
	@Autowired
	private SVGDao svgDao;

	
	public void importData(Source source, Result result) throws XmlMappingException, IOException {
		SVG svg = svgDao.read(source);
		
		XMLCities xmlCities = svgToXMLCities(svg);
		xmlCitiesDao.write(xmlCities, result);
		
	}

	private XMLCities svgToXMLCities(SVG svg) {
		List<XMLCity> cities = new LinkedList<>();
		XMLPathCommand pathCommand;
		for (Path p : svg.getPath()) {
			XMLCity city = new XMLCity();
			city.setName(p.getTitle());
			city.setId(p.getId());
			city.setColor(String.format("FF%06X", (0xFFFFFF & p.getTitle().hashCode())));
			
			List<XMLPathCommand> pathCommands = new LinkedList<>();
			Matcher matcher = pattern.matcher(p.getD());
			while (matcher.find()) {				
				String[] values = matcher.group().split(",");
				pathCommand = new XMLPathCommand();
				pathCommand.setType(SVGPathCommandType.valueOf(values[0].substring(0, 1)));
				pathCommand.setPositionX(new BigDecimal(values[0].substring(1)));
				pathCommand.setPositionY(new BigDecimal(values[1]));
				pathCommands.add(pathCommand);
			}
			city.setPathCommands(pathCommands);
			cities.add(city);
		}		
		XMLCities xmlCities = new XMLCities();
		xmlCities.setCities(cities);
		return xmlCities;
	}
	

}
