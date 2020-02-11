package application;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class MenuBarController {
	
	public static void addMenuBarToApp(BorderPane pane) {
		Menu archivo = new Menu("Archivo");
		MenuItem archivoAbrir = new MenuItem("Nuevo...");
		archivo.getItems().add(archivoAbrir);
		MenuBar menuBar = new MenuBar(archivo);
		pane.setTop(menuBar);
	}
	
	public static void clearMenuBar(BorderPane pane) {
		pane.setTop(null);
	}
	
}
