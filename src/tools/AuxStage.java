package tools;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AuxStage<T> extends Stage {
	
	public ArrayList<T> data;
	
	public AuxStage(ArrayList<T> data) {
		this.data = data;
		Parent root = null;
		try {
			
			root = FXMLLoader.load(getClass().getResource("../others_fxml/AuxStage.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root,700,600);
		this.setScene(scene);
	}
	
	public ArrayList<T> getData() {
		return data;
	}

}
