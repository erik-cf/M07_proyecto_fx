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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import performers.Cliente;
import performers.Pedido;
import performers.Producto;
import performers.Proveedor;
import tools.AuxStage;
import tools.UITools;

public class PedidoProveedorViewController implements Initializable{
	
	public static Pedido selectedPedido;
	
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

		TableColumn<Pedido, Float> importeBrutoPedidos = new TableColumn<Pedido, Float>("Importe Bruto");
		importeBrutoPedidos.setCellValueFactory(new PropertyValueFactory<Pedido, Float>("importeBruto"));

		TableColumn<Pedido, Float> importeNetoPedidos = new TableColumn<Pedido, Float>("Importe Neto");
		importeNetoPedidos.setCellValueFactory(new PropertyValueFactory<Pedido, Float>("importeNeto"));

		pedidoTableView.getColumns().setAll(idPedido, proveedorPedido, clientePedido, productosPedido, importeBrutoPedidos, importeNetoPedidos);

		pedidosData = FXCollections.observableList(Main.pedidos.stream()
				.filter(e -> e.getProveedor().equals(Main.selectedProveedor)).collect(Collectors.toList()));

		UITools.setColumnsEqualWidth(pedidoTableView);

		pedidoTableView.setItems(pedidosData);
	}
	
	public void deleteItems() {
		Pedido p;
		if((p = pedidoTableView.getSelectionModel().getSelectedItem()) != null) {
			try {
				ProveedorManager.deletePedido(pedidoTableView.getSelectionModel().getSelectedItem());
			} catch (SQLException e) {
				new Alert(AlertType.ERROR, "Error eliminando el pedido...", ButtonType.OK).show();
				e.printStackTrace();
			}
			p.getCliente().getPedidos().remove(p);
			Main.pedidos.remove(p);
			pedidoTableView.getItems().remove(p);
		}
	}
	
	
	public void detailPedido() {
		if((selectedPedido = pedidoTableView.getSelectionModel().getSelectedItem()) == null) {
			new Alert(AlertType.ERROR, "¡Debes seleccionar un elemento primero!", ButtonType.OK).show();
			return;
		}
		AuxStage<Producto> auxStage = new AuxStage(UITools.getListProductoAux(pedidoTableView.getSelectionModel().getSelectedItem()));
		auxStage.initModality(Modality.WINDOW_MODAL);
		auxStage.initOwner(pedidoTableView.getScene().getWindow());
		auxStage.show();
	}
	
	public void cobrarPedido() {
		Pedido p;
		if((p = pedidoTableView.getSelectionModel().getSelectedItem()) != null) {
			try {
				ProveedorManager.cobrarPedido(p);
			} catch (SQLException e) {
				new Alert(AlertType.ERROR, "Error cobrando el pedido...", ButtonType.OK).show();
				e.printStackTrace();
			}
			p.getCliente().getPedidos().remove(p);
			Main.pedidos.remove(p);
			pedidoTableView.getItems().remove(p);
		}
	}

	
}
