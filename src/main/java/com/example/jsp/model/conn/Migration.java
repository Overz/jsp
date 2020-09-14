package com.example.jsp.model.conn;

import java.io.File;
import org.flywaydb.core.Flyway;

public class Migration {

	private static final String SCHEMAS = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/resources/migration/*.sql";

	public void migrate() {

		// Create the Flyway instance and point it to the database
		Flyway flyway = Flyway.configure()
				.dataSource("jdbc:mysql:file:" + SCHEMAS, "cris", "30752287").load();

		// Start the migration
		flyway.migrate();
	}
}
