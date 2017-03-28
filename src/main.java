
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {		
			GUILoader gui = new GUILoader();
			gui.primaryStage = primaryStage;
			gui.showStart();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
