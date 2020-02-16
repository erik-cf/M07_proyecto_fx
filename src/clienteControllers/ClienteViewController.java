package clienteControllers;

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

public class ClienteViewController implements Initializable {
	public static final int PROVEEDOR = 0x00020f;
	public static final int EXPLORAR = 0x00021f;
	public static final int PEDIDO = 0x00022f;
	public static final int FACTURA = 0x00023f;
	public static final int INFORME = 0x00024f;
	public static final int CONFIGURACION = 0x00025f;
	public static final int INFORMACION = 0x00026f;

	@FXML
	Button buttonProveedor;
	
	@FXML
	Button buttonExplorar;
	
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
	public static Pane contentPaneStatic;
	
	Pane loaderPane;
	public static Pane loaderPaneStatic;
	
	Button selectedButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		((BorderPane)Main.mainStaticStage.getScene().getRoot()).setOnContextMenuRequested(null);
		try {
			loaderPane = FXMLLoader.load(getClass().getResource("../cliente_fxml/ProveedorClienteView.fxml"));
			contentPane.getChildren().add(loaderPane);
			UITools.prepareBackgrounds(buttonProveedor, selectedButton);
			selectedButton = buttonProveedor;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void clickOnProveedorView() throws IOException {
		changeView(PROVEEDOR);
	}

	public void clickOnExplorarView() throws IOException {
		changeView(EXPLORAR);
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
		case PROVEEDOR:
			loaderPane = FXMLLoader.load(getClass().getResource("../cliente_fxml/ProveedorClienteView.fxml"));
			UITools.prepareBackgrounds(buttonProveedor, selectedButton);
			selectedButton = buttonProveedor;
			break;
		case EXPLORAR:
			loaderPane = FXMLLoader.load(getClass().getResource("../cliente_fxml/ExplorarClienteView.fxml"));
			UITools.prepareBackgrounds(buttonExplorar, selectedButton);
			selectedButton = buttonExplorar;
			break;
		case PEDIDO:
			loaderPane = FXMLLoader.load(getClass().getResource("../cliente_fxml/PedidoClienteView.fxml"));
			UITools.prepareBackgrounds(buttonPedidos, selectedButton);
			selectedButton = buttonPedidos;
			break;
		case FACTURA:
			loaderPane = FXMLLoader.load(getClass().getResource("../cliente_fxml/FacturasClienteView.fxml"));
			UITools.prepareBackgrounds(buttonFacturas, selectedButton);
			selectedButton = buttonFacturas;
			break;
		case INFORME:
			loaderPane = FXMLLoader.load(getClass().getResource("../cliente_fxml/InformesClienteView.fxml"));
			UITools.prepareBackgrounds(buttonInformes, selectedButton);
			selectedButton = buttonInformes;
			break;
		case CONFIGURACION:
			loaderPane = FXMLLoader.load(getClass().getResource("../cliente_fxml/ConfiguracionClienteView.fxml"));
			UITools.prepareBackgrounds(buttonConfiguracion, selectedButton);
			selectedButton = buttonConfiguracion;
			break;
		case INFORMACION:
			loaderPane = FXMLLoader.load(getClass().getResource("../cliente_fxml/InformacionClienteView.fxml"));
			UITools.prepareBackgrounds(buttonInformacion, selectedButton);
			selectedButton = buttonInformacion;
			break;
		}
		loaderPaneStatic = loaderPane;
		contentPaneStatic = contentPane;
		contentPane.getChildren().clear();
		contentPane.getChildren().add(loaderPane);
	}
}
