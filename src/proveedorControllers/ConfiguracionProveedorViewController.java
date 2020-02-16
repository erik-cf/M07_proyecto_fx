package proveedorControllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.Main;
import bbdd_tools.ProveedorManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class ConfiguracionProveedorViewController implements Initializable {
	
	@FXML
	TextField nameTextField;
	
	@FXML
	TextField usernameTextField;
	
	@FXML
	TextField familiaTextField;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nameTextField.setText(Main.selectedProveedor.getNombre());
		usernameTextField.setText(Main.selectedProveedor.getUsername());
		familiaTextField.setText(Main.selectedProveedor.getFamilia());
	}

	public void applyChanges() throws SQLException {
		Main.selectedProveedor.setNombre(nameTextField.getText());
		Main.selectedProveedor.setUsername(usernameTextField.getText());
		Main.selectedProveedor.setFamilia(familiaTextField.getText());
		ProveedorManager.updateProveedorConfiguracion(Main.selectedProveedor);
	}

}
