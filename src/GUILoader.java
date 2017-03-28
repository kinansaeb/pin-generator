

import java.io.IOException;
import java.util.logging.Logger;


import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GUILoader {
Logger log = Logger.getLogger(GUILoader.class.getName());
	
	public Stage primaryStage;
	
	public BorderPane rootLayout;
	
	main mainApp;
	
	
	
public void showStart() {
		
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(GUILoader.class.getResource("view/main.fxml"));
			
			AnchorPane login;
			login = (AnchorPane) loader.load();
		
			rootLayout.setCenter(login);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
