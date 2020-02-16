package tools;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.Main;
import bbdd_tools.ProveedorManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import performers.Producto;
import javafx.scene.control.Alert.AlertType;

public class CreateNewProductoController implements Initializable {

	@FXML
	TextField nombreTextField;

	@FXML
	TextField descripcionTextField;

	@FXML
	RadioButton siRadioButton;

	@FXML
	RadioButton noRadioButton;

	@FXML
	ToggleGroup porPesoGroup;

	@FXML
	TextField precioTextField;

	@FXML
	TextField stockTextField;

	@FXML
	TextField descuentoTextField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void guardar() {
		if (nombreTextField.getText().equals("") || descripcionTextField.getText().equals("")
				|| porPesoGroup.getSelectedToggle() == null || precioTextField.getText().equals("")
				|| stockTextField.getText().equals("") || descuentoTextField.getText().equals("")) {
			new Alert(AlertType.ERROR, "¡Error! ¡Todos los campos son obligatorios!", ButtonType.OK).show();
			return;
		}

		if (noRadioButton.isSelected() && !UITools.checkParseInt(stockTextField.getText())) {
			new Alert(AlertType.ERROR,
					"¡Error! ¡Debes introducir una cantidad entera en stock si el producto no se vende por peso!",
					ButtonType.OK).show();
			return;
		}

		if (!UITools.checkParseFloat(precioTextField.getText().replace(',', '.')) || !UITools.checkParseFloat(stockTextField.getText().replace(',', '.'))
				|| !UITools.checkParseFloat(descuentoTextField.getText().replace(',', '.'))) {
			new Alert(AlertType.ERROR, "¡Error! ¡Debes introducir un valor numérico en precio, stock y descuento!",
					ButtonType.OK).show();
			return;
		}

		if (Float.parseFloat(descuentoTextField.getText().replace(',', '.')) > 100
				|| Float.parseFloat(descuentoTextField.getText().replace(',', '.')) < 0) {
			new Alert(AlertType.ERROR, "¡Error! ¡El descuento no puede ser mayor a 100 o negativo!", ButtonType.OK)
					.show();
			return;
		}

		Producto p = new Producto();
		p.setNombre(nombreTextField.getText());
		p.setDescripcion(descripcionTextField.getText());
		if (siRadioButton.isSelected()) {
			p.setVentaPorPeso(true);
		} else {
			p.setVentaPorPeso(false);
		}
		p.setPrecio(Float.parseFloat(precioTextField.getText().replace(',', '.')));
		p.setStock(Float.parseFloat(stockTextField.getText().replace(',', '.')));
		p.setDescuento(Float.parseFloat(descuentoTextField.getText().replace(',', '.')));
		p.setProveedor(Main.selectedProveedor);
		Main.selectedProveedor.getProductos().add(p);
		try {
			ProveedorManager.insertNewProduct(p);
		} catch (SQLException e) {
			new Alert(AlertType.ERROR, "¡Error! ¡Ha fallado la inserción en base de datos!", ButtonType.OK).show();
			e.printStackTrace();
		}
		
		((CreateNewStage)precioTextField.getScene().getWindow()).close();

	}

}
