package com.epam.jpatraining;

import java.sql.SQLException;

public class DumpDatabase {
	public static void main(String[] args) throws SQLException {
		
		org.h2.tools.Script.main("-url", "jdbc:h2:tcp://localhost:9092/../database/map", "-script", "export.sql");
	}
}
