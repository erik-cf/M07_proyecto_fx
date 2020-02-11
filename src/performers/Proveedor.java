package performers;

import java.util.ArrayList;

public class Proveedor {

	private int id;
	private String nombre;
	private String username;
	private String familia;
	private ArrayList<Cliente> clientes;
	private ArrayList<Producto> productos;

	public Proveedor() {
		clientes = new ArrayList<Cliente>();
		productos = new ArrayList<Producto>();
	}

	public Proveedor(int id, String nombre, String username, String familia, ArrayList<Cliente> clientes,
			ArrayList<Producto> productos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.username = username;
		this.familia = familia;
		if (clientes == null) {
			this.clientes = new ArrayList<Cliente>();
		} else {
			this.clientes = clientes;
		}

		if (productos == null) {
			this.productos = new ArrayList<Producto>();
		} else {
			this.productos = productos;
		}
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nombre + ", username=" + username + ", familia=" + familia
				+ ", clientes=" + clientes + ", productos=" + productos + "]";
	}

}
