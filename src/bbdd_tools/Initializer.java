package bbdd_tools;

import java.sql.ResultSet;
import java.sql.SQLException;

import application.Main;
import performers.*;
import tools.SearchTools;

public class Initializer extends ConnectionManager implements ConnectionInterface {
	
	private static String SQLGETPROVEEDORES = "SELECT * FROM proveedor";
	private static String SQLGETCLIENTES = "SELECT * FROM cliente";
	private static String SQLGETPRODUCTOS = "SELECT * FROM producto";
	private static String SQLGETPEDIDOS = "SELECT * FROM pedido";
	private static String SQLGETFACTURAS = "SELECT * FROM factura";

	private static String SQLGETCLIENTESPROVEEDOR = "SELECT * FROM cliente_proveedor";
	private static String SQLGETPRODUCTOSPEDIDO = "SELECT * FROM pedido_producto";
	private static String SQLGETPRODUCTOSFACTURA = "SELECT * FROM factura_producto";

	public static ResultSet getResultSet(String sql) throws SQLException {
		return getConnection().createStatement().executeQuery(sql);
	}

	public static void fillMainArrays() throws SQLException {
		ResultSet rs = getResultSet(SQLGETPROVEEDORES);
		Proveedor prov;
		Cliente cli;
		Producto prod;
		Pedido ped;
		Factura fac;
		Proveedor provProd;
		while (rs.next()) {
			prov = new Proveedor();
			prov.setId(rs.getInt("id"));
			prov.setNombre(rs.getString("nombre"));
			prov.setUsername(rs.getString("username"));
			prov.setFamilia(rs.getString("familia"));
			Main.proveedores.add(prov);
		}

		rs = getResultSet(SQLGETCLIENTES);
		while (rs.next()) {
			cli = new Cliente();
			cli.setId(rs.getInt("id"));
			cli.setNombre(rs.getString("nombre"));
			cli.setUsername(rs.getString("username"));
			Main.clientes.add(cli);
		}

		rs = getResultSet(SQLGETPRODUCTOS);
		while (rs.next()) {
			prod = new Producto();
			prod.setId(rs.getInt("id"));
			prod.setNombre(rs.getString("nombre"));
			prod.setDescripcion(rs.getString("descripcion"));
			prod.setVentaPorPeso(rs.getBoolean("ventaPorPeso"));
			prod.setPrecio(rs.getDouble("precio"));
			prod.setStock(rs.getDouble("stock"));
			prod.setDescuento(rs.getDouble("descuento"));
			provProd = SearchTools.getProveedorById(rs.getInt("id_proveedor"));
			prod.setProveedor(provProd);
			provProd.getProductos().add(prod);
			Main.productos.add(prod);
		}

		rs = getResultSet(SQLGETPEDIDOS);
		while (rs.next()) {
			ped = new Pedido();
			ped.setId(rs.getInt("id"));
			ped.setFecha(rs.getDate("fecha"));
			ped.setProveedor(SearchTools.getProveedorById(rs.getInt("id_proveedor")));
			ped.setCliente(SearchTools.getClienteById(rs.getInt("id_cliente")));
			ped.setImporteBruto(rs.getDouble("importe_bruto"));
			ped.setImporteNeto(rs.getDouble("importe_neto"));
			Main.pedidos.add(ped);
		}

		rs = getResultSet(SQLGETFACTURAS);
		while (rs.next()) {
			fac = new Factura();
			fac.setId(rs.getInt("id"));
			fac.setFecha(rs.getDate("fecha"));
			fac.setProveedor(SearchTools.getProveedorById(rs.getInt("id_proveedor")));
			fac.setCliente(SearchTools.getClienteById(rs.getInt("id_cliente")));
			fac.setImporteBruto(rs.getDouble("importe_bruto"));
			fac.setImporteNeto(rs.getDouble("importe_neto"));
			Main.facturas.add(fac);
		}

		fillManyToMany();
	}

	private static void fillManyToMany() throws SQLException {
		Proveedor p;
		Cliente c;
		Factura f;
		Pedido pe;
		Producto pr;
		
		ResultSet rs = getResultSet(SQLGETCLIENTESPROVEEDOR);
		while (rs.next()) {
			p = SearchTools.getProveedorById(rs.getInt("id_proveedor"));
			c = SearchTools.getClienteById(rs.getInt("id_cliente"));
			if (p != null && c != null) {
				p.getClientes().add(c);
				c.getProveedores().add(p);
			}
		}
		
		rs = getResultSet(SQLGETPRODUCTOSPEDIDO);
		while (rs.next()) {
			pr = SearchTools.getProductoById(rs.getInt("id_producto"));
			pe = SearchTools.getPedidoById(rs.getInt("id_pedido"));
			if (pr != null && pe != null) {
				pe.getProductos().put(pr, rs.getDouble("cantidad"));
			}
			pe.setCountProductos(pe.getProductos().size());
		}
		
		rs = getResultSet(SQLGETPRODUCTOSFACTURA);
		while (rs.next()) {
			pr = SearchTools.getProductoById(rs.getInt("id_producto"));
			f = SearchTools.getFacturaById(rs.getInt("id_factura"));
			if (pr != null && f != null) {
				f.getProductos().put(pr, rs.getDouble("cantidad"));
			}
			f.setCountProductos(f.getProductos().size());
		}
	}
	
	

}
