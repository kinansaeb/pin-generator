package de.dpma.pingen.view;

import de.dpma.pingen.Pingen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainController {

	Pingen gen = new Pingen();

	@FXML
	private Label dpmadirektpropingenerator;
	@FXML
	private Button unlockPinButton;

	@FXML
	private Button confirmationPinButton;

	// Wenn Button gedrückt wird, wird scene gewechselt und alte scene
	// geschlossen
	@FXML
	public void unlockButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("unlock.fxml"));

			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
			gen.stage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void verifierButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("verifier.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
			gen.stage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
