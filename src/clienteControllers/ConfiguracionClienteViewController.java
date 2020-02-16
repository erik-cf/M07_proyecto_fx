package clienteControllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.Main;
import bbdd_tools.ClienteManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class ConfiguracionClienteViewController implements Initializable {

	@FXML
	TextField nameTextField;
	
	@FXML
	TextField usernameTextField;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nameTextField.setText(Main.selectedCliente.getNombre());
		usernameTextField.setText(Main.selectedCliente.getUsername());
	}

	public void applyChanges() throws SQLException {
		Main.selectedCliente.setNombre(nameTextField.getText());
		Main.selectedCliente.setUsername(usernameTextField.getText());
		ClienteManager.updateClienteConfiguracion(Main.selectedCliente);
	}
}
