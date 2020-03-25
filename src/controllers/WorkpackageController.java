package controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Company;
import application.Project;
import application.WorkPackage;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import models.WorkPackageModel;
import utilis.AlertCreator;

/**
 * WorkpackageController Class ist der Conroller zur View WorkpackageView
 * @author Nicolas Haefeli, Vivienne Rufle
 * @version 1.0
 * 
 */
public class WorkpackageController implements Initializable{
	
	private Company currentCompany;
	private Project currentProject;
	
	@FXML
	private Label companyLabel;
	
	@FXML
	private Label projectLabel;
	

	@FXML
	private TableView<WorkPackage> tblView;
	
	@FXML
	private TableColumn<WorkPackage, String> workpackageColumn;
	
	
	@FXML
	private TableColumn<WorkPackage, String> timeColumn;
	

	@FXML
	private TableColumn<WorkPackage, String> costColumn;
	
	
	@FXML
	private TableColumn<WorkPackage, String> status;
	
	
	@FXML
	private Button selectWorkPackageButton;
	
	@FXML
	private Button creatWorkPackageButton;
	
	@FXML
	private Button goBackButton;
	
	private WorkPackageModel workPackageModel = new WorkPackageModel();
	
	private Scene prevScene;
	
	/**
	 * Konstruktor WorkpackageController, das WorkPackage ist abhängig von Company und Project
	 * @param c Company
	 * @param p Project
	 */
	public WorkpackageController(Company c, Project p) {
		this.currentCompany = c;
		this.currentProject = p;
	}
	
	
	/**
	 * Einstellungen bezüglich der Tabelarischen auflistung
	 */
	private void setUpTableView() {
		ArrayList<WorkPackage> workPackages = this.currentProject.getworkPackages();
		this.workPackageModel.setWorkPackages(workPackages);
		tblView.setItems(workPackageModel.getWorkPackages());
		tblView.getSelectionModel().selectFirst();
		this.companyLabel.setText(currentCompany.getName());
		this.projectLabel.setText(currentProject.getPName());
	}
	
	/**
	 * Eintragen der PrevScerne
	 * @param s Scene
	 */
	@FXML
	public void registerPrevScene(Scene s) {
		this.prevScene = s;
	}
	
	
	/**
	 * Eine View zurück (WorkPackage auswahl)
	 * @param event Back-Button ActionEvent
	 */
	@FXML
	public void goBack(ActionEvent event) {
		Stage stage = (Stage) tblView.getScene().getWindow();
		stage.setScene(this.prevScene);
		
	}
	
	
	
	/**
	 * Auslesen des ausgewählten WorkPackages in der TableView
	 * @return ausgewähltes WorkPackage
	 */
	private WorkPackage getSelectedWorkPackage() {	
		return this.tblView.getSelectionModel().getSelectedItem();	
	}
	
	/**
	 * Auswahl des WorkPackages berücksichtigen und laden der nächsten View (ChronographView)
	 * @param event SelectWorkPackage-Button Action-Event
	 */
	@FXML
	private void selectWorkPackage(ActionEvent event) {
		
		tblView.getSelectionModel().selectFirst();
		if(tblView.getItems().isEmpty()) {
			AlertCreator.warningAlert("Table not populated", "Apparently, your project does not contain a workpackage. Please create a new one to proceed.");
		} else {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/ChronoGraphView.fxml"));
			try {
				
				ChronographController chronographController = new ChronographController(this.getSelectedWorkPackage());
				fxmlLoader.setController(chronographController);
				Parent root = fxmlLoader.load();
				chronographController.registerPrevScene(tblView.getScene());
				Stage s = (Stage) this.tblView.getScene().getWindow();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("/stylesheets/stylesheet.css").toExternalForm());
				s.setScene(scene);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * Laden der View CreateWorkPackage
	 * @param event Button-CreateWorkPackage ActionEvent
	 */
	@FXML
	private void onCreateWorkPackage(ActionEvent event) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/CreateWorkPackageView.fxml"));
		try {
			
			CreateWorkPackageController controller = new CreateWorkPackageController(this.workPackageModel);
			fxmlLoader.setController(controller);
			Parent root = fxmlLoader.load();
			controller.registerPrevScene(tblView.getScene());
			Stage s = (Stage) this.tblView.getScene().getWindow();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/stylesheets/stylesheet.css").toExternalForm());
			s.setScene(scene);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Initialisieren der WorkPackages, der Time und der Costs in einer Tabelle
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		workpackageColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getWPName()));
		timeColumn.setCellValueFactory(data -> data.getValue().getTimeProperty());
		costColumn.setCellValueFactory(data -> data.getValue().getCostProperty());
		this.setUpTableView();
		
	}
	
	
}
