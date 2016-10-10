package com.epam.jpatraining.map.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jpatraining.map.dao.CountyDao;
import com.epam.jpatraining.map.domain.CountyEntity;
import com.epam.jpatraining.map.domain.PathCommandEntity;
import com.epam.jpatraining.xml.dao.XMLCountiesDao;
import com.epam.jpatraining.xml.domain.XMLCounties;
import com.epam.jpatraining.xml.domain.XMLCounty;
import com.epam.jpatraining.xml.domain.XMLPathCommand;

@Component
public class MapService {

	@Autowired
	XMLCountiesDao xmlCountiesDao;
	
	@Autowired
	CountyDao countyDao;


	@Transactional
	public void importData() throws IOException, SQLException {
		StreamSource source = new StreamSource(MapService.class.getResourceAsStream("/input/xml-input-hungary.xml"));

		XMLCounties xmlCounties = xmlCountiesDao.read(source);
		
		for (XMLCounty xmlCounty : xmlCounties.getCounties()) {
			CountyEntity county = createCounty(xmlCounty);
			
			List<PathCommandEntity> pathCommands = new LinkedList<>();
			
			xmlCounty.getPathCommands().forEach(xmlPathCommand -> {
				createPathCommand(pathCommands, xmlPathCommand);
			});
			
			county.setPathCommands(pathCommands);
			countyDao.save(county);
			}
	}

	public CountyEntity findById(long id) {
		return countyDao.find(id);
	}

	private void createPathCommand(List<PathCommandEntity> pathCommands, XMLPathCommand xmlPathCommand) {
		PathCommandEntity pathCommand = new PathCommandEntity();
		pathCommand.setType(xmlPathCommand.getType());
		pathCommand.setPositionX(xmlPathCommand.getPositionX());
		pathCommand.setPositionY(xmlPathCommand.getPositionY());
		pathCommands.add(pathCommand);
	}


	private CountyEntity createCounty(XMLCounty xmlCounty) {
		CountyEntity county = new CountyEntity();
		
		county.setOrigId(xmlCounty.getId());
		county.setName(xmlCounty.getName());
		county.setSeat(xmlCounty.getSeat());
		county.setColor(xmlCounty.getColor());
		county.setPopulation(xmlCounty.getPopulation());
		county.setSize(xmlCounty.getSize());
		return county;
	}


}
