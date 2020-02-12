package performers;

import java.sql.Date;
import java.util.HashMap;

public class Pedido {
	private int id;
	private Cliente cliente;
	private Proveedor proveedor;
	private HashMap<Producto, Float> productos;
	private int countProductos;
	private float importeBruto;
	private float importeNeto;
	private Date fecha;

	public Pedido() {
			productos = new HashMap<Producto, Float>();
	}

	public Pedido(int id, Cliente cliente, Proveedor proveedor, HashMap<Producto, Float> productos, float importeBruto,
			float importeNeto, Date fecha) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.proveedor = proveedor;
		if (productos != null) {
			this.productos = productos;
		} else {
			this.productos = new HashMap<Producto, Float>();
		}
		this.countProductos = productos.size();
		this.importeBruto = importeBruto;
		this.importeNeto = importeNeto;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public HashMap<Producto, Float> getProductos() {
		return productos;
	}

	public void setProductos(HashMap<Producto, Float> productos) {
		this.productos = productos;
		this.countProductos = productos.size();
	}
	
	public int getCountProductos() {
		return this.countProductos;
	}

	public float getImporteBruto() {
		return importeBruto;
	}

	public void setImporteBruto(float importeBruto) {
		this.importeBruto = importeBruto;
	}

	public float getImporteNeto() {
		return importeNeto;
	}

	public void setImporteNeto(float importeNeto) {
		this.importeNeto = importeNeto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", productos=" + productos + ", importeBruto="
				+ importeBruto + ", importeNeto=" + importeNeto + "]";
	}
	
	

}
