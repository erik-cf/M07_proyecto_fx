package application;
	
import java.util.ArrayList;
import java.util.Optional;

import bbdd_tools.Initializer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import performers.*;
import tools.UITools;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	// TODO Informes
	public static ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	public static ArrayList<Factura> facturas = new ArrayList<Factura>();
	public static ArrayList<Producto> productos = new ArrayList<Producto>();
	public static Proveedor selectedProveedor;
	public static Cliente selectedCliente;
	public static Stage mainStaticStage;
	
	@Override
	public void start(Stage primaryStage) {
		mainStaticStage = primaryStage;
		primaryStage.setOnCloseRequest(value -> {
			Alert a = new Alert(AlertType.CONFIRMATION, "Estás seguro que quieres salir?", ButtonType.OK, ButtonType.CANCEL);
			a.setTitle("Salir");
			a.setHeaderText("Confirmar salida");
			Optional<ButtonType> result = a.showAndWait();
			if(result.get().equals(ButtonType.OK)) {
				primaryStage.close();
			}else {
				a.close();
				value.consume();
			}			
		});
		
		try {
			Initializer.fillMainArrays();
		} catch (Exception e) {
			String error = "No se ha podido conectar a la base de datos!\n\n"
					+ "Asegurate de importar los datos de la aplicación que se encuentran en el archivo proyecto_fx_data.sql a tu servidor.\n\n"
					+ "Además, asegurate de configurar la conexión en la interfaz que se encuentra en bbdd_tools.ConnectionInterface.java\n"
					+ "(Revisar constantes USER y PASSWORD)";
			Alert falloConexionMySQL = new Alert(AlertType.ERROR, error, ButtonType.OK);
			falloConexionMySQL.setTitle("¡Error de conexión!");
			falloConexionMySQL.show();
			return;
		}
		
		try {
			BorderPane mainPane = new BorderPane();
			
			Parent root = FXMLLoader.load(getClass().getResource("../others_fxml/MainView.fxml"));
			
			mainPane.setCenter(root);
			mainPane.getStyleClass().add("borderpane");
			Scene scene = new Scene(mainPane,1000,768);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
