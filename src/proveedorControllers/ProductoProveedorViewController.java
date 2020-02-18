package proveedorControllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import application.Main;
import bbdd_tools.ProveedorManager;
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
import performers.Producto;
import tools.UITools;

public class ProductoProveedorViewController implements Initializable {

	ObservableList<Producto> productosData;

	@FXML
	TableView<Producto> productosTableView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TableColumn<Producto, String> nombreProducto = new TableColumn<Producto, String>("nombre");
		nombreProducto.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombre"));

		TableColumn<Producto, Boolean> ventaPorPesoProducto = new TableColumn<Producto, Boolean>("¿Venta por peso?");
		ventaPorPesoProducto.setCellValueFactory(new PropertyValueFactory<Producto, Boolean>("ventaPorPeso"));

		TableColumn<Producto, Double> precioProducto = new TableColumn<Producto, Double>("precio");
		precioProducto.setCellValueFactory(new PropertyValueFactory<Producto, Double>("precio"));

		TableColumn<Producto, Double> stockProducto = new TableColumn<Producto, Double>("stock");
		stockProducto.setCellValueFactory(new PropertyValueFactory<Producto, Double>("stock"));

		TableColumn<Producto, Double> descuentoProducto = new TableColumn<Producto, Double>("descuento");
		descuentoProducto.setCellValueFactory(new PropertyValueFactory<Producto, Double>("descuento"));

		productosData = FXCollections.observableList(Main.selectedProveedor.getProductos());
		productosTableView.getColumns().addAll(nombreProducto, ventaPorPesoProducto, precioProducto, stockProducto,
				descuentoProducto);

		UITools.setColumnsEqualWidth(productosTableView);

		productosTableView.setItems(productosData);
		productosTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	}
	
	public void deleteItems() {
		ObservableList<Producto> itemsToDelete = productosTableView.getSelectionModel().getSelectedItems();
		if(productosTableView.getSelectionModel().getSelectedItem() == null) {
			new Alert(AlertType.ERROR, "¡Debes seleccionar un elemento primero!", ButtonType.OK).show();
			return;
		}
		
		
		try {
			ProveedorManager.deleteProduct(productosTableView.getSelectionModel().getSelectedItems());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		UITools.deleteItemsFromControl(productosTableView);
		Main.selectedProveedor.getProductos().removeAll(itemsToDelete);
		
	}

}
