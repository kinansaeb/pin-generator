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
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;

public class UnlockController {
	/**
	 * @author AlBacher
	 * <p>
	 * The stage is the scene
	 * <p>
	 * In this stage we a in the scene of the UnlockController.
	 * Stage is the same as scene
	 * @since JavaFX 2.2
	 */
	public static Stage stage;
	static Logger log = Logger.getLogger(Pingen.class.getName());
	String copyText;
	Pingen back = new Pingen();
	@FXML
	/**
	 * @author AlBacher
	 * <p>
	 * This is the DPMADiretProUnlockPin
	 * <p>
	 * The DPMA Direkt Pro Unlock Pin unlocked the crypted file.
	 * Only with this Unlock Pin you have full access to the file
	 */
	private Label dpmadirektprounlockpin;
	@FXML
	/**
	 * @author AlBacher
	 * <p>
	 * This is the FingerPrint Label
	 * <p>
	 * A fingerprint is a unique code that contains different letters and numbers
	 * Every Human has a unique FIngerPrint.
	 */
	private Label fingerprint;
	/**
	 * @author AlBacher
	 * <p>
	 * This is the fingerprint textfield
	 * <p>
	 * The FingerPrint Textfield is the inputbox of the Fingerprint.
	 * In this field the Fingerprint can be writed in the field.
	 */
	@FXML
	private TextField fingerprintText;
	@FXML
	/**
	 * @author AlBacher
	 * <p>
	 * This is the PinGenerate Button
	 * <p>
	 * The PinGenerate Button is the button that need
	 * to be clicked to generate the UnlockPin.
	 */
	private Button pinGenerate;
	/**
	 * @author AlBacher
	 * <p>
	 * This is the TextArea
	 * <p>
	 * This TextArea is a firmly defined textfield. 
	 * In this field the UnlockPin will be displayed 
	 */
	@FXML
	private TextArea pinField;
	/**
	 * @author AlBacher
	 * <p>
	 * This is the Button Back
	 * <p>
	 * This Button is important to get back to the last scence.
	 * If you click it. It will load you immediatly in the last scene
	 */
	@FXML
	private Button backx;
	@FXML
	/**
	 * @author AlBacher
	 * <p>
	 * This is the Copy button
	 * <p>
	 * This button is important to copy the textfield
	 * If you click it. It copy the text into the clipboard
	 */
	private Button copy;

/**
 * @author AlBacher
 * <p>
 * If the Backbutton get hit it wil immediatly return you to the previous scene
 * <p>
 * If the Unlock Button is got clicked by mice click it will recognize this click.
 * After the click it will load you in the previous scene
 * @Since JavaFX 2.0
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
			stage.show();
			MainController.stage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

/** 
 * @author AlBacher
 * <p>
 * This is the generateButton it will generate by Button Click the UnlockPin
 * <p>
 * If the Unlock Button got clicked by mice it will recognize this click.
 * After it realize this click it will generate the Pin with the Verifier code
 * @Since JavaFX 2.0
 * @return It will return the Pin that contains different Letters and Numbers into the Textfield
 * @param event
 */
	@FXML

	public void generateButton(ActionEvent event) {

		String fingerprint = fingerprintText.getText().toLowerCase();
		String erg = Verifier.getDdProUnlockPIN(fingerprint);
		pinField.setText(erg);
		copyText = erg;
		log.info("Pin " + erg + " wird generiert");
	}

/**
 * @author AlBacher
 * <p>
 * This is the copybutton it will copy the Pin into the Clipboard of the PC
 * <p>
 * If the Copybutton get clicked by mice it will copy the Content of the Textfield.
 * The Content will copy into the SystemClipboard
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
