package performers;

public class ProductoAux {

	private String nombre;
	private float cantidad;
	private float total;
	private float precio;
	private float descuento;

	public ProductoAux(String nombre, float cantidad, float total, float precio, float descuento) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.total = total;
		this.precio = precio;
		this.descuento = descuento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	
	

}
