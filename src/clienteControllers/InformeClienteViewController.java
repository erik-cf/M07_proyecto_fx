package clienteControllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import tools.ReportViewer;

public class InformeClienteViewController implements Initializable{
	@FXML
	ListView<String> informeListView;
	
	ObservableList<String> dataListView = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dataListView.add(Main.CLIENTETOTALGASTADOMESES);
		informeListView.setItems(dataListView);
		informeListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}
	
	public void showReport() {
		try{
			switch(informeListView.getSelectionModel().getSelectedItem()) {
		
		case Main.CLIENTETOTALGASTADOMESES:
			ReportViewer.showTotalPorMesesReport(Main.CLIENTETOTALGASTADOMESES);
			break;
		}
		}catch(Exception e) {
			System.out.println("Error mostrando reporte");
			e.printStackTrace();
		}
	}
}
