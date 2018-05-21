package eu.jgen.notes.dmw.lite.db.tests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@SuppressWarnings("all")
public class AddRowIntoTableTest {
  public Connection connection;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }
  
  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }
  
  @Before
  public void setUp() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CREATE TABLE \"TRUE_ENTITY\" (");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"ID\" INTEGER NOT NULL,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"ANY_TEXT\" VARCHAR(20) NOT NULL");
    _builder.newLine();
    _builder.append(",\tCONSTRAINT \"pk_true_entity\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("PRIMARY KEY (\"ID\")");
    _builder.newLine();
    _builder.append(");");
    _builder.newLine();
    _builder.newLine();
    final String statements = _builder.toString();
  }
  
  @After
  public void tearDown() throws Exception {
    this.connection.close();
    Assert.assertTrue(this.connection.isClosed());
  }
  
  @Test
  public void testConnection() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("INSERT INTO \"TRUE_ENTITY\" (  ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("\"ID\",");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("\"ANY_TEXT\"");
      _builder.newLine();
      _builder.append(")");
      _builder.newLine();
      _builder.append("VALUES (");
      _builder.newLine();
      _builder.append("?, ");
      _builder.newLine();
      _builder.append("?");
      _builder.newLine();
      _builder.append(")");
      _builder.newLine();
      final String text = _builder.toString();
      PreparedStatement stmt = this.connection.prepareStatement(text);
      stmt.setInt(1, 20);
      stmt.setString(2, "any_text");
      stmt.execute();
      Assert.assertEquals(1, stmt.getUpdateCount());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
