package tools;

import java.text.DecimalFormat;
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
		tV.getSelectionModel().clearSelection();	
	}
	
	public static <T> ObservableList<T> deleteItemsReturnItems(TableView<T> tV){
		ObservableList<T> itemsToDelete = tV.getSelectionModel().getSelectedItems();
		tV.getItems().removeAll(itemsToDelete);	
		tV.getSelectionModel().clearSelection();	
		return itemsToDelete;
	}
	
	public static <T> T deleteItemReturnItem(TableView<T> tV){
		T itemToDelete = tV.getSelectionModel().getSelectedItem();
		tV.getItems().remove(itemToDelete);	
		tV.getSelectionModel().clearSelection();	
		return itemToDelete;
	}
	
	public static <T> void setColumnsEqualWidth(TableView<T> tv) {
		for(TableColumn<T, ?> column : tv.getColumns()) {
			column.setPrefWidth(tv.getPrefWidth() / tv.getColumns().size() - 0.5);
		}
	}
	
	public static ArrayList<ProductoAux> getListProductoAux(Pedido p){
		ProductoAux aux;
		double precio;
		double cantidad;
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
		double precio;
		double cantidad;
		ArrayList<ProductoAux> aLProductoAux = new ArrayList<ProductoAux>();
		
		for(Producto o : f.getProductos().keySet()) {
			cantidad = f.getProductos().get(o);
			precio = o.getPrecio() - (o.getPrecio() * (o.getDescuento() / 100d));
			aux = new ProductoAux(o.getNombre(), cantidad, cantidad * precio, o.getPrecio(), o.getDescuento());
			aLProductoAux.add(aux);
		}
		
		return aLProductoAux;
	}
	
	public static boolean checkParseInt(String text) {
		try {
			Integer.parseInt(text);
			return true;
		}catch(NumberFormatException ime) {
			return false;
		}
	}
	
	public static boolean checkParseDouble(String text) {
		try {
			Double.parseDouble(text);
			return true;
		}catch(NumberFormatException nfe) {
			return false;
		}
	}
	
	public static double recalculate(TableView<ProductoAux> tv) {
		double total = 0;
		for(ProductoAux p : tv.getItems()) {
			total = total + (p.getTotal());
		}
		return truncateDouble(total);
	}
	
	public static double truncateDouble(double num) {
		return Double.parseDouble(new DecimalFormat("#.##").format(num).replace(',', '.'));
	}
	
}
