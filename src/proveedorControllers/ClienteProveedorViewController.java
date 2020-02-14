package proveedorControllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Modality;
import performers.Cliente;
import performers.Pedido;
import tools.AuxStage;
import tools.UITools;

public class ClienteProveedorViewController implements Initializable {

	ObservableList<Cliente> dataClientes;

	@FXML
	ListView<Cliente> clientesListView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		dataClientes = FXCollections.observableList(Main.clientes.stream()
				.filter(e -> e.getProveedores().contains(Main.selectedProveedor)).collect(Collectors.toList()));
		clientesListView.setItems(dataClientes);
		clientesListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

	public void deleteSelectedItems() {
		UITools.deleteItemsFromControl(clientesListView);
	}

	public void showPedidos() {
		ArrayList<Pedido> pedidosCliente = (ArrayList<Pedido>) Main.pedidos.stream()
				.filter(e -> e.getCliente().equals(clientesListView.getSelectionModel().getSelectedItem())
						&& e.getProveedor().equals(Main.selectedProveedor))
				.collect(Collectors.toList());
		AuxStage<Pedido> auxstage = new AuxStage<Pedido>(pedidosCliente);
		auxstage.initModality(Modality.WINDOW_MODAL);
		auxstage.initOwner(clientesListView.getScene().getWindow());
		auxstage.show();
	}

}
