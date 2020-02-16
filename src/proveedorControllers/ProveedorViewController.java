package proveedorControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.MenuBarController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import tools.UITools;

public class ProveedorViewController implements Initializable {
	
	public static final int CLIENTE = 0x00010f;
	public static final int PRODUCTO = 0x00011f;
	public static final int PEDIDO = 0x00012f;
	public static final int FACTURA = 0x00013f;
	public static final int INFORME = 0x00014f;
	public static final int CONFIGURACION = 0x00015f;
	public static final int INFORMACION = 0x00016f;

	@FXML
	Button buttonCliente;
	
	@FXML
	Button buttonProductos;
	
	@FXML
	Button buttonPedidos;
	
	@FXML
	Button buttonFacturas;
	
	@FXML
	Button buttonInformes;
	
	@FXML
	Button buttonConfiguracion;
	
	@FXML
	Button buttonInformacion;
	
	@FXML
	Button buttonCerrarSesion;

	@FXML
	Pane contentPane;
	
	Pane loaderPane;
	
	Button selectedButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		((BorderPane)Main.mainStaticStage.getScene().getRoot()).setOnContextMenuRequested(null);
		try {
			loaderPane = FXMLLoader.load(getClass().getResource("../proveedor_fxml/ClienteProveedorView.fxml"));
			contentPane.getChildren().add(loaderPane);
			UITools.prepareBackgrounds(buttonCliente, selectedButton);
			selectedButton = buttonCliente;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void clickOnClienteView() throws IOException {
		changeView(CLIENTE);
	}

	public void clickOnProductosView() throws IOException {
		changeView(PRODUCTO);
	}

	public void clickOnPedidosView() throws IOException {
		changeView(PEDIDO);
	}

	public void clickOnFacturasView() throws IOException {
		changeView(FACTURA);
	}

	public void clickOnInformesView() throws IOException {
		changeView(INFORME);
	}

	public void clickOnConfiguracionView() throws IOException {
		changeView(CONFIGURACION);
	}

	public void clickOnInformacionView() throws IOException {
		changeView(INFORMACION);
	}

	public void clickOnCerrarSesion() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../others_fxml/MainView.fxml"));
		BorderPane appMainPane = ((BorderPane)buttonCerrarSesion.getScene().getRoot());
		appMainPane.setCenter(root);
		MenuBarController.clearMenuBar(appMainPane);
	}
	
	public void changeView(int scene) throws IOException {
		switch (scene) {
		case CLIENTE:
			loaderPane = FXMLLoader.load(getClass().getResource("../proveedor_fxml/ClienteProveedorView.fxml"));
			UITools.prepareBackgrounds(buttonCliente, selectedButton);
			selectedButton = buttonCliente;
			break;
		case PRODUCTO:
			loaderPane = FXMLLoader.load(getClass().getResource("../proveedor_fxml/ProductoProveedorView.fxml"));
			UITools.prepareBackgrounds(buttonProductos, selectedButton);
			selectedButton = buttonProductos;
			break;
		case PEDIDO:
			loaderPane = FXMLLoader.load(getClass().getResource("../proveedor_fxml/PedidoProveedorView.fxml"));
			UITools.prepareBackgrounds(buttonPedidos, selectedButton);
			selectedButton = buttonPedidos;
			break;
		case FACTURA:
			loaderPane = FXMLLoader.load(getClass().getResource("../proveedor_fxml/FacturasProveedorView.fxml"));
			UITools.prepareBackgrounds(buttonFacturas, selectedButton);
			selectedButton = buttonFacturas;
			break;
		case INFORME:
			loaderPane = FXMLLoader.load(getClass().getResource("../proveedor_fxml/InformesProveedorView.fxml"));
			UITools.prepareBackgrounds(buttonInformes, selectedButton);
			selectedButton = buttonInformes;
			break;
		case CONFIGURACION:
			loaderPane = FXMLLoader.load(getClass().getResource("../proveedor_fxml/ConfiguracionProveedorView.fxml"));
			UITools.prepareBackgrounds(buttonConfiguracion, selectedButton);
			selectedButton = buttonConfiguracion;
			break;
		case INFORMACION:
			loaderPane = FXMLLoader.load(getClass().getResource("../proveedor_fxml/InformacionProveedorView.fxml"));
			UITools.prepareBackgrounds(buttonInformacion, selectedButton);
			selectedButton = buttonInformacion;
			break;
		}
		contentPane.getChildren().clear();
		contentPane.getChildren().add(loaderPane);
	}
	

}
