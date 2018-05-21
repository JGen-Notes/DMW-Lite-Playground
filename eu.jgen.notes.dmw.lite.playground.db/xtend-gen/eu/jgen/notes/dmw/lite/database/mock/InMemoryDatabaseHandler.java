package eu.jgen.notes.dmw.lite.database.mock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class InMemoryDatabaseHandler {
  private Connection connection;
  
  public Connection createDataBase(final String dbname) {
    try {
      return this.connection = DriverManager.getConnection((("jdbc:derby:memory:" + dbname) + ";create=true"), null);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void runStatements(final String statements) {
    try {
      final String[] array = statements.split(";");
      for (final String statementText : array) {
        {
          int _length = statementText.trim().length();
          boolean _equals = (_length == 0);
          if (_equals) {
            return;
          }
          Statement stmt = this.connection.createStatement();
          stmt.executeUpdate(statementText.trim());
          stmt.close();
          this.connection.commit();
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean isTableCreated(final String tableName) {
    try {
      boolean _xblockexpression = false;
      {
        PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM SYS.SYSTABLES WHERE TABLENAME = ?");
        stmt.setString(1, tableName);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
          return true;
        }
        _xblockexpression = false;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
