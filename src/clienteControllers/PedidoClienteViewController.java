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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import performers.Cliente;
import performers.Pedido;
import performers.ProductoAux;
import performers.Proveedor;
import tools.AuxStage;
import tools.UITools;

public class PedidoClienteViewController implements Initializable {

	@FXML
	TableView<Pedido> pedidoTableView;
	
	ObservableList<Pedido> pedidosData;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TableColumn<Pedido, Integer> idPedido = new TableColumn<Pedido, Integer>("id");
		idPedido.setCellValueFactory(new PropertyValueFactory<Pedido, Integer>("id"));
		
		TableColumn<Pedido, Proveedor> proveedorPedido = new TableColumn<Pedido, Proveedor>("Proveedor");
		proveedorPedido.setCellValueFactory(new PropertyValueFactory<Pedido, Proveedor>("proveedor"));
		
		TableColumn<Pedido, Cliente> clientePedido = new TableColumn<Pedido, Cliente>("Cliente");
		clientePedido.setCellValueFactory(new PropertyValueFactory<Pedido, Cliente>("cliente"));

		TableColumn<Pedido, Integer> productosPedido = new TableColumn<Pedido, Integer>("Num. Productos");
		productosPedido.setCellValueFactory(new PropertyValueFactory<Pedido, Integer>("countProductos"));

		TableColumn<Pedido, Double> importeBrutoPedidos = new TableColumn<Pedido, Double>("Importe Bruto");
		importeBrutoPedidos.setCellValueFactory(new PropertyValueFactory<Pedido, Double>("importeBruto"));

		TableColumn<Pedido, Double> importeNetoPedidos = new TableColumn<Pedido, Double>("Importe Neto");
		importeNetoPedidos.setCellValueFactory(new PropertyValueFactory<Pedido, Double>("importeNeto"));

		pedidoTableView.getColumns().setAll(idPedido, proveedorPedido, clientePedido, productosPedido, importeBrutoPedidos, importeNetoPedidos);

		pedidosData = FXCollections.observableList(Main.pedidos.stream()
				.filter(e -> e.getCliente().equals(Main.selectedCliente)).collect(Collectors.toList()));

		UITools.setColumnsEqualWidth(pedidoTableView);

		pedidoTableView.setItems(pedidosData);
	}
	
	public void detailPedido() {
		if(pedidoTableView.getSelectionModel().getSelectedItem() == null) {
			new Alert(AlertType.ERROR, "¡Debes seleccionar un elemento primero!", ButtonType.OK).show();
			return;
		}
		
		AuxStage<ProductoAux> auxStage = new AuxStage<ProductoAux>(UITools.getListProductoAux(pedidoTableView.getSelectionModel().getSelectedItem()));
		auxStage.initModality(Modality.WINDOW_MODAL);
		auxStage.initOwner(pedidoTableView.getScene().getWindow());
		auxStage.show();
	}

}
