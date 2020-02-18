package performers;

import java.util.ArrayList;

public class Producto {

	private int id;
	private String nombre;
	private String descripcion;
	private boolean ventaPorPeso;
	private double precio;
	private double stock;
	private double descuento;
	private Proveedor proveedor;
	private ArrayList<Pedido> pedidos;
	private ArrayList<Factura> facturas;
	
	public Producto() {
		pedidos = new ArrayList<Pedido>();
		facturas = new ArrayList<Factura>();
	}

	public Producto(int id, String nombre, String descripcion, boolean ventaPorPeso, double precio, double stock, double descuento, Proveedor proveedor, ArrayList<Pedido> pedidos, ArrayList<Factura> facturas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ventaPorPeso = ventaPorPeso;
		this.precio = precio;
		this.stock = stock;
		this.descuento = descuento;
		this.proveedor = proveedor;
		if(pedidos == null) {
			this.pedidos = new ArrayList<Pedido>();
		}else {
			this.pedidos = pedidos;
		}
		
		if(facturas == null) {
			this.facturas = new ArrayList<Factura>();
		}else {
			this.facturas = facturas;
		}
	}
	
	public Producto(int id, String nombre, String descripcion, boolean ventaPorPeso, double precio, double stock, double descuento, Proveedor proveedor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ventaPorPeso = ventaPorPeso;
		this.precio = precio;
		this.stock = stock;
		this.descuento = descuento;
		this.proveedor = proveedor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isVentaPorPeso() {
		return ventaPorPeso;
	}

	public void setVentaPorPeso(boolean ventaPorPeso) {
		this.ventaPorPeso = ventaPorPeso;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double getStock() {
		return stock;
	}
	
	public void setStock(double stock) {
		this.stock = stock;
	}
	
	public double getDescuento() {
		return this.descuento;
	}
	
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	public Proveedor getProveedor() {
		return proveedor;
	}
	
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}

	@Override
	public String toString() {
		return nombre;
	}	
}

