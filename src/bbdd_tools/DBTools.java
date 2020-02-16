package bbdd_tools;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTools extends ConnectionManager {
	public static ResultSet getResultSet(String select) throws SQLException {
		return getConnection().createStatement().executeQuery(select);
	}
}
