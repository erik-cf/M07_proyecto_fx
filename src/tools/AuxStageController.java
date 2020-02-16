package tools;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import performers.*;

public class AuxStageController implements Initializable {

	@FXML
	TableView auxTableView;

	@FXML
	ListView auxListView;

	ArrayList dataArrayList;


	AuxStage stage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				stage = ((AuxStage) auxTableView.getScene().getWindow());
				dataArrayList = stage.getDataArrayList();
				if (dataArrayList != null && dataArrayList.size() > 0) {
					if (dataArrayList.get(0).getClass().equals(Cliente.class)) {
						auxTableView.setDisable(true);
						auxTableView.setVisible(false);
						fillListView();
					} else {
						auxListView.setDisable(true);
						auxListView.setVisible(false);
						fillTableView();
						UITools.setColumnsEqualWidth(auxTableView);
					}
				}
			}
		});
	}

	private void fillListView() {
		auxListView.setItems(FXCollections.observableArrayList(dataArrayList));
		auxListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}

	private void fillTableView() {
		if (dataArrayList.size() > 0) {
			if (dataArrayList.get(0).getClass().equals(Pedido.class)) {
				TableColumn<Pedido, Integer> idPedido = new TableColumn<Pedido, Integer>("id");
				idPedido.setCellValueFactory(new PropertyValueFactory<Pedido, Integer>("id"));

				TableColumn<Pedido, Integer> productosPedido = new TableColumn<Pedido, Integer>("Num. Productos");
				productosPedido.setCellValueFactory(new PropertyValueFactory<Pedido, Integer>("countProductos"));

				TableColumn<Pedido, Float> importeBrutoPedidos = new TableColumn<Pedido, Float>("Importe Bruto");
				importeBrutoPedidos.setCellValueFactory(new PropertyValueFactory<Pedido, Float>("importeBruto"));

				TableColumn<Pedido, Float> importeNetoPedidos = new TableColumn<Pedido, Float>("Importe Neto");
				importeNetoPedidos.setCellValueFactory(new PropertyValueFactory<Pedido, Float>("importeNeto"));

				auxTableView.getColumns().setAll(idPedido, productosPedido, importeBrutoPedidos, importeNetoPedidos);
			} else if (dataArrayList.get(0).getClass().equals(Factura.class)) {
				TableColumn<Factura, Integer> idFactura = new TableColumn<Factura, Integer>("id");
				idFactura.setCellValueFactory(new PropertyValueFactory<Factura, Integer>("id"));

				TableColumn<Factura, Integer> productosFactura = new TableColumn<Factura, Integer>("Num. Productos");
				productosFactura.setCellValueFactory(new PropertyValueFactory<Factura, Integer>("countProductos"));

				auxTableView.getColumns().setAll(idFactura, productosFactura);
			} else if (dataArrayList.get(0).getClass().equals(Proveedor.class)) {
				TableColumn<Proveedor, Integer> idProveedor = new TableColumn<Proveedor, Integer>("id");
				idProveedor.setCellValueFactory(new PropertyValueFactory<Proveedor, Integer>("id"));

				TableColumn<Proveedor, String> nombreProveedor = new TableColumn<Proveedor, String>("nombre");
				nombreProveedor.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("nombre"));

				TableColumn<Proveedor, String> familiaProveedor = new TableColumn<Proveedor, String>("familia");
				familiaProveedor.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("familia"));

				auxTableView.getColumns().setAll(idProveedor, nombreProveedor, familiaProveedor);
			} else if (dataArrayList.get(0).getClass().equals(Producto.class)) {
				TableColumn<Producto, String> nombreProducto = new TableColumn<Producto, String>("nombre");
				nombreProducto.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombre"));

				TableColumn<Producto, Boolean> ventaPorPesoProducto = new TableColumn<Producto, Boolean>(
						"¿Venta por peso?");
				ventaPorPesoProducto.setCellValueFactory(new PropertyValueFactory<Producto, Boolean>("ventaPorPeso"));

				TableColumn<Producto, Float> precioProducto = new TableColumn<Producto, Float>("precio");
				precioProducto.setCellValueFactory(new PropertyValueFactory<Producto, Float>("precio"));

				TableColumn<Producto, Float> stockProducto = new TableColumn<Producto, Float>("stock");
				stockProducto.setCellValueFactory(new PropertyValueFactory<Producto, Float>("stock"));

				TableColumn<Producto, Float> descuentoProducto = new TableColumn<Producto, Float>("descuento");
				descuentoProducto.setCellValueFactory(new PropertyValueFactory<Producto, Float>("descuento"));

				TableColumn<Producto, String> proveedorProducto = new TableColumn<Producto, String>("proveedor");
				proveedorProducto.setCellValueFactory(new PropertyValueFactory<Producto, String>("proveedor"));

				auxTableView.getColumns().setAll(nombreProducto, ventaPorPesoProducto, precioProducto, stockProducto,
						descuentoProducto, proveedorProducto);
			}else if (dataArrayList.get(0).getClass().equals(ProductoAux.class)) {
				TableColumn<ProductoAux, String> nombreProductoAux = new TableColumn<ProductoAux, String>("nombre");
				nombreProductoAux.setCellValueFactory(new PropertyValueFactory<ProductoAux, String>("nombre"));
				
				TableColumn<ProductoAux, Float> cantidadProductoAux = new TableColumn<ProductoAux, Float>("cantidad");
				cantidadProductoAux.setCellValueFactory(new PropertyValueFactory<ProductoAux, Float>("cantidad"));

				TableColumn<ProductoAux, Float> precioProductoAux = new TableColumn<ProductoAux, Float>("precio");
				precioProductoAux.setCellValueFactory(new PropertyValueFactory<ProductoAux, Float>("precio"));
				
				TableColumn<ProductoAux, Float> descuentoProductoAux = new TableColumn<ProductoAux, Float>("descuento");
				descuentoProductoAux.setCellValueFactory(new PropertyValueFactory<ProductoAux, Float>("descuento"));

				TableColumn<ProductoAux, String> totalProductoAux = new TableColumn<ProductoAux, String>("total");
				totalProductoAux.setCellValueFactory(new PropertyValueFactory<ProductoAux, String>("total"));

				auxTableView.getColumns().setAll(nombreProductoAux, precioProductoAux, cantidadProductoAux,
						descuentoProductoAux, totalProductoAux);
			}

			auxTableView.setItems(FXCollections.observableArrayList(dataArrayList));
		}
	}

	public void closeAction() {
		stage.close();
		
	}

}
