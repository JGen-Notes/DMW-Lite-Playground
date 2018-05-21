package eu.jgen.notes.dmw.lite.db.tests

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import eu.jgen.notes.dmw.database.mock.InMemoryDatabaseHandler
import java.sql.Connection

public class CreateDataBaseTest {
	
	public Connection connection
	public InMemoryDatabaseHandler handler

	@BeforeClass
	def static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	def static void tearDownAfterClass() throws Exception {
	}

	@Before
	def void setUp() throws Exception {
		//println("Start")
		handler = new InMemoryDatabaseHandler();
		connection = handler.createDataBase("IEFDB");
		val statements = '''
			CREATE TABLE "TRUE_ENTITY" (
				"ID" INTEGER NOT NULL,
				"ANY_TEXT" VARCHAR(1) NOT NULL
			,	CONSTRAINT "pk_true_entity"
				PRIMARY KEY ("ID")
			);
			
		'''
		handler.runStatements(statements);
	}

	@After
	def void tearDown() throws Exception {
		connection.close
		assertTrue(connection.closed)
			//println("End")
	}

	@Test
	def void testConnection() {
		assertTrue(handler.isTableCreated("TRUE_ENTITY"))
	}


}
