package performers;

import tools.UITools;

public class ProductoAux {

	private String nombre;
	private double cantidad;
	private double total;
	private double precio;
	private double descuento;

	public ProductoAux(String nombre, double cantidad, double total, double precio, double descuento) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.total = UITools.truncateDouble(total);
		this.precio = UITools.truncateDouble(precio);
		this.descuento = UITools.truncateDouble(descuento);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return UITools.truncateDouble(total);
	}

	public void setTotal(double total) {
		this.total = UITools.truncateDouble(total);
	}

	public double getPrecio() {
		return UITools.truncateDouble(precio);
	}

	public void setPrecio(double precio) {
		this.precio = UITools.truncateDouble(precio);
	}

	public double getDescuento() {
		return UITools.truncateDouble(descuento);
	}

	public void setDescuento(double descuento) {
		this.descuento = UITools.truncateDouble(descuento);
	}
	
	

}
