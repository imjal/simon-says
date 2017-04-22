package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

/**
 * This class will launch the application. 
 * It will create a Stage and a Scene that is defined by the 
 * FXML file. 
 * @author Jessica Lee
 *
 */
public class Main extends Application {
	private Stage primaryStage; 
	private AnchorPane rootLayout; 
	
	/**
	 * This method will take the stage and initialize the Title of the Application. 
	 * It will load the stage with a Scene made from FXML and will display it on the screen.
	 * @param primaryStage The stage to run the application
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage; 
			primaryStage.setTitle("Simon Says");
			
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("GUI.fxml"));
			rootLayout = (AnchorPane) loader.load(); 
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Will launch the application 
	 * @param args Upon the Start of the Program
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
