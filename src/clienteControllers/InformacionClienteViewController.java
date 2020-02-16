package clienteControllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class InformacionClienteViewController implements Initializable{
	@FXML
	Label numProveedores;
	
	@FXML
	Label numPedidosRealizados;
	
	@FXML
	Label numFacturas;
	
	@FXML
	Label numPedidosPendientes;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		int totalProveedores = Main.selectedCliente.getProveedores().size();
		int totalFacturas = Main.facturas.stream().filter(e -> e.getCliente().equals(Main.selectedCliente)).collect(Collectors.toList()).size();
		int totalPedidosPendientes = Main.pedidos.stream().filter(e -> e.getCliente().equals(Main.selectedCliente)).collect(Collectors.toList()).size();;
		int totalPedidosRealizados = totalFacturas + totalPedidosPendientes;
		numProveedores.setText(String.valueOf(totalProveedores));
		numPedidosRealizados.setText(String.valueOf(totalPedidosRealizados));
		numFacturas.setText(String.valueOf(totalFacturas));
		numPedidosPendientes.setText(String.valueOf(totalPedidosPendientes));
	}
}
