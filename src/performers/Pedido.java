package performers;

import java.sql.Date;
import java.util.HashMap;

import tools.UITools;

public class Pedido {
	private int id;
	private Cliente cliente;
	private Proveedor proveedor;
	private HashMap<Producto, Double> productos;
	private int countProductos;
	private double importeBruto;
	private double importeNeto;
	private Date fecha;

	public Pedido() {
			productos = new HashMap<Producto, Double>();
	}

	public Pedido(int id, Cliente cliente, Proveedor proveedor, HashMap<Producto, Double> productos, double importeBruto,
			double importeNeto, Date fecha) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.proveedor = proveedor;
		if (productos != null) {
			this.productos = productos;
		} else {
			this.productos = new HashMap<Producto, Double>();
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
