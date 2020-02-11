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
		
	}
	
	public ArrayList<T> getData() {
		return data;
	}

}
