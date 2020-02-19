package application;
	
import java.util.ArrayList;
import java.util.Optional;

import bbdd_tools.Initializer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import performers.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

	// Constantes que definen el nombre de los informes
	public static final String PROVTOTALFACTPORMESES = "Total facturado por meses";
	public static final String CLIENTETOTALGASTADOMESES = "Total gastado por meses";
	
	// ArrayLists de cada uno de los actores del proyecto
	public static ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	public static ArrayList<Factura> facturas = new ArrayList<Factura>();
	public static ArrayList<Producto> productos = new ArrayList<Producto>();

	// Estáticos donde guardaremos objetos de uso común en todo el proyecto:
	public static Proveedor selectedProveedor;
	public static Cliente selectedCliente;
	public static Stage mainStaticStage;
	
	@Override
	public void start(Stage primaryStage) {
		// Asignamos el main Stage
		mainStaticStage = primaryStage;
		
		// Al cerrar pedimos una confirmacion con una alerta:
		primaryStage.setOnCloseRequest(value -> {
			// Creamos la alerta
			Alert a = new Alert(AlertType.CONFIRMATION, "Estás seguro que quieres salir?", ButtonType.OK, ButtonType.CANCEL);
			a.setTitle("Salir");
			a.setHeaderText("Confirmar salida");
			// Mostramos la alerta y esperamos el resultado:
			Optional<ButtonType> result = a.showAndWait();
			
			// Si pulsan OK, cerramos:
			if(result.get().equals(ButtonType.OK)) {
				primaryStage.close();
			}else {
				a.close();
				value.consume();
			}			
		});
		
		try {
			// Inicializamos con los datos de la base de datos:
			Initializer.fillMainArrays();
		} catch (Exception e) {
			// Si no conecta con la BD, mostramos un error y las acciones a realizar:
			String error = "No se ha podido conectar a la base de datos!\n\n"
					+ "Asegurate de importar los datos de la aplicación que se encuentran en el archivo proyecto_fx_data.sql a tu servidor.\n\n"
					+ "Además, asegurate de configurar la conexión en la interfaz que se encuentra en bbdd_tools.ConnectionInterface.java\n"
					+ "(Revisar constantes USER y PASSWORD)";
			// Mostramos la alerta:
			Alert falloConexionMySQL = new Alert(AlertType.ERROR, error, ButtonType.OK);
			falloConexionMySQL.setTitle("¡Error de conexión!");
			falloConexionMySQL.show();
			
			// Salimos
			return;
		}
		
		try {
			// Dejaremos los componentes en un borderpane principal:
			BorderPane mainPane = new BorderPane();
			
			// Creamos el root y cargamos la mainView (login)
			Parent root = FXMLLoader.load(getClass().getResource("../others_fxml/MainView.fxml"));
			
			// Añadimos el root al mainPane
			mainPane.setCenter(root);
			
			// Le damos una clase de css al borderpane:
			mainPane.getStyleClass().add("borderpane");
			
			// Dejamos una ventana de 1000x768
			Scene scene = new Scene(mainPane,1000,768);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// Le damos una escena a la ventana
			primaryStage.setScene(scene);
			primaryStage.show();
	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}
	

}
