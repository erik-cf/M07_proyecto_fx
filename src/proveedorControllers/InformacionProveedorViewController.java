package proveedorControllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class InformacionProveedorViewController implements Initializable {
	
	@FXML
	Label numProductos;
	
	@FXML
	Label numClientes;
	
	@FXML
	Label numFacturas;
	
	@FXML
	Label numPedidosPendientes;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		int totalProductos = Main.selectedProveedor.getProductos().size();
		int totalClientes = Main.selectedProveedor.getClientes().size();
		int totalFacturas = Main.facturas.stream().filter(e -> e.getProveedor().equals(Main.selectedProveedor)).collect(Collectors.toList()).size();
		int totalPedidosPendientes = Main.pedidos.stream().filter(e -> e.getProveedor().equals(Main.selectedProveedor)).collect(Collectors.toList()).size();
		
		numProductos.setText(String.valueOf(totalProductos));
		numClientes.setText(String.valueOf(totalClientes));
		numFacturas.setText(String.valueOf(totalFacturas));
		numPedidosPendientes.setText(String.valueOf(totalPedidosPendientes));
	}

}
