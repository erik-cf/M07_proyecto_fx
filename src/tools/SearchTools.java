package tools;

import application.Main;
import performers.*;

public class SearchTools {

	public static Proveedor getProveedorById(int id) {
		for(Proveedor p : Main.proveedores){
			if(p.getId() == id)
				return p;
		}
		return null;
	}
	
	public static Cliente getClienteById(int id) {
		for(Cliente c : Main.clientes){
			if(c.getId() == id)
				return c;
		}
		return null;
	}
	
	public static Producto getProductoById(int id) {
		for(Producto p : Main.productos){
			if(p.getId() == id)
				return p;
		}
		return null;
	}
	
	public static Pedido getPedidoById(int id) {
		for(Pedido p : Main.pedidos){
			if(p.getId() == id)
				return p;
		}
		return null;
	}
	
	public static Factura getFacturaById(int id) {
		for(Factura f : Main.facturas){
			if(f.getId() == id)
				return f;
		}
		return null;
	}
}
