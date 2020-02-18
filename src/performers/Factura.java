package performers;

import java.sql.Date;
import java.util.HashMap;

import tools.UITools;

public class Factura {
	private int id;
	private Date fecha;
	private HashMap<Producto, Double> productos;
	private int countProductos;
	private Proveedor proveedor;
	private Cliente cliente;
	private double importeBruto;
	private double importeNeto;

	public Factura() {
		productos = new HashMap<Producto, Double>();
	}

	public Factura(int id, Date fecha, HashMap<Producto, Double> productos, Proveedor proveedor, Cliente cliente,
			double importeBruto, double importeNeto) {
		super();
		this.id = id;
		this.fecha = fecha;
		if (productos != null) {
			this.productos = productos;
		} else {
			this.productos = new HashMap<Producto, Double>();
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

	public HashMap<Producto, Double> getProductos() {
		return productos;
	}

	public void setProductos(HashMap<Producto, Double> productos) {
		this.productos = productos;
		this.countProductos = productos.size();
	}
	
	public int getCountProductos() {
		return this.countProductos;
	}
	
	public void setCountProductos(int countProductos) {
		this.countProductos = countProductos;
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

	public double getImporteBruto() {
		return UITools.truncateDouble(importeBruto);
	}

	public void setImporteBruto(double importeBruto) {
		this.importeBruto = UITools.truncateDouble(importeBruto);
	}

	public double getImporteNeto() {
		return UITools.truncateDouble(importeNeto);
	}

	public void setImporteNeto(double importeNeto) {
		this.importeNeto = UITools.truncateDouble(importeNeto);
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", productos=" + productos + ", proveedor=" + proveedor
				+ ", cliente=" + cliente + ", importeBruto=" + importeBruto + ", importeNeto=" + importeNeto + "]";
	}

}
