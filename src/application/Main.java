package application;

import controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilis.RawDataCreator;

/**
 * Main Class ist der Atart der Application ProjectCounter
 * @author Nicolas Haefeli, Vivienne Rufle
 * @version 1.0
 * 
 */
public class Main extends Application {
	
	/**
	 * Startet die erste View Main
	 */
	@Override
	public void start(Stage primaryStage) {
		
		
		ListOfCompanies companies = RawDataCreator.createProjectRawData();
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/MainView.fxml"));
			MainController mainController = new MainController(companies);
			fxmlLoader.setController(mainController);
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/stylesheets/stylesheet.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("ProjectCounterFX");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Launch args
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}

