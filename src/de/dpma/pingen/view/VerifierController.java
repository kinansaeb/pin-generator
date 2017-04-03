package de.dpma.pingen.view;

import java.util.logging.Logger;

import de.dpma.pingen.Pingen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	public static Stage stage;
	static Logger log = Logger.getLogger(Pingen.class.getName());
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

	ObservableList<String> options = FXCollections.observableArrayList("REGISTRATION", "REGISTRATION_CONFIRMATION",
			"REVOCATION", "REVOCATION_CONFIRMATION", "CERTIFICATE_CHANGE", "ADRESS_CHANGE");
	@FXML
	private ComboBox<String> selection = new ComboBox<String>(options);

	@FXML
	private Button backButton;

	public void initialize() {
		selection.getItems().addAll(options);
	}

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

	// @FXML
	// public void generateButton(ActionEvent event) {
	// String fingerprint = fingerprint.getText().toLowerCase();
	// String erg = Verifier.getPIN(art, fingerprint, avaId, cal);
	// pinField.setText(erg);
	// log.info("Pin " + erg + "wird generiert");
	// }
	//
	// public void copyButton(ActionEvent event) {
	// final Clipboard clipboard = Clipboard.getSystemClipboard();
	// final ClipboardContent content = new ClipboardContent();
	// content.putString(copyText);
	// clipboard.setContent(content);
	// log.info("PIN in Zwischenablage kopiert");
	// }
}
