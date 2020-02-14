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
import javafx.stage.Modality;
import performers.Factura;
import performers.Producto;
import tools.AuxStage;
import tools.UITools;

public class FacturaProveedorViewController implements Initializable{
	@FXML
	TableView<Factura> facturaTableView;
	
	ObservableList<Factura> pedidosData;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TableColumn<Factura, Integer> idPedido = new TableColumn<Factura, Integer>("id");
		idPedido.setCellValueFactory(new PropertyValueFactory<Factura, Integer>("id"));

		TableColumn<Factura, Integer> productosPedido = new TableColumn<Factura, Integer>("Num. Productos");
		productosPedido.setCellValueFactory(new PropertyValueFactory<Factura, Integer>("countProductos"));

		TableColumn<Factura, Float> importeBrutoPedidos = new TableColumn<Factura, Float>("Importe Bruto");
		importeBrutoPedidos.setCellValueFactory(new PropertyValueFactory<Factura, Float>("importeBruto"));

		TableColumn<Factura, Float> importeNetoPedidos = new TableColumn<Factura, Float>("Importe Neto");
		importeNetoPedidos.setCellValueFactory(new PropertyValueFactory<Factura, Float>("importeNeto"));

		facturaTableView.getColumns().setAll(idPedido, productosPedido, importeBrutoPedidos, importeNetoPedidos);

		pedidosData = FXCollections.observableList(Main.facturas.stream()
				.filter(e -> e.getProveedor().equals(Main.selectedProveedor)).collect(Collectors.toList()));

		UITools.setColumnsEqualWidth(facturaTableView);

		facturaTableView.setItems(pedidosData);
		facturaTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
	
	public void detailFactura() {
		AuxStage<Producto> auxStage = new AuxStage(UITools.getListProductoAux(facturaTableView.getSelectionModel().getSelectedItem()));
		auxStage.initModality(Modality.WINDOW_MODAL);
		auxStage.initOwner(facturaTableView.getScene().getWindow());
		auxStage.show();
	}

	
}
