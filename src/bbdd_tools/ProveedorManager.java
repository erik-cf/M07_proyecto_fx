package bbdd_tools;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.Main;
import javafx.collections.ObservableList;
import performers.Cliente;
import performers.Factura;
import performers.Pedido;
import performers.Producto;
import performers.Proveedor;
import tools.SearchTools;

public class ProveedorManager extends ConnectionManager {

	public static void getClientesProveedor(int idProveedor) throws SQLException {
		String select = "SELECT c.nombre FROM clientes c, proveedor p, cliente_proveedor cp WHERE p.id = " + idProveedor
				+ " and c.id = cp.id_cliente and p.id = cp.id_proveedor";
		Statement stmnt = getConnection().createStatement();
		stmnt.executeQuery(select);
	}

	public static void updateProveedorConfiguracion(Proveedor p) throws SQLException {
		String sql = "UPDATE proveedor SET nombre = ?, username = ?, familia = ? WHERE id = ?";
		PreparedStatement pstmnt = getConnection().prepareStatement(sql);
		pstmnt.setString(1, p.getNombre());
		pstmnt.setString(2, p.getUsername());
		pstmnt.setString(3, p.getFamilia());
		pstmnt.setInt(4, p.getId());
		pstmnt.execute();
	}

	public static void insertPedido(Pedido p) throws SQLException {
		String sql = "INSERT INTO pedido(id_cliente, id_proveedor, importe_bruto, importe_neto, fecha) VALUES(?, ?, ?, ?, ?)";
		PreparedStatement pstmnt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		pstmnt.setInt(1, p.getCliente().getId());
		pstmnt.setInt(2, p.getProveedor().getId());
		pstmnt.setFloat(3, p.getImporteBruto());
		pstmnt.setFloat(4, p.getImporteNeto());
		pstmnt.setDate(5, p.getFecha());
		pstmnt.execute();
		ResultSet rs = pstmnt.getGeneratedKeys();
		if (rs.next()) {
			p.setId(rs.getInt(1));
		} else {
			throw new SQLException("Couldn't get the ID for the pedido inserted...");
		}
		insertManyToManyPedido(p);

	}

	private static void insertManyToManyPedido(Pedido p) throws SQLException {
		String sql = "INSERT INTO pedido_producto VALUES (?, ?, ?)";
		PreparedStatement pstmnt;
		for (Producto pr : p.getProductos().keySet()) {
			pstmnt = getConnection().prepareStatement(sql);
			pstmnt.setInt(1, p.getId());
			pstmnt.setInt(2, pr.getId());
			pstmnt.setFloat(3, p.getProductos().get(pr));
			pstmnt.execute();
		}
	}

	public static void cobrarPedido(Pedido p) throws SQLException {
		Factura f = new Factura();
		f.setCliente(p.getCliente());
		f.setProveedor(p.getProveedor());
		f.setFecha(p.getFecha());
		f.setProductos(p.getProductos());
		f.setImporteBruto(p.getImporteBruto());
		f.setImporteNeto(p.getImporteNeto());
		String insert = "INSERT INTO factura(fecha, id_proveedor, id_cliente, importe_bruto, importe_neto) VALUES(?, ?, ?, ?, ?)";
		PreparedStatement pstmnt = getConnection().prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
		pstmnt.setDate(1, p.getFecha());
		pstmnt.setInt(2, p.getProveedor().getId());
		pstmnt.setInt(3, p.getCliente().getId());
		pstmnt.setFloat(4, p.getImporteBruto());
		pstmnt.setFloat(5, p.getImporteNeto());
		pstmnt.execute();
		ResultSet rs = pstmnt.getGeneratedKeys();
		if (rs.next()) {
			f.setId(rs.getInt(1));
		} else {
			throw new SQLException("Couldn't get the ID for the pedido inserted...");
		}
		Main.facturas.add(f);
		insertManyToManyFactura(f);
		deletePedido(p);
	}

	private static void insertManyToManyFactura(Factura f) throws SQLException {
		String sql = "INSERT INTO factura_producto VALUES (?, ?, ?)";
		PreparedStatement pstmnt;
		for (Producto pr : f.getProductos().keySet()) {
			pstmnt = getConnection().prepareStatement(sql);
			pstmnt.setInt(1, f.getId());
			pstmnt.setInt(2, pr.getId());
			pstmnt.setFloat(3, f.getProductos().get(pr));
			pstmnt.execute();
		}
	}

	public static void deletePedido(Pedido p) throws SQLException {
		String sql = "DELETE FROM pedido_producto WHERE id_pedido = " + p.getId();
		getConnection().createStatement().executeUpdate(sql);
		sql = "DELETE FROM pedido WHERE id = " + p.getId();
		getConnection().createStatement().executeUpdate(sql);
	}

	public static void deleteClientes(ObservableList<Cliente> clientesToDelete) throws SQLException {
		String sql;
		PreparedStatement pstmnt;
		ResultSet rs;
		int idPedido;

		for (Cliente c : clientesToDelete) {
			Main.selectedProveedor.getClientes().remove(c);
			c.getProveedores().remove(Main.selectedProveedor);
			sql = "DELETE FROM cliente_proveedor WHERE id_proveedor = ? and id_cliente = ?";
			pstmnt = getConnection().prepareStatement(sql);
			pstmnt.setInt(1, Main.selectedProveedor.getId());
			pstmnt.setInt(2, c.getId());
			pstmnt.execute();

			rs = DBTools.getResultSet("SELECT id FROM pedido WHERE id_proveedor = " + Main.selectedProveedor.getId()
					+ " and id_cliente = " + c.getId());
			while (rs.next()) {
				idPedido = rs.getInt("id");
				Main.pedidos.remove(SearchTools.getPedidoById(idPedido));
				getConnection().createStatement()
						.executeUpdate("DELETE FROM pedido_producto WHERE id_pedido = " + idPedido);
			}

			sql = "DELETE FROM pedido WHERE id_proveedor = " + Main.selectedProveedor.getId() + " and id_cliente = "
					+ c.getId();
			getConnection().createStatement().executeUpdate(sql);
		}
	}

	public static void insertNewProduct(Producto p) throws SQLException {
		String sql = "INSERT INTO producto (nombre, descripcion, ventaPorPeso, precio, stock, descuento, id_proveedor) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmnt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		pstmnt.setString(1, p.getNombre());
		pstmnt.setString(2, p.getDescripcion());
		pstmnt.setBoolean(3, p.isVentaPorPeso());
		pstmnt.setFloat(4, p.getPrecio());
		pstmnt.setFloat(5, p.getStock());
		pstmnt.setFloat(6, p.getDescuento());
		pstmnt.setInt(7, p.getProveedor().getId());
		pstmnt.execute();
		ResultSet rs = pstmnt.getGeneratedKeys();
		if (rs.next()) {
			p.setId(rs.getInt(1));
		} else {
			throw new SQLException("Couldn't get the ID for the product inserted...");
		}
	}

	public static void deleteProduct(ObservableList<Producto> listaProductos) throws SQLException {
		String sql;
		for (Producto p : listaProductos) {
			sql = "DELETE FROM producto WHERE id = " + p.getId();
			getConnection().createStatement().executeUpdate(sql);
		}
	}
	
	public static void insertProveedor(Proveedor p) throws SQLException {
		String sql = "INSERT INTO proveedor (nombre, username, familia) VALUES (?, ?, ?)";
		PreparedStatement pstmnt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		pstmnt.setString(1, p.getNombre());
		pstmnt.setString(2, p.getUsername());
		pstmnt.setString(3, p.getFamilia());
		pstmnt.execute();
		ResultSet rs = pstmnt.getGeneratedKeys();
		if (rs.next()) {
			p.setId(rs.getInt(1));
		} else {
			throw new SQLException("Couldn't get the ID for the proveedor inserted...");
		}
	}

}
