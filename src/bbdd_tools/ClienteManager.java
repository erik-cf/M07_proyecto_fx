package bbdd_tools;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.Main;
import javafx.collections.ObservableList;
import performers.Cliente;
import performers.Proveedor;
import tools.SearchTools;

public class ClienteManager extends ConnectionManager {

	public static void updateClienteConfiguracion(Cliente c) throws SQLException {
		String sql = "UPDATE cliente SET nombre = ?, username = ? WHERE id = ?";
		PreparedStatement pstmnt = getConnection().prepareStatement(sql);
		pstmnt.setString(1, c.getNombre());
		pstmnt.setString(2, c.getUsername());
		pstmnt.setInt(3, c.getId());
		pstmnt.execute();
	}

	public static void deleteProveedores(ObservableList<Proveedor> proveedoresToDelete) throws SQLException {
		String sql;
		PreparedStatement pstmnt;
		ResultSet rs;
		int idPedido;
		
		for (Proveedor p : proveedoresToDelete) {
			Main.selectedCliente.getProveedores().remove(p);
			p.getClientes().remove(Main.selectedCliente);
			sql = "DELETE FROM cliente_proveedor WHERE id_proveedor = ? and id_cliente = ?";
			pstmnt = getConnection().prepareStatement(sql);
			pstmnt.setInt(1, p.getId());
			pstmnt.setInt(2, Main.selectedCliente.getId());
			pstmnt.execute();

			rs = DBTools.getResultSet("SELECT id FROM pedido WHERE id_proveedor = " + p.getId()
					+ " and id_cliente = " + Main.selectedCliente.getId());
			while (rs.next()) {
				idPedido = rs.getInt("id");
				Main.pedidos.remove(SearchTools.getPedidoById(idPedido));
				getConnection().createStatement()
						.executeUpdate("DELETE FROM pedido_producto WHERE id_pedido = " + idPedido);
			}

			sql = "DELETE FROM pedido WHERE id_proveedor = " + p.getId() + " and id_cliente = "
					+ Main.selectedCliente.getId();
			getConnection().createStatement().executeUpdate(sql);
		}
	}
	
	public static void newProveedor(Proveedor p) throws SQLException {
		p.getClientes().add(Main.selectedCliente);
		Main.selectedCliente.getProveedores().add(p);
		String sql = "INSERT INTO cliente_proveedor VALUES (?, ?)";
		PreparedStatement pstmnt = getConnection().prepareStatement(sql);
		pstmnt.setInt(1, Main.selectedCliente.getId());
		pstmnt.setInt(2, p.getId());
		pstmnt.execute();
	}
	
	public static void insertCliente(Cliente c) throws SQLException {
		String sql = "INSERT INTO cliente (nombre, username) VALUES (?, ?)";
		PreparedStatement pstmnt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		pstmnt.setString(1, c.getNombre());
		pstmnt.setString(2, c.getUsername());
		pstmnt.execute();
		ResultSet rs = pstmnt.getGeneratedKeys();
		if (rs.next()) {
			c.setId(rs.getInt(1));
		} else {
			throw new SQLException("Couldn't get the ID for the client inserted...");
		}
	}

}
