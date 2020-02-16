package tools;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import bbdd_tools.ProveedorManager;
import clienteControllers.ClienteViewController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import performers.Pedido;
import performers.Producto;
import performers.ProductoAux;
import performers.Proveedor;

public class CreateNewPedidoController implements Initializable {
	@FXML
	ChoiceBox<Producto> productChoiceBox;

	ObservableList<Producto> dataChoiceBox;

	ObservableList<ProductoAux> dataTableView;

	@FXML
	TextField quantityTextField;

	@FXML
	TableView<ProductoAux> pedidoTableView;

	@FXML
	Label brutoLabel;

	@FXML
	Label netoLabel;

	Pedido newPedido;

	Proveedor proveedor;
	
	float brutoTotal;
	float netoTotal;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		newPedido = new Pedido();
		dataTableView = FXCollections.observableArrayList();

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				proveedor = ((CreateNewStage) productChoiceBox.getScene().getWindow()).getProveedor();
				ArrayList<Producto> dataArray = proveedor.getProductos();
				dataChoiceBox = FXCollections.observableArrayList(dataArray);
				productChoiceBox.setItems(dataChoiceBox);
			}
		});

		TableColumn<ProductoAux, String> nombreProductoAux = new TableColumn<ProductoAux, String>("nombre");
		nombreProductoAux.setCellValueFactory(new PropertyValueFactory<ProductoAux, String>("nombre"));

		TableColumn<ProductoAux, Float> cantidadProductoAux = new TableColumn<ProductoAux, Float>("cantidad");
		cantidadProductoAux.setCellValueFactory(new PropertyValueFactory<ProductoAux, Float>("cantidad"));

		TableColumn<ProductoAux, Float> precioProductoAux = new TableColumn<ProductoAux, Float>("precio");
		precioProductoAux.setCellValueFactory(new PropertyValueFactory<ProductoAux, Float>("precio"));

		TableColumn<ProductoAux, Float> descuentoProductoAux = new TableColumn<ProductoAux, Float>("descuento");
		descuentoProductoAux.setCellValueFactory(new PropertyValueFactory<ProductoAux, Float>("descuento"));

		TableColumn<ProductoAux, String> proveedorProductoAux = new TableColumn<ProductoAux, String>("total");
		proveedorProductoAux.setCellValueFactory(new PropertyValueFactory<ProductoAux, String>("total"));

		pedidoTableView.getColumns().setAll(nombreProductoAux, precioProductoAux, cantidadProductoAux,
				descuentoProductoAux, proveedorProductoAux);
		
		UITools.setColumnsEqualWidth(pedidoTableView);

		pedidoTableView.setItems(dataTableView);
	}

	public void addProduct() {
		Producto productToAdd = null; 
		if (productChoiceBox.getSelectionModel().isEmpty()) {
			new Alert(AlertType.ERROR, "¡Error! ¡Debes seleccionar un producto!", ButtonType.OK).show();
			return;
		}else {
			productToAdd = productChoiceBox.getSelectionModel().getSelectedItem();
		}

		if (quantityTextField.getText().equals("")) {
			new Alert(AlertType.ERROR, "¡Error! ¡Debes introducir una cantidad!", ButtonType.OK).show();
			return;
		}

		if (!productToAdd.isVentaPorPeso()
				&& !UITools.checkParseInt(quantityTextField.getText().replace(',', '.'))) {
			new Alert(AlertType.ERROR,
					"¡Error! ¡La cantidad de este producto es unitaria, solo se aceptan numeros enteros!",
					ButtonType.OK).show();
			return;
		}

		if (productToAdd.isVentaPorPeso()
				&& !UITools.checkParseFloat(quantityTextField.getText().replace(',', '.'))) {
			new Alert(AlertType.ERROR, "¡Error! ¡Debes introducir un número (decimales aceptados)!", ButtonType.OK)
					.show();
			return;
		}

		ProductoAux pAux = AuxTools.createProductoAux(productToAdd, Float.parseFloat(quantityTextField.getText().replace(',', '.')));

		pedidoTableView.getItems().add(pAux);

		brutoTotal = Float.parseFloat(brutoLabel.getText()) + pAux.getTotal();
		netoTotal = brutoTotal + (brutoTotal * 0.1f);

		brutoLabel.setText(String.valueOf(brutoTotal));

		netoLabel.setText(String.valueOf(netoTotal));

		productChoiceBox.getItems().remove(productToAdd);
		
		newPedido.getProductos().put(productToAdd, pAux.getCantidad());
		
		quantityTextField.clear();

	}

	public void deleteItems() {
		if (pedidoTableView.getSelectionModel().getSelectedItem() != null) {
			ProductoAux itemDeleted = UITools.deleteItemReturnItem(pedidoTableView);
			productChoiceBox.getItems().add(SearchTools.getProductoByAux(itemDeleted));

			brutoTotal = UITools.recalculate(pedidoTableView);
			netoTotal = brutoTotal + (brutoTotal * 0.1f);
			brutoLabel.setText(String.valueOf(brutoTotal));
			netoLabel.setText(String.valueOf(netoTotal));
		}

	}

	public void completarPedido() {
		newPedido.setCliente(Main.selectedCliente);
		newPedido.setProveedor(proveedor);
		newPedido.setFecha(new Date(System.currentTimeMillis()));
		newPedido.setImporteBruto(brutoTotal);
		newPedido.setImporteNeto(netoTotal);
		newPedido.setCountProductos(newPedido.getProductos().size());
		try {
			ProveedorManager.insertPedido(newPedido);
		} catch (SQLException e) {
			e.printStackTrace();
			new Alert(AlertType.ERROR, "Error en la inserción del pedido en la base de datos...", ButtonType.OK).show();
		}
		Main.pedidos.add(newPedido);
		Main.selectedCliente.getPedidos().add(newPedido);
		((CreateNewStage)productChoiceBox.getScene().getWindow()).close();
		try {
			ClienteViewController.loaderPaneStatic = FXMLLoader.load(getClass().getResource("../cliente_fxml/PedidoClienteView.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ClienteViewController.contentPaneStatic.getChildren().clear();
		ClienteViewController.contentPaneStatic.getChildren().add(ClienteViewController.loaderPaneStatic);
		
	}
}
