package tools;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import performers.Factura;
import performers.Pedido;
import performers.Producto;
import performers.ProductoAux;

public class UITools {
	public static void prepareBackgrounds(Button set, Button clear) {
		if(clear != null)
			clear.setStyle("");
		set.setStyle("-fx-background-color: rgba(30, 30, 30, 0.5);");
	}
	
	public static void fillTableViewWithSQL(String sql) {
		
	}
	
	public static <T> void deleteItemsFromControl(ListView<T> lv) {
		ObservableList<T> itemsToDelete = lv.getSelectionModel().getSelectedItems();
		lv.getItems().removeAll(itemsToDelete);	
		lv.getSelectionModel().clearSelection();
	}
	
	public static <T> void deleteItemsFromControl(TableView<T> tV) {
		ObservableList<T> itemsToDelete = tV.getSelectionModel().getSelectedItems();
		tV.getItems().removeAll(itemsToDelete);	
		tV.getSelectionModel().clearSelection();	}
	
	public static <T> void setColumnsEqualWidth(TableView<T> tv) {
		for(TableColumn<T, ?> column : tv.getColumns()) {
			column.setPrefWidth(tv.getPrefWidth() / tv.getColumns().size() - 0.5);
		}
	}
	
	public static ArrayList<ProductoAux> getListProductoAux(Pedido p){
		ProductoAux aux;
		float precio;
		float cantidad;
		ArrayList<ProductoAux> aLProductoAux = new ArrayList<ProductoAux>();
		
		for(Producto o : p.getProductos().keySet()) {
			cantidad = p.getProductos().get(o);
			precio = o.getPrecio() - (o.getPrecio() * (o.getDescuento() / 100));
			aux = new ProductoAux(o.getNombre(), cantidad, cantidad * precio, o.getPrecio(), o.getDescuento());
			aLProductoAux.add(aux);
		}
		
		return aLProductoAux;
	}
	
	public static ArrayList<ProductoAux> getListProductoAux(Factura f){
		ProductoAux aux;
		float precio;
		float cantidad;
		ArrayList<ProductoAux> aLProductoAux = new ArrayList<ProductoAux>();
		
		for(Producto o : f.getProductos().keySet()) {
			cantidad = f.getProductos().get(o);
			precio = o.getPrecio() - (o.getPrecio() * (o.getDescuento() / 100));
			aux = new ProductoAux(o.getNombre(), cantidad, cantidad * precio, o.getPrecio(), o.getDescuento());
			aLProductoAux.add(aux);
		}
		
		return aLProductoAux;
	}
	
}
