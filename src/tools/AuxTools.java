package tools;

import performers.Producto;
import performers.ProductoAux;

public class AuxTools {

	public static ProductoAux createProductoAux(Producto p, float quantity) {
		float total = quantity * (p.getPrecio() - (p.getPrecio() * (p.getDescuento() / 100)));
		return new ProductoAux(p.getNombre(), quantity, total, p.getPrecio(), p.getDescuento());
	}
	
}
