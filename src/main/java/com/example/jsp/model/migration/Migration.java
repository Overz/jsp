package com.example.jsp.model.migration;

import java.io.File;
import org.flywaydb.core.Flyway;

public class Migration {

	private static final String USER = "cris";
	private static final String PASSWORD = "30752287";
	private static final String DATABASE = "jsp";
	private static final String URL = "jdbc:mysql:file:";
	private static final String SCHEMAS = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/resources/db/migration/*.sql";

	public void migrate() {

		// Create the Flyway instance and point it to the database
		Flyway flyway = Flyway.configure()
				.dataSource(URL + SCHEMAS, USER, PASSWORD).load();

		// Start the migration
		flyway.migrate();
	}
}
