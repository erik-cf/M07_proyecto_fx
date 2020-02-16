package proveedorControllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

		TableColumn<Producto, Float> precioProducto = new TableColumn<Producto, Float>("precio");
		precioProducto.setCellValueFactory(new PropertyValueFactory<Producto, Float>("precio"));

		TableColumn<Producto, Float> stockProducto = new TableColumn<Producto, Float>("stock");
		stockProducto.setCellValueFactory(new PropertyValueFactory<Producto, Float>("stock"));

		TableColumn<Producto, Float> descuentoProducto = new TableColumn<Producto, Float>("descuento");
		descuentoProducto.setCellValueFactory(new PropertyValueFactory<Producto, Float>("descuento"));

		productosData = FXCollections.observableList(Main.productos.stream()
				.filter(e -> e.getProveedor().equals(Main.selectedProveedor)).collect(Collectors.toList()));
		productosTableView.getColumns().addAll(nombreProducto, ventaPorPesoProducto, precioProducto, stockProducto,
				descuentoProducto);

		UITools.setColumnsEqualWidth(productosTableView);

		productosTableView.setItems(productosData);
		productosTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	}
	
	public void deleteItems() {
		UITools.deleteItemsFromControl(productosTableView);
	}

}
