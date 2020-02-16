package clienteControllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import application.Main;
import bbdd_tools.ClienteManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import performers.Pedido;
import performers.Producto;
import performers.Proveedor;
import tools.AuxStage;
import tools.CreateNewStage;
import tools.UITools;

public class ProveedorClienteViewController implements Initializable {

	ObservableList<Proveedor> proveedorData;

	@FXML
	TableView<Proveedor> proveedorTableView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TableColumn<Proveedor, String> nombreProveedor = new TableColumn<Proveedor, String>("Nombre");
		nombreProveedor.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("nombre"));

		TableColumn<Proveedor, String> familiaProveedor = new TableColumn<Proveedor, String>("Familia");
		familiaProveedor.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("familia"));

		proveedorData = FXCollections.observableList(Main.proveedores.stream()
				.filter(e -> e.getClientes().contains(Main.selectedCliente)).collect(Collectors.toList()));
		
		proveedorTableView.getColumns().setAll(nombreProveedor, familiaProveedor);

		UITools.setColumnsEqualWidth(proveedorTableView);

		proveedorTableView.setItems(proveedorData);
		proveedorTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	}
	
	public void lookForProducts() {
		if(proveedorTableView.getSelectionModel().getSelectedItem() == null) {
			new Alert(AlertType.ERROR, "¡Debes seleccionar un elemento primero!", ButtonType.OK).show();
			return;
		}
		
		AuxStage<Producto> auxstage = new AuxStage<Producto>(proveedorTableView.getSelectionModel().getSelectedItem().getProductos());
		auxstage.initModality(Modality.WINDOW_MODAL);
		auxstage.initOwner(proveedorTableView.getScene().getWindow());
		auxstage.show();
	}
	
	public void lookForPedidos() {
		if(proveedorTableView.getSelectionModel().getSelectedItem() == null) {
			new Alert(AlertType.ERROR, "¡Debes seleccionar un elemento primero!", ButtonType.OK).show();
			return;
		}
		
		ArrayList<Pedido> pedidosCliente = (ArrayList<Pedido>) Main.pedidos.stream()
				.filter(e -> e.getCliente().equals(Main.selectedCliente)
						&& e.getProveedor().equals(proveedorTableView.getSelectionModel().getSelectedItem()))
				.collect(Collectors.toList());
		AuxStage<Pedido> auxstage = new AuxStage<Pedido>(pedidosCliente);
		auxstage.initModality(Modality.WINDOW_MODAL);
		auxstage.initOwner(proveedorTableView.getScene().getWindow());
		auxstage.show();
	}
	
	public void registrarPedido() {
		if(proveedorTableView.getSelectionModel().getSelectedItem() == null) {
			new Alert(AlertType.ERROR, "¡Debes seleccionar un elemento primero!", ButtonType.OK).show();
			return;
		}
		
		CreateNewStage newStage = new CreateNewStage(CreateNewStage.PEDIDO, proveedorTableView.getSelectionModel().getSelectedItem());
		newStage.initModality(Modality.WINDOW_MODAL);
		newStage.initOwner(proveedorTableView.getScene().getWindow());
		newStage.show();
		
		
	}
	
	public void deleteItems() {
		try {
			ClienteManager.deleteProveedores(proveedorTableView.getSelectionModel().getSelectedItems());
		} catch (SQLException e) {
			new Alert(AlertType.ERROR, "Error borrando los proveedores...", ButtonType.OK).show();
			e.printStackTrace();
		}
		UITools.deleteItemsFromControl(proveedorTableView);
		
	}
	
}
