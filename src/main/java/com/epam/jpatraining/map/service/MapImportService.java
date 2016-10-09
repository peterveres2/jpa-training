package com.epam.jpatraining.map.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.jpatraining.xml.dao.XMLCountiesDao;
import com.epam.jpatraining.xml.domain.XMLCounties;
import com.epam.jpatraining.xml.domain.XMLCounty;

@Component
public class MapImportService {
	
	
	
	@Autowired
	XMLCountiesDao xmlCountiesDao;

	@Autowired
	DataSource dataSource;

	public void importData() throws IOException, SQLException {
		StreamSource source = new StreamSource(
				MapImportService.class.getResourceAsStream("/input/xml-input-hungary.xml"));
		
		XMLCounties xmlCounties = xmlCountiesDao.read(source);
		
		try (
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into county (id, name, seat, population, size) "
					+ "values (?, ?, ?, ?, ?)")
		){
			for (XMLCounty xmlCounty : xmlCounties.getCounty()) {
				preparedStatement.setString(1, xmlCounty.getId());
				preparedStatement.setString(2, xmlCounty.getName());
				preparedStatement.setString(3, xmlCounty.getSeat());
				preparedStatement.setInt(4, xmlCounty.getPopulation());
				preparedStatement.setInt(5, xmlCounty.getSize());
				preparedStatement.executeUpdate();
			}
		}	
	}

}
