package controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Company;
import application.ListOfCompanies;
import application.Project;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.MainModel;

/**
 * MainController Class ist der Conroller zur View MainView
 * @author Nicolas Haefeli, Vivienne Rufle
 * @version 1.0
 * 
 */
public class MainController implements Initializable{

	@FXML
	private ComboBox companyChooser;
	
	@FXML
	private ComboBox projectChooser;
	
	
	@FXML
	private Button createNewProjectButton;
	
	
	private MainModel model;
	
	
	private Company selectedCompany;
	
	
	/**
	 * Konstruktor MainController
	 * Die Companies werden übergeben
	 * @param c Company Alle Companies
	 * @param p ProjectProject zu Company
	 */
	public MainController(ListOfCompanies companies) {
		model = new MainModel(companies);
		
	}
	
	/**
	 * Auswahl der Company
	 * Nach der Auswahl der Company werden die entsprechenden Projects in einer ObservableList dem Dropdown Project zugewiesen
	 * @param event Dropdoen-SelectCompany ActionEvent
	 */
	@FXML
	public void onSelectCompany(ActionEvent event) {
		
		this.selectedCompany = (Company) companyChooser.getValue();
		ObservableList<Project> projects = FXCollections.observableArrayList(this.selectedCompany.getProjects());
		this.projectChooser.setItems(projects);
	}
	
	/**
	 * Neues Project erstellen
	 * Lädt die nächste View CreateProject
	 * @param event Create Project-Button ActionEvent
	 */
	@FXML
	public void onCreateNewProject(ActionEvent event) {
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/CreateProjectView.fxml"));
		try {
			CreateProjectController controller = new CreateProjectController(this.companyChooser.getItems());
			fxmlLoader.setController(controller);
			Parent root = fxmlLoader.load();
			controller.registerPrevScene(companyChooser.getScene());
			Stage s = (Stage) companyChooser.getScene().getWindow();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/stylesheets/stylesheet.css").toExternalForm());
			s.setScene(scene);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Auswahl des Projects in Abhängigkeit von der Company
	 * Anschliessendes aufrufen der Methode showWorkPackageView
	 */
	@FXML
	public void onSelectProject() {
		Project selectedProject = (Project) projectChooser.getValue();
		showWorkPackageView(selectedProject);
	}
	
	/**
	 * Laden der View WorkPAakage
	 * @param selectedProject das Ausgewählte Project im Dropdown SelectProject
	 */
	private void showWorkPackageView(Project selectedProject) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/WorkPackageView.fxml"));
		try {
			WorkpackageController workPackageController = new WorkpackageController(this.selectedCompany, selectedProject);
			
			fxmlLoader.setController(workPackageController);
			Parent root = fxmlLoader.load();
			workPackageController.registerPrevScene(companyChooser.getScene());
			Stage s = (Stage) companyChooser.getScene().getWindow();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/stylesheets/stylesheet.css").toExternalForm());
			s.setScene(scene);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Inizialisieren der Companies
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		this.companyChooser.setItems(model.getCompanies());
		
	}
	
	
	
}
