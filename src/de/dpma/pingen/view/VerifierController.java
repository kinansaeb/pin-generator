package de.dpma.pingen.view;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

import de.dpma.pingen.Pingen;
import de.dpma.pingen.Verifier;
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
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;

/**
 * @author AlBacher
 *         <p>
 *         This is the VerfierController it is the Scene of the VerifierPin
 *         <p>
 *         In this scene there a different Labels in Buttons. Also it is
 *         possible to generate the VerifierPin
 * @Since JDK1.0
 */
public class VerifierController {
	public static Stage stage;
	static Logger log = Logger.getLogger(Pingen.class.getName());
	String copyText;
	Pingen back = new Pingen();
	/**
	 * @author AlBacher
	 *         <p>
	 *         This is the DPMADirektprobestätigungs Label
	 *         <p>
	 *         This Label is for the DPMADirektprobestätigungspin The
	 *         DPMADirektProbestätigungspin is the Pin that a generate to
	 *         crypted the file
	 */
	@FXML
	private Label dpmadirektprobestätigungspin;
	/**
	 * @author AlBacher
	 *         <p>
	 *         This is the FingerPrint Label
	 *         <p>
	 *         A fingerprint is a unique code that contains different letters
	 *         and numbers. Every Human has only one Fingerprint Code.
	 */
	@FXML
	private Label fingerprint;
	/**
	 * @author AlBacher
	 *         <p>
	 *         This is the Date Label
	 *         <p>
	 *         The Date is the date when you got your document. You need to fill
	 *         in the date.
	 */
	@FXML
	private Label date;
	/**
	 * @author AlBacher
	 *         <p>
	 *         This is the Pin Label
	 *         <p>
	 *         The Pin is a code that will be generate. It contains different
	 *         Letters and Numbers
	 */
	@FXML
	private Label pin;
	/**
	 * @author AlBacher
	 *         <p>
	 *         This is the FingerPrint textfield
	 *         <p>
	 *         In this Fingerprint Textfield will be the Pin displayed after it
	 *         got generated.
	 * 
	 */
	@FXML
	private TextField fingerprintText;
	/**
	 * @author AlBacher
	 *         <p>
	 *         This is the DataPicker datefield
	 *         <p>
	 *         The Datapicker Field is the field to get the date. You can pick a
	 *         date out of the displayed calendar.
	 */
	@FXML
	private DatePicker dateField;
	@FXML
	/**
	 * @author AlBacher
	 *         <p>
	 *         This is the Textarea Pinfield
	 *         <p>
	 *         It is used for the Pin In this field the generated Pin will be
	 *         displayed. It is the Pin Outbox
	 */
	private TextArea pinField;
	/**
	 * @author AlBacher
	 *         <p>
	 *         This is the Pingenerate Button
	 *         <p>
	 *         This button is used to generate the Pin. You need to click the
	 *         button. After you click it it will realise that click and
	 *         generate the pin into the Pinfield
	 */
	@FXML
	private Button pinGenerate;

	ObservableList<String> options = FXCollections.observableArrayList("REGISTRATION", "REGISTRATION_CONFIRMATION",
			"REVOCATION", "REVOCATION_CONFIRMATION", "CERTIFICATE_CHANGE", "ADRESS_CHANGE");
	/**
	 * @author AlBacher
	 *         <p>
	 *         The ComboBox is a box to select a field
	 *         <p>
	 *         The Combobox is used to select a command so the programm can
	 *         generate the Pin. These Options have you to select
	 *         ("REGISTRATION", "REGISTRATION_CONFIRMATION", "REVOCATION",
	 *         "REVOCATION_CONFIRMATION", "CERTIFICATE_CHANGE", "ADRESS_CHANGE")
	 */
	@FXML
	private ComboBox<String> selection = new ComboBox<String>(options);
	/**
	 * @author AlBacher
	 *         <p>
	 *         This is the Backbutton
	 *         <p>
	 *         You can use this button by click on it. After you clicked it you
	 *         will get immediatly back to the previous scene
	 */
	@FXML
	private Button backButton;

	public void initialize() {
		selection.getItems().addAll(options);
	}

	/**
	 * @author AlBacher
	 *         <p>
	 *         This is the Backbutton
	 *         <p>
	 *         This is the function Backbutton it is part of the Button
	 *         Backbutton. If you click the Backbutton the system will detect
	 *         this buttonclick and load you into the previous scene.
	 * @return MainController
	 * @param event
	 */
	@FXML
	public void backButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
			log.info("Scene wird auf Main zurückgesetzt.");
			Parent root = (Parent) fxmlLoader.load();
			stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
			MainController.stage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author AlBacher
	 *         <p>
	 *         This is the generateButton
	 *         <p>
	 *         The function of the generate Button is to generate a Pin If you
	 *         click the Generatebutton the system will detect this buttonclick
	 *         and generate a Pin into the Pinfield.
	 * @return MainController
	 * @param event
	 */
	@FXML
	public void generateButton(ActionEvent event) {
		String fingerprint = fingerprintText.getText().toLowerCase();
		String art = selection.getValue();

		LocalDate calLD = dateField.getValue();
		GregorianCalendar cal = GregorianCalendar.from(calLD.atStartOfDay(ZoneId.systemDefault()));

		String avaId = "40000000";
		String erg = Verifier.getPIN(art, fingerprint, avaId, cal);
		copyText = erg;
		pinField.setText(erg);
		log.info("Pin " + erg + "wird generiert");
	}

	/**
	 * @author AlBacher
	 *         <p>
	 *         This is the copybutton it will copy the Pin into the Clipboard of
	 *         the PC
	 *         <p>
	 *         If the Copybutton get clicked by mice it will copy the Content of
	 *         the Textfield. The Content will copy into the SystemClipboard
	 * @Since JDK 7.0
	 */
	public void copyButton(ActionEvent event) {
		final Clipboard clipboard = Clipboard.getSystemClipboard();
		final ClipboardContent content = new ClipboardContent();
		content.putString(copyText);
		clipboard.setContent(content);
		log.info("PIN in Zwischenablage kopiert");
	}
}
