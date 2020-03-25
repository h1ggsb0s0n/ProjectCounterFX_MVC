package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Company;
import application.Project;
import application.WorkPackage;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import models.WorkPackageModel;
import utilis.AlertCreator;

/**
 * CreateWorkPackageController Class ist der Conroller zur View CreateWorkPackageView
 * @author Nicolas Haefeli, Vivienne Rufle
 * @version 1.0
 * 
 */
public class CreateWorkPackageController {
	
	
	private WorkPackageModel model;
	
	@FXML
	private TextField WPNameTextField;
	
	
	@FXML
	private TextArea describtionTextArea;
	
	
	@FXML
	private Button createNewWPButton;
	
	@FXML
	private Button goBackButton;
	
	private Scene prevScene;
	
	/**
	 * Konstruktor CreateWorkPackageController
	 * @param model WorkPackageModel
	 */
	public CreateWorkPackageController(WorkPackageModel model) {
		//this.project = project;
		this.model = model;
	}
	
	
	/**
	 * Kontrolliert, ob das Workpackage korrekt angegeben wirde
	 * Falls Korrekt: Erstellen eines neuen WorkPackages
	 * Falls Fehler: Ausgeben einer Fehlermeldung
	 * @param event Button-CreateNewWorkPAckage Action Event
	 */
	@FXML
	public void onCreateNewWorkPackage(ActionEvent event) {
		ObservableList<WorkPackage> observableList = model.getWorkPackages();
		String wpName = this.WPNameTextField.getText();
		
		if(wpName.contentEquals("")) {
			AlertCreator.warningAlert("Missing Work Package Name", "Please select a Work Package Name to proceed");
		} else if (this.doesWpNameExist(wpName, observableList)){
			AlertCreator.warningAlert("WorkPackage already Exists", "Work Package Name does already exist!");
		} else {
			WorkPackage wp = new WorkPackage(wpName,  this.returnNextProjectID(observableList),this.describtionTextArea.getText());
			this.model.addWorkPackage(wp);
			AlertCreator.informationAlert("Workpackage created", "New Work Package successfully created");
			}
	}				
	
	/**
	 * Eine View zurück
	 * @param event Back-Button ActionEvent
	 */
	@FXML
	public void goBack(ActionEvent event) {
		Stage stage = (Stage) WPNameTextField.getScene().getWindow();
		stage.setScene(this.prevScene);
		
		
	}

	/**
	 * Prüfen, ob das WorkPackage bereits existiert
	 * @param wpName Name des WorkPackages, welcher neu eingetragen wurde
	 * @param list Observableist alle existierenden WorkPackages zu einem Projekt
	 * @return true/false Ob das WorkPAckage existiert?
	 */
	private boolean doesWpNameExist(String wpName, ObservableList<WorkPackage> list) {
		boolean doesExist = false;
		for (WorkPackage wp : list) { 		      
	           if(wp.getWPName().equals(wpName)){
	        	 doesExist = true;
	           }
	      }
		
		return doesExist;
	}
	
	/**
	 * Rückgebe der WorkPackage ID
	 * @param listOfWorkPackages ObservableList WorkPackage (Abhängig von Project)
	 * @return ID
	 */
	private int returnNextProjectID(ObservableList<WorkPackage> listOfWorkPackages) {
		if(listOfWorkPackages.isEmpty()) {
			return 1;
		} else {
			WorkPackage lastWorkPackage = listOfWorkPackages.get(listOfWorkPackages.size()-1);
			System.out.println(lastWorkPackage.getID()+1);
			return lastWorkPackage.getID() + 1;
		}
		
	}
	

	/**
	 * Eintragen der PrevScene
	 * @param scene Scene
	 */
	public void registerPrevScene(Scene scene) {
		this.prevScene = scene;
		
	}
	
	
}
