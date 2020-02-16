package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tools.CreateNewStage;

public class MenuBarController extends MenuBar {

	public static void addMenuBarToApp(BorderPane pane) {
		Menu archivo = new Menu("Archivo");
		MenuItem archivoNuevo;
		if (Main.selectedCliente != null) {
			archivoNuevo = new MenuItem("Nuevo pedido...");
		} else {
			archivoNuevo = new MenuItem("Nuevo producto...");
		}
		archivo.getItems().add(archivoNuevo);
		MenuBar menuBar = new MenuBar(archivo);
		pane.setTop(menuBar);
		addMenuEvent(archivoNuevo);
	}

	public static void clearMenuBar(BorderPane pane) {
		pane.setTop(null);
	}

	public static void addMenuEvent(MenuItem item) {
		item.setOnAction(e -> {
			if (Main.selectedCliente != null) {
				item.setText("Nuevo pedido...");

				Stage selectProveedor = new Stage();
				Parent root = null;
				try {
					root = FXMLLoader
							.load(MenuBarController.class.getResource("../others_fxml/DialogSelectProveedor.fxml"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				selectProveedor.initModality(Modality.WINDOW_MODAL);
				selectProveedor.initOwner(Main.mainStaticStage);
				Scene scene = new Scene(root, 400, 200);
				selectProveedor.setScene(scene);
				selectProveedor.show();

			} else {
				CreateNewStage newProduct = new CreateNewStage(CreateNewStage.PRODUCTO, Main.selectedProveedor);
				newProduct.initModality(Modality.WINDOW_MODAL);
				newProduct.initOwner(Main.mainStaticStage);
				newProduct.show();
			}
		});
	}

}
