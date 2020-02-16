package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import performers.Proveedor;
import tools.CreateNewStage;

public class SelectProveedorController implements Initializable {
	
	@FXML
	ChoiceBox<Proveedor> proveedorChoiceBox;
	
	ObservableList<Proveedor> dataChoiceBox;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dataChoiceBox = FXCollections.observableArrayList(Main.selectedCliente.getProveedores());
		proveedorChoiceBox.setItems(dataChoiceBox);
	}
	
	public void aceptar() {
		if(proveedorChoiceBox.getSelectionModel().getSelectedItem() == null) {
			new Alert(AlertType.ERROR, "¡Debes seleccionar un elemento primero!", ButtonType.OK).show();
			return;
		}
		
		CreateNewStage newStage = new CreateNewStage(CreateNewStage.PEDIDO, proveedorChoiceBox.getSelectionModel().getSelectedItem());
		newStage.initModality(Modality.WINDOW_MODAL);
		newStage.initOwner(Main.mainStaticStage);
		newStage.show();
		((Stage)proveedorChoiceBox.getScene().getWindow()).close();
		
	}
	
	
}
