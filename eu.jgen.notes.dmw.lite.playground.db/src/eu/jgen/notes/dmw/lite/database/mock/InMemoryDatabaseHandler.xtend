package eu.jgen.notes.dmw.lite.database.mock

import java.sql.Connection
import java.sql.DriverManager

@SuppressWarnings("all")
public class InMemoryDatabaseHandler {

	private Connection connection

	def Connection createDataBase(String dbname) {
		connection = DriverManager.getConnection("jdbc:derby:memory:" + dbname + ";create=true", null);
	}

	def runStatements(String statements) {
		val array = statements.split(";")
		for (statementText : array) {
			if (statementText.trim.length == 0) {
				return
			}
			var stmt = connection.createStatement()
			stmt.executeUpdate(statementText.trim);
			stmt.close
			connection.commit
		}
	}

	def boolean isTableCreated(String tableName) {
		var stmt = connection.prepareStatement("SELECT * FROM SYS.SYSTABLES WHERE TABLENAME = ?")
		stmt.setString(1, tableName)
		var rs = stmt.executeQuery()
		while (rs.next()) {
			return true
		}
		false
	}

}
