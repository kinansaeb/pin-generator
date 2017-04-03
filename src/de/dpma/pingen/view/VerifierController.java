package de.dpma.pingen.view;

import de.dpma.pingen.Pingen;
import de.dpma.pingen.Verifier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VerifierController {

	@FXML
	private Label dpmadirektprobestätigungspin;
	@FXML
	private Label fingerprint;
	@FXML
	private Label date;
	@FXML
	private Label pin;

	@FXML
	private TextField fingerprintText;
	@FXML
	private DatePicker dateField;
	@FXML
	private TextArea pinField;

	@FXML
	private Button pinGenerate;
	@FXML
	private ComboBox<String> selection;

	@FXML
	private Button backButton;

	@FXML
	public void backButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));

			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
			Pingen.stage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void generateButton(ActionEvent event) {
		String fingerprint = fingerprint.getText().toLowerCase();
		String erg = Verifier.getPIN(art, fingerprint, avaId, cal);
	}
}
