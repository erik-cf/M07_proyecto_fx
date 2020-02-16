package clienteControllers;

import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import performers.Producto;
import performers.Proveedor;
import tools.AuxStage;
import tools.UITools;

public class ExplorarClienteViewController implements Initializable {
	ObservableList<Proveedor> explorarData;

	@FXML
	TableView<Proveedor> explorarTableView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TableColumn<Proveedor, String> nombreProveedor = new TableColumn<Proveedor, String>("Nombre");
		nombreProveedor.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("nombre"));

		TableColumn<Proveedor, String> familiaProveedor = new TableColumn<Proveedor, String>("Familia");
		familiaProveedor.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("familia"));

		explorarData = FXCollections.observableList(Main.proveedores.stream()
				.filter(e -> !e.getClientes().contains(Main.selectedCliente)).collect(Collectors.toList()));
		
		explorarTableView.getColumns().setAll(nombreProveedor, familiaProveedor);

		UITools.setColumnsEqualWidth(explorarTableView);

		explorarTableView.setItems(explorarData);
	}

	public void lookForProducts() {
		if(explorarTableView.getSelectionModel().getSelectedItem() == null) {
			new Alert(AlertType.ERROR, "¡Debes seleccionar un elemento primero!", ButtonType.OK).show();
			return;
		}
		AuxStage<Producto> auxstage = new AuxStage<Producto>(explorarTableView.getSelectionModel().getSelectedItem().getProductos());
		auxstage.initModality(Modality.WINDOW_MODAL);
		auxstage.initOwner(explorarTableView.getScene().getWindow());
		auxstage.show();
	}
	
	public void newProveedor() {
		Proveedor p;
		if((p = explorarTableView.getSelectionModel().getSelectedItem()) == null) {
			new Alert(AlertType.ERROR, "¡Debes seleccionar un elemento primero!", ButtonType.OK).show();
			return;
		}
		try {
			ClienteManager.newProveedor(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		explorarTableView.getItems().remove(p);
	}
	
}
