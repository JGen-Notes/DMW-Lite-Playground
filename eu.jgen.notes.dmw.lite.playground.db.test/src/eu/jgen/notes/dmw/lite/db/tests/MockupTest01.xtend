package eu.jgen.notes.dmw.lite.db.tests

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import eu.jgen.notes.dmw.database.mock.InMemoryDatabaseHandler
import java.sql.Connection
import eu.jgen.notes.dmw.lib.JXWidget

import eu.jgen.notes.dmw.lib.JXViewType
import eu.jgen.notes.dmw.lib.JXGlobal
import eu.jgen.notes.dmw.lib.JXSimpleView
import java.sql.SQLException
import eu.jgen.notes.dmw.lite.db.TrueEntityView
import eu.jgen.notes.dmw.lite.db.Create

public class MockupTest01 {
	
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
		handler = new InMemoryDatabaseHandler();
		connection = handler.createDataBase("IEFDB");
		val statements = '''
			CREATE TABLE "TRUE_ENTITY" (
				"ID" INTEGER NOT NULL,
				"ANY_TEXT" VARCHAR(20) NOT NULL
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
	}

	@Test
	def void testConnection() {
		
	val create = 	JXWidget.getInstance(Create) as Create
	create._global = new JXGlobal()
	create._global._connection = connection
//    create.impTrueEntity = create._registerView("impTrueEntity", new TrueEntityView(JXViewType.IMPORT,"impTrueEntity")) as TrueEntityView
        create.impTrueEntity = create._registerView("impTrueEntity", TrueEntityView.getInstance(JXViewType.IMPORT,"impTrueEntity")) as TrueEntityView  // TODO change generation
    
//    create.expTrueEntity =  create._registerView("expTrueEntity", new TrueEntityView(JXViewType.EXPORT,"expTrueEntity")) as TrueEntityView

   create.expTrueEntity =  create._registerView("expTrueEntity",  TrueEntityView.getInstance(JXViewType.EXPORT,"expTrueEntity")) as TrueEntityView    // TODO change generation
   
    create.impTrueEntity.id.set(22)
    create.impTrueEntity.anyText.set("hello");
    
    try { 
    create._entry();   // execute widget logic 
     } catch (SQLException e) {
     	println(e.message)
     	println(e.errorCode)
     	throw new Exception(e)
     } finally {
     		println("finally")
     }
   assertEquals(22, create.expTrueEntity.id.value)
    assertEquals("hello", create.expTrueEntity.anyText.value.trim)
    
	}


}
