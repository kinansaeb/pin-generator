package de.dpma.pingen.view;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Best�tigungController {
	
	@FXML
	private Label dpmadirektprobest�tigungspin;
	@FXML
	private Label fingerprint;
	@FXML
	private Label date;
	@FXML
	private Label pin;
	
	@FXML
	private TextField fingerprintField;
	@FXML
	private DatePicker dateField;
	@FXML
	private TextArea pinField;
	
	@FXML
	private Button pinGenerate;
	@FXML
	private ComboBox selection;
	
}
