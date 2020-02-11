package performers;

import java.util.ArrayList;

public class Cliente {

	private int id;
	private String nombre;
	private String username;
	private ArrayList<Proveedor> proveedores;
	private ArrayList<Pedido> pedidos;

	public Cliente() {
		pedidos = new ArrayList<Pedido>();
		proveedores = new ArrayList<Proveedor>();
	}

	public Cliente(int id, String nombre, String username, ArrayList<Proveedor> proveedores,
			ArrayList<Pedido> pedidos) {
		this.id = id;
		this.nombre = nombre;
		if (pedidos != null) {
			this.pedidos = pedidos;
		} else {
			this.pedidos = new ArrayList<Pedido>();
		}
		this.username = username;
		if (proveedores == null) {
			this.proveedores = new ArrayList<Proveedor>();
		} else {
			this.proveedores = proveedores;
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
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(ArrayList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return nombre;
	}

}
