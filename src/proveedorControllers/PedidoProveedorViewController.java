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
import performers.Pedido;
import tools.UITools;

public class PedidoProveedorViewController implements Initializable{
	
	@FXML
	TableView<Pedido> pedidoTableView;
	
	ObservableList<Pedido> pedidosData;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TableColumn<Pedido, Integer> idPedido = new TableColumn<Pedido, Integer>("id");
		idPedido.setCellValueFactory(new PropertyValueFactory<Pedido, Integer>("id"));

		TableColumn<Pedido, Integer> productosPedido = new TableColumn<Pedido, Integer>("Num. Productos");
		productosPedido.setCellValueFactory(new PropertyValueFactory<Pedido, Integer>("countProductos"));

		TableColumn<Pedido, Float> importeBrutoPedidos = new TableColumn<Pedido, Float>("Importe Bruto");
		importeBrutoPedidos.setCellValueFactory(new PropertyValueFactory<Pedido, Float>("importeBruto"));

		TableColumn<Pedido, Float> importeNetoPedidos = new TableColumn<Pedido, Float>("Importe Neto");
		importeNetoPedidos.setCellValueFactory(new PropertyValueFactory<Pedido, Float>("importeNeto"));

		pedidoTableView.getColumns().setAll(idPedido, productosPedido, importeBrutoPedidos, importeNetoPedidos);

		pedidosData = FXCollections.observableList(Main.pedidos.stream()
				.filter(e -> e.getProveedor().equals(Main.selectedProveedor)).collect(Collectors.toList()));

		UITools.setColumnsEqualWidth(pedidoTableView);

		pedidoTableView.setItems(pedidosData);
		pedidoTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
	
	public void deleteItems() {
		UITools.deleteItemsFromControl(pedidoTableView);
	}
	
	public void detailPedido() {
		
	}

	
}
