package performers;

import java.sql.Date;
import java.util.HashMap;

public class Factura {
	private int id;
	private Date fecha;
	private HashMap<Producto, Float> productos;
	private int countProductos;
	private Proveedor proveedor;
	private Cliente cliente;
	private float importeBruto;
	private float importeNeto;

	public Factura() {
		productos = new HashMap<Producto, Float>();
	}

	public Factura(int id, Date fecha, HashMap<Producto, Float> productos, Proveedor proveedor, Cliente cliente,
			float importeBruto, float importeNeto) {
		super();
		this.id = id;
		this.fecha = fecha;
		if (productos != null) {
			this.productos = productos;
		} else {
			this.productos = new HashMap<Producto, Float>();
		}
		this.countProductos = productos.size();
		this.proveedor = proveedor;
		this.cliente = cliente;
		this.importeBruto = importeBruto;
		this.importeNeto = importeNeto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", productos=" + productos + ", proveedor=" + proveedor
				+ ", cliente=" + cliente + ", importeBruto=" + importeBruto + ", importeNeto=" + importeNeto + "]";
	}

}
