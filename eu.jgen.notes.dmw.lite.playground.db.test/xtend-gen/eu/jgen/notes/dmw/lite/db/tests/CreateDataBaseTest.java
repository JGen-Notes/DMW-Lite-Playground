package eu.jgen.notes.dmw.lite.db.tests;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@SuppressWarnings("all")
public class CreateDataBaseTest {
  public Connection connection;
  
  public /* InMemoryDatabaseHandler */Object handler;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }
  
  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }
  
  @Before
  public void setUp() throws Exception {
    throw new Error("Unresolved compilation problems:"
      + "\nInMemoryDatabaseHandler cannot be resolved."
      + "\nThe field CreateDataBaseTest.handler refers to the missing type InMemoryDatabaseHandler"
      + "\nThe field CreateDataBaseTest.handler refers to the missing type InMemoryDatabaseHandler"
      + "\nThe field CreateDataBaseTest.handler refers to the missing type InMemoryDatabaseHandler"
      + "\ncreateDataBase cannot be resolved"
      + "\nrunStatements cannot be resolved");
  }
  
  @After
  public void tearDown() throws Exception {
    this.connection.close();
    Assert.assertTrue(this.connection.isClosed());
  }
  
  @Test
  public void testConnection() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field CreateDataBaseTest.handler refers to the missing type InMemoryDatabaseHandler"
      + "\nisTableCreated cannot be resolved");
  }
}
