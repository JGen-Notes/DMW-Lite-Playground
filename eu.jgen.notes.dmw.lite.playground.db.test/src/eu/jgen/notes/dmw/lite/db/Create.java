package eu.jgen.notes.dmw.lite.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import eu.jgen.notes.dmw.lib.JXViewType;
import eu.jgen.notes.dmw.lib.JXWidget;
import eu.jgen.notes.dmw.lite.lang.YWidget;

@SuppressWarnings("all")
public class Create extends YWidget {
  private JXViewType dummy;
  
  public TrueEntityView impTrueEntity = null;
  
  public TrueEntityView expTrueEntity = null;
  
  public TrueEntityView currentTrueEntity = null;
  
  public Create() {
//    this.currentTrueEntity = (TrueEntityView) _registerView("currentTrueEntity", new TrueEntityView(JXViewType.ENTITY,"currentTrueEntity"));
    this.currentTrueEntity = (TrueEntityView) _registerView("currentTrueEntity",  TrueEntityView.getInstance(JXViewType.ENTITY,"currentTrueEntity"));

  }
  
  public void _entry() throws SQLException {
	  
	  // generate number set statements
	  currentTrueEntity.id.set(impTrueEntity.id.getValue());
	  currentTrueEntity.anyText.set(impTrueEntity.anyText.getValue());
	  
	  // create and execute sql statement
	  StringBuffer buffer = new StringBuffer();
	  buffer.append("INSERT INTO \"TRUE_ENTITY\" (  ");
	  buffer.append("\"ID\", ");
	  buffer.append( " \"ANY_TEXT\"");
	  buffer.append( ")");
	  buffer.append( "	VALUES (");
	  buffer.append( "?,");
	  buffer.append( "?");
	  buffer.append( ")");
	  System.out.println(buffer);
	  PreparedStatement stmt = _global._connection.prepareStatement(buffer.toString());
	  stmt.setInt(1,currentTrueEntity.id.getValue());
	  stmt.setString(2,currentTrueEntity.anyText.getValue());
	  stmt.execute();
	  
	  // create and execute sql statement
	   buffer = new StringBuffer();
	  buffer.append("INSERT INTO \"TRUE_ENTITY\" (  ");
	  buffer.append("\"ID\", ");
	  buffer.append( " \"ANY_TEXT\"");
	  buffer.append( ")");
	  buffer.append( "	VALUES (");
	  buffer.append( "?,");
	  buffer.append( "?");
	  buffer.append( ")");
	  System.out.println(buffer);
	   stmt = _global._connection.prepareStatement(buffer.toString());
	  stmt.setInt(1,currentTrueEntity.id.getValue());
	  stmt.setString(2,currentTrueEntity.anyText.getValue());
	  stmt.execute();
	  stmt.close();
	  buffer = null;
	  
	  // generate move statement
	  
	  _move(currentTrueEntity, expTrueEntity);
	  
	  
  }
}
