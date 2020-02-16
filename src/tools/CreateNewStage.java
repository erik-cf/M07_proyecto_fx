package tools;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import performers.Proveedor;

public class CreateNewStage extends Stage {

	public static final int PRODUCTO = 0x00001f;
	public static final int PEDIDO = 0x00002f;
	public static final int USER = 0x00003f;
	
	private Proveedor proveedor;
	
	public CreateNewStage(int newPerformer, Proveedor proveedor) {
		this.proveedor = proveedor;
		Parent root = null;
		if(newPerformer == PRODUCTO) {
			try {
				
					root = FXMLLoader.load(getClass().getResource("../others_fxml/NewProductoStage.fxml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(newPerformer == PEDIDO) {
			try {
				root = FXMLLoader.load(getClass().getResource("../others_fxml/NewPedidoStage.fxml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(newPerformer == USER){
			try {
				root = FXMLLoader.load(getClass().getResource("../others_fxml/CreateNewClienteProveedor.fxml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			new Alert(AlertType.ERROR, "No se ha pasado un parametro correcto a la ventana CreateNewStage", ButtonType.OK).show();
			return;
		}
		Scene scene = new Scene(root);
		this.setScene(scene);
		
	}
	
	public Proveedor getProveedor() {
		return proveedor;
	}
	
}
