package tools;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import performers.*;

public class AuxStageController implements Initializable {
	
	@FXML
	TableView auxTableView;
	
	@FXML
	ListView auxListView;
	
	ArrayList data;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		data = ((AuxStage)auxTableView.getScene().getWindow()).getData();
		
		if(data.size() > 0) {
			if(data.get(0).getClass().equals(Cliente.class)){
				auxTableView.setDisable(true);
				auxTableView.setVisible(false);
				fillListView();
			}else {
				auxListView.setDisable(true);
				auxListView.setVisible(false);
				fillListView();
			}
		}
		
	}
	
	private void fillListView() {
		auxListView.setItems(FXCollections.observableArrayList(data));
		auxListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}
	
	private void fillTableView() {
		
	}

}
