package com.example.jsp.model.conn;

import org.flywaydb.core.Flyway;

public class Migration {
	public void migrate() {

		// Create the Flyway instance and point it to the database
		Flyway flyway = Flyway.configure()
				.dataSource("jdbc:mysql:file:../../../../../../resources/migration/V1__Create_fornecedor.sql", "cris", "30752287").load();

		// Start the migration
		flyway.migrate();
	}
}
