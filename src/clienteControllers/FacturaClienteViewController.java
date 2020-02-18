package clienteControllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import performers.Factura;
import performers.ProductoAux;
import tools.AuxStage;
import tools.UITools;

public class FacturaClienteViewController implements Initializable {
	@FXML
	TableView<Factura> facturaTableView;
	
	ObservableList<Factura> pedidosData;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TableColumn<Factura, Integer> idPedido = new TableColumn<Factura, Integer>("id");
		idPedido.setCellValueFactory(new PropertyValueFactory<Factura, Integer>("id"));

		TableColumn<Factura, Integer> productosPedido = new TableColumn<Factura, Integer>("Num. Productos");
		productosPedido.setCellValueFactory(new PropertyValueFactory<Factura, Integer>("countProductos"));

		TableColumn<Factura, Double> importeBrutoPedidos = new TableColumn<Factura, Double>("Importe Bruto");
		importeBrutoPedidos.setCellValueFactory(new PropertyValueFactory<Factura, Double>("importeBruto"));

		TableColumn<Factura, Double> importeNetoPedidos = new TableColumn<Factura, Double>("Importe Neto");
		importeNetoPedidos.setCellValueFactory(new PropertyValueFactory<Factura, Double>("importeNeto"));

		facturaTableView.getColumns().setAll(idPedido, productosPedido, importeBrutoPedidos, importeNetoPedidos);

		pedidosData = FXCollections.observableList(Main.facturas.stream()
				.filter(e -> e.getCliente().equals(Main.selectedCliente)).collect(Collectors.toList()));

		UITools.setColumnsEqualWidth(facturaTableView);

		facturaTableView.setItems(pedidosData);
		facturaTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
	
	public void detailFactura() {
		if(facturaTableView.getSelectionModel().getSelectedItem() == null) {
			new Alert(AlertType.ERROR, "¡Debes seleccionar un elemento primero!", ButtonType.OK).show();
			return;
		}
		
		AuxStage<ProductoAux> auxStage = new AuxStage<ProductoAux>(UITools.getListProductoAux(facturaTableView.getSelectionModel().getSelectedItem()));
		auxStage.initModality(Modality.WINDOW_MODAL);
		auxStage.initOwner(facturaTableView.getScene().getWindow());
		auxStage.show();
	}
}
