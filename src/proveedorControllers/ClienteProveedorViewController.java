package proveedorControllers;

import java.awt.List;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import application.Main;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import performers.Cliente;
import tools.AuxStage;
import tools.UITools;

public class ClienteProveedorViewController implements Initializable {
	
	ObservableList<Cliente> dataClientes;
	
	@FXML
	ListView<Cliente> clientesListView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/*TableColumn<Cliente, Integer> idCliente = new TableColumn<Cliente, Integer>("id");
        idCliente.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("id"));
        TableColumn<Cliente, String> nombreCliente = new TableColumn<Cliente, String>("nombre");
        nombreCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
        
        clientesTableView.getColumns().setAll(idCliente, nombreCliente);
        

        clientesTableView.setItems(dataClientes);*/
		dataClientes = FXCollections.observableList(Main.clientes.stream()
				.filter(e -> e.getProveedores().contains(Main.selectedProveedor))
				.collect(Collectors.toList()));
		//dataClientes = FXCollections.observableList(Main.clientes);
		clientesListView.setItems(dataClientes);
		clientesListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
	
	public void deleteSelectedItems() {
		UITools.deleteItemsFromControl(clientesListView);	
	}
	
	public void showPedidos() {
		AuxStage<Cliente> auxstage = new AuxStage<Cliente>(Main.clientes);
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("../others_fxml/AuxStage.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//this.initModality(Modality.WINDOW_MODAL);
		//this.initOwner(owner);
		Scene scene = new Scene(root,400,600);
		auxstage.setScene(scene);
		auxstage.show();
	}
	
	

}
