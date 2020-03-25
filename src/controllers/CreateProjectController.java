package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Company;
import application.Project;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import utilis.AlertCreator;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * CreateProjectController Class ist der Conroller zur View CreateProjectView
 * @author Nicolas Haefeli, Vivienne Rufle
 * @version 1.0
 * 
 */
public class CreateProjectController implements Initializable{
	
	
	private ObservableList listOfCompanies;
	
	@FXML
	private ComboBox companyChooser;
	
	@FXML
	private TextField projectTextfield;
	
	
	@FXML
	private TextArea projectDescribtion;
	
	
	@FXML
	private Button createNewProjectButton;
	
	@FXML
	private Button goBackButton;
	
	private Scene prevScene;
	
	/**
	 * Konstruktor CreateProjectController
	 * @param listOfCompanies ObservableList der Companies
	 */
	public CreateProjectController(ObservableList listOfCompanies){
		this.listOfCompanies = listOfCompanies;
	}
	
	/**
	 * Auslesen der Textfelder, Kontrollieren ob die Felder korrekt ausgefült sind
	 * Falls fehler: ausgeben der Fehlermeldung
	 * Falls richtig: Project erstellen
	 * @param event
	 */
	@FXML
	public void onCreateNewProject(ActionEvent event) {
		
		Company selectedCompany = (Company) companyChooser.getValue();
		String projectName = this.projectTextfield.getText();
		ArrayList<Project> listOfProjects = selectedCompany.getProjects();
		
		if(projectName.equals("")) {
			AlertCreator.warningAlert("Missing Project Name", "Please select a Project Name to proceed");
			
		}else if(this.doesProjectExist(projectName, listOfProjects)){
			AlertCreator.warningAlert("Project already exists", "This Project name is already chosen. Please select a different Project Name.");
			
		} else {	
			
			Project projectToAdd = new Project(projectName, this.projectDescribtion.getText(), returnNextProjectID(listOfProjects));
			selectedCompany.getProjects().add(projectToAdd);
			AlertCreator.informationAlert("Success", "Your Project was successfully created");
			
		}
			
	}
	
	
	/**
	 * Eine View zurück
	 * @param event Back-Button ActionEvent
	 */
	@FXML
	public void goBack(ActionEvent event) {
		System.out.println("goBack");
		Stage stage = (Stage) companyChooser.getScene().getWindow();
		stage.setScene(this.prevScene);
		
		
	}

	
	/**
	 * Kontrollieren, ob PRoject bereits existiert
	 * @param projectName Eingetragener Project NAme
	 * @param listOfProjects ArrayList über alle Projects
	 * @return true/false Ob Project bereits vorhanden
	 */
	private boolean doesProjectExist(String projectName, ArrayList<Project> listOfProjects) {
		boolean doesExist = false;
		for (Project p : listOfProjects) { 		      
	           if(p.getPName().equals(projectName)){
	        	 doesExist = true;
	           }
	      }
		
		return doesExist;
	}
	
	//todo needs to be tested
	/**
	 * Rückgabe der Project ID
	 * @param listOfProjects ArrayList aller Projects
	 * @return Project ID
	 */
	private int returnNextProjectID(ArrayList<Project> listOfProjects) {
		if(listOfProjects.isEmpty()) {
			return 1;
		} else {
			Project lastProject = listOfProjects.get(listOfProjects.size()-1);
			return lastProject.getPNumber() + 1;
		}
		
	}

	/**
	 * Initialisieren der Companies
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.companyChooser.setItems(this.listOfCompanies);
		
	}


	/**
	 * Eintragen der PrevScene
	 * @param scene Scene
	 */
	public void registerPrevScene(Scene scene) {
		this.prevScene = scene;
		this.companyChooser.getSelectionModel().selectFirst();
		
	}
	
	
	
	
}
