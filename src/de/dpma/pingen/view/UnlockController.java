package de.dpma.pingen.view;

import java.util.logging.Logger;

import de.dpma.pingen.Pingen;
import de.dpma.pingen.Verifier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UnlockController {
	public static Stage stage;
	static Logger log = Logger.getLogger(Pingen.class.getName());

	Pingen back = new Pingen();
	@FXML
	private Label dpmadirektprounlockpin;
	@FXML
	private Label fingerprint;
	@FXML
	private TextField fingerprintText;
	@FXML
	private Button pinGenerate;
	@FXML
	private TextArea pinField;
	@FXML
	private Button backx;

	// Zurück Button
	@FXML
	public void backButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
			log.info("Scene wird auf Main zurückgesetzt.");
			Parent root = (Parent) fxmlLoader.load();
			stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
			MainController.stage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Generieren Button
	@FXML

	public void generateButton(ActionEvent event) {

		String fingerprint = fingerprintText.getText().toLowerCase();
		String erg = Verifier.getDdProUnlockPIN(fingerprint);
		pinField.setText(erg);
		log.info("Pin " + erg + "wird generiert");
	}
}
