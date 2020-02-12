package tools;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
		
	}
	
	public static <T> void setColumnsEqualWidth(TableView<T> tv) {
		for(TableColumn<T, ?> column : tv.getColumns()) {
			column.setPrefWidth(tv.getPrefWidth() / tv.getColumns().size() - 0.5);
		}
	}
	
}
