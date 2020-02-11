package bbdd_tools;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.ObservableList;

public class ProveedorManager extends ConnectionManager {

	public static void getClientesProveedor(int idProveedor) throws SQLException {
		String select = "SELECT c.nombre FROM clientes c, proveedor p, cliente_proveedor cp WHERE p.id = " + idProveedor + " and c.id = cp.id_cliente and p.id = cp.id_proveedor";
		Statement stmnt = getConnection().createStatement();
		stmnt.executeQuery(select);
	}
	
	
	
}
