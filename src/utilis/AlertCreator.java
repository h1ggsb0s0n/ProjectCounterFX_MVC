package utilis;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * AlertCreator Class ist eine Klass zur Ausgabe von Alerts
 * @author Nicolas Haefeli, Vivienne Rufle
 * @version 1.0
 * 
 */
public class AlertCreator {

	/**
	 * Die Methode informationAlert gibt eine Information aus
	 * @param title gibt den Titel der Information aus
	 * @param text gibt den Text der Information aus
	 */
	public static void informationAlert(String title, String text) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(text);
		alert.showAndWait();
	}
	
	/**
	 * Die Methode warningAlert gibt eine Warnung aus
	 * @param title gibt den Titel der Warunung aus
	 * @param text gibt den Text der Warnung aus
	 */
	public static void warningAlert(String title, String text) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText(text);
		alert.showAndWait();
	}
	
	
}
