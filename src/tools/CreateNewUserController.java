package tools;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.Main;
import bbdd_tools.ClienteManager;
import bbdd_tools.ProveedorManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import performers.Cliente;
import performers.Proveedor;
import javafx.scene.control.Alert.AlertType;

public class CreateNewUserController implements Initializable {
	
	@FXML
	ToggleGroup userGroup;
	
	@FXML
	RadioButton clienteRadioButton;
	
	@FXML
	RadioButton proveedorRadioButton;
	
	@FXML
	TextField nombreTextField;
	
	@FXML
	TextField userTextField;
	
	@FXML
	Label labelFamilia;
	
	@FXML
	TextField familiaTextField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		labelFamilia.setVisible(false);
		familiaTextField.setVisible(false);
	}

	public void showOption() {
		if(proveedorRadioButton.isSelected()) {
			familiaTextField.setVisible(true);
			labelFamilia.setVisible(true);
		}else {
			familiaTextField.setVisible(false);
			labelFamilia.setVisible(false);
		}
	}
	
	public void guardar() {
		if(userGroup.getSelectedToggle() == null) {
			new Alert(AlertType.ERROR, "¡Error! ¡Debes seleccionar entre proveedor o cliente!", ButtonType.OK).show();
			return;
		}
		
		if(nombreTextField.getText().equals("") || userTextField.getText().equals("") || (proveedorRadioButton.isSelected() && familiaTextField.getText().equals(""))) {
			new Alert(AlertType.ERROR, "¡Error! ¡Todos los campos son obligatorios!", ButtonType.OK).show();
			return;
		}
		
		if(clienteRadioButton.isSelected()) {
			Cliente c = new Cliente();
			c.setNombre(nombreTextField.getText());
			c.setUsername(userTextField.getText());
			try {
				ClienteManager.insertCliente(c);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Main.clientes.add(c);
		}else {
			Proveedor p = new Proveedor();
			p.setNombre(nombreTextField.getText());
			p.setUsername(userTextField.getText());
			p.setFamilia(familiaTextField.getText());
			try {
				ProveedorManager.insertProveedor(p);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Main.proveedores.add(p);
		}
		
		((CreateNewStage)labelFamilia.getScene().getWindow()).close();
		new Alert(AlertType.INFORMATION, "Vuelve a escoger la opción de proveedor / cliente para actualizar la tabla.", ButtonType.OK).show();
		
	}
}
