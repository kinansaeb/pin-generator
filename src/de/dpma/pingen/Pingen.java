package de.dpma.pingen;

import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Pingen extends Application {
	public static Stage stage;
	private static final Logger log = Logger.getLogger(Pingen.class.getName());

	public static void main(String[] args) {
		Application.launch(Pingen.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("view/main.fxml"));
		AnchorPane content;
		content = (AnchorPane) loader.load();
		Scene scene = new Scene(content);
		stage.setTitle("PIN-Generator DPMA");
		stage.setScene(scene);
		stage.show();
	}
}
