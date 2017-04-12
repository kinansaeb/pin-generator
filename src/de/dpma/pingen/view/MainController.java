package de.dpma.pingen.view;

import java.util.logging.Logger;

import de.dpma.pingen.Pingen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * @author AlBacher This is the MainController.java of the program Pin-Generator
 *         <p>
 *         The MainController.java is the main file of the start scene. It
 *         contains the functions of buttonclick UnlockPin and buttoclick
 *         ConfirmationPin.
 * 
 * @since JDK 1.0
 */
public class MainController {

	static Logger log = Logger.getLogger(Pingen.class.getName());
	Pingen gen = new Pingen();
	/**
	 * @author AlBacher The Stage is a new scene that contains different fields
	 *         <p>
	 *         The stage generate a new Scene. This stage generate a Scene that
	 *         contains the DPMADirektPro field and the Unlockpin Field.
	 * 
	 * @since JavaFX 2.0
	 */
	public static Stage stage;
	/**
	 * @author AlBacher
	 *         <p>
	 *         The DpmaDirektpropingenerator is the Label of the first scene
	 *         <p>
	 *         DpmaDirektPro is the name of the Program. The
	 *         DpmaDirektpropingenerator is on the first scene at the Top
	 * 
	 * @since JavaFX 2.0
	 */
	@FXML
	private Label dpmadirektpropingenerator;
	/**
	 * @author AlBacher
	 *         <p>
	 *         The UnlockPinButton is a button to load in the next scene
	 *         <p>
	 *         This Button is on the first scene on the bottom. If you click it,
	 *         it will load you in the next scene
	 * 
	 * @since JavaFX 2.0
	 */
	@FXML
	private Button unlockPinButton;
	/**
	 * @author AlBacher
	 *         <p>
	 *         The Confirmationbutton (Bestätigungsbutton) is a button to load
	 *         in the next scene
	 *         <p>
	 *         This Button is on the first scene on the bottom. If you click it,
	 *         it will load you in the next scene
	 * @since JavaFX 2.0
	 */

	@FXML
	private Button confirmationPinButton;

	/**
	 * @author AlBacher
	 *         <p>
	 *         If the Unlock Button is hit it will load into the next Stage /
	 *         Scene
	 *         <p>
	 *         If the Unlock Button is got clicked by mice click it will
	 *         recognize this click. Also then it will load you in the next
	 *         scene.
	 * @return unlock.fxml
	 * @since JavaFX 2.0
	 * @param event
	 */
	@FXML
	public void unlockButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("unlock.fxml"));
			log.info("Unlock wird intialisiert.");
			Parent root = (Parent) fxmlLoader.load();
			stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
			stage.setTitle("DPMA Unlock-PIN Generator");
			stage.getIcons().add(new Image("/Lock-icon.png"));
			gen.stage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author AlBacher
	 *         <p>
	 *         If the VerifierButton is being clicked it will load the Verifier
	 *         stage.
	 * 
	 *         <p>
	 *         If the Unlock Button is got clicked by mice click it will
	 *         recognize this click. Also then it will load you in the next
	 *         scene.
	 * @return verfier.fxml
	 * @since JavaFX 2.0
	 * @param event
	 */
	@FXML
	public void verifierButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("verifier.fxml"));
			log.info("Verifier wird initialisiert.");
			Parent root = (Parent) fxmlLoader.load();
			stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
			stage.setTitle("DPMA Verifier-PIN Generator");
			stage.getIcons().add(new Image("/Lock-icon.png"));
			gen.stage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
