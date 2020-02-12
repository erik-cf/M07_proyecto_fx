package application;
	
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public static ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	public static ArrayList<Factura> facturas = new ArrayList<Factura>();
	public static ArrayList<Producto> productos = new ArrayList<Producto>();
	public static Proveedor selectedProveedor;
	public static Cliente selectedCliente;
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			Initializer.fillMainArrays();
		} catch (Exception e) {
			String error = "No se ha podido conectar a la base de datos!\n\n"
					+ "Debes importar los datos de la aplicaci�n que se encuentran en el archivo proyecto_fxSQL.sql a tu servidor.\n\n"
					+ "Adem�s, debes configurar la conexi�n en la interfaz que se encuentra en bbdd_tools.ConnectionInterface.java\n"
					+ "(Revisar constantes USER y PASSWORD)";
			Alert falloConexionMySQL = new Alert(AlertType.ERROR, error, ButtonType.OK);
			falloConexionMySQL.setTitle("�Error de conexi�n!");
			falloConexionMySQL.show();
			return;
		}
		
		try {
			BorderPane mainPane = new BorderPane();
			
			Parent root = FXMLLoader.load(getClass().getResource("../others_fxml/MainView.fxml"));
			mainPane.setCenter(root);
			
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