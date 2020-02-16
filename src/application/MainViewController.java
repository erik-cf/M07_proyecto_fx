package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import performers.Cliente;
import performers.Proveedor;

public class MainViewController extends Main implements Initializable {
	
	ObservableList loginData;
	
	@FXML
	TableView loginTableView;
	
	@FXML
	RadioButton clienteRadioButton;
	
	@FXML
	RadioButton proveedorRadioButton;
	
	@FXML
	ToggleGroup opcionLogin;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void radioButtonAction() {
		if(opcionLogin.getSelectedToggle().equals(clienteRadioButton)) {
			TableColumn<Cliente, String> nombreCliente = new TableColumn<Cliente, String>("nombre");
	        nombreCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
	        TableColumn<Cliente, String> usernameCliente = new TableColumn<Cliente, String>("username");
	        usernameCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("username"));
	        nombreCliente.setPrefWidth(460);
	        usernameCliente.setPrefWidth(460);
	        
	        loginTableView.getColumns().setAll(nombreCliente, usernameCliente);
	        
	        loginData = FXCollections.observableList(Main.clientes);
	        loginTableView.setItems(loginData);
		}else {// if(opcionLogin.getSelectedToggle().equals(proveedorRadioButton)) {
			TableColumn<Proveedor, String> nombreProveedor = new TableColumn<Proveedor, String>("nombre");
	        nombreProveedor.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("nombre"));
	        TableColumn<Proveedor, String> usernameProveedor = new TableColumn<Proveedor, String>("username");
	        usernameProveedor.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("username"));
	        nombreProveedor.setPrefWidth(460);
	        usernameProveedor.setPrefWidth(460);
	        
	        loginTableView.getColumns().setAll(nombreProveedor, usernameProveedor);
	        
	        loginData = FXCollections.observableList(Main.proveedores);
	        loginTableView.setItems(loginData);
		}
	}
	
	public void loginButtonAction() throws IOException {
		if(opcionLogin.getSelectedToggle() == null) {
			Alert emptyRadioButtons = new Alert(AlertType.ERROR, "¡Debes escoger una opción de Login (Cliente / Proveedor)!", ButtonType.OK);
			emptyRadioButtons.setTitle("¡Escoge una opción!");
			emptyRadioButtons.show();
			return;
		}
		if(loginTableView.getSelectionModel().isEmpty()) {
			Alert emptyUser = new Alert(AlertType.ERROR, "¡Debes seleccionar un usuario!", ButtonType.OK);
			emptyUser.setTitle("¡Selecciona un usuario!");
			emptyUser.show();
			return;
		}		
		
		Parent root;
		if(clienteRadioButton.isSelected()) {
			Main.selectedCliente = (Cliente)loginTableView.getSelectionModel().getSelectedItem();
			Main.selectedProveedor = null;
			root = FXMLLoader.load(getClass().getResource("../cliente_fxml/ClienteView.fxml"));
			
		}else {
			Main.selectedCliente = null;
			Main.selectedProveedor = (Proveedor)loginTableView.getSelectionModel().getSelectedItem();
			root = FXMLLoader.load(getClass().getResource("../proveedor_fxml/ProveedorView.fxml"));
			
		}
		BorderPane appMainPane = ((BorderPane)loginTableView.getScene().getRoot());
		appMainPane.setCenter(root);
		MenuBarController.addMenuBarToApp(appMainPane);
		
		
		
	}

}
