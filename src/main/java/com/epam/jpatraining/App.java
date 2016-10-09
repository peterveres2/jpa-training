package com.epam.jpatraining;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.oxm.XmlMappingException;

/**
 * Map creator application
 *
 */
public class App {

	public static void main(String[] args) throws XmlMappingException, IOException, SQLException {
		try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				"com.epam.jpatraining.config")) {

			
//			DataSource dataSource = context.getBean(DataSource.class);
//			
//			Connection conn = dataSource.getConnection();
//			Statement statement = conn.createStatement();
//			
//			
//			ResultSet rs = statement.executeQuery("select * from test1");
//			rs.next();
//			System.out.println(rs.getString(1));
			
			 
			 
		}

	}
}
