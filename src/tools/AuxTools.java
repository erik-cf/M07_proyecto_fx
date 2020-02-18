package tools;

import performers.Producto;
import performers.ProductoAux;

public class AuxTools {

	public static ProductoAux createProductoAux(Producto p, double quantity) {
		double total = UITools.truncateDouble(quantity * (p.getPrecio() - (p.getPrecio() * (p.getDescuento() / 100))));
		return new ProductoAux(p.getNombre(), UITools.truncateDouble(quantity), total, p.getPrecio(), p.getDescuento());
	}
	
}
