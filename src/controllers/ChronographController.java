package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Chronograph;
import application.Company;
import application.Employee;
import application.Project;
import application.WorkPackage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * ChronographController Class ist der Conroller zur View ChronographView
 * @author Nicolas Haefeli, Vivienne Rufle
 * @version 1.0
 * 
 */
public class ChronographController implements Initializable{
	
	@FXML
	private Label workPackageNameLabel;
	
	@FXML
	private ComboBox userComboBox;
	
	@FXML
	private Label hourlyWageLabel;
	
	
	@FXML
	private Label chronographLabel;
	
	
	
	@FXML
	private Button startTimer;
	
	@FXML
	private Button stopTimer;
	
	@FXML
	private Button submitButton;
	
	@FXML
	private Button goBack;
	
	
	
	
	private WorkPackage currentWorkPackage;
	
	private Chronograph chronograph = new Chronograph();
	
	private Timeline timeline = new Timeline();
	
	private ObservableList<Employee> listOfUsers;
	
	private Scene prevScene;
	
	/**
	 * Konstruktor ChronographController, welcher die Zeitanzeige und die Mitarbeiterliste wie auch das entsprechende WorkPackage Object lädt
	 * @param workPackage auf welches die Zeit gestoppt wird
	 */
	public ChronographController(WorkPackage workPackage) {
		this.currentWorkPackage = workPackage;
		timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(0.001), chronograph));
       
        Employee manager = new Employee("Vivienne", "Manager", 100);
        Employee assistant = new Employee("Nicolas", "Assistant", 50);
        Employee operator = new Employee("Karl", "Operator", 30);
        ArrayList<Employee> list = new ArrayList<Employee>();
       
        list.add(manager);
        list.add(assistant);
        list.add(operator);
        
        
        this.listOfUsers = FXCollections.observableArrayList(list);
		
	}
	
	
	/**
	 * Starten des Timers
	 * @param event Start-Button ActionEvent
	 */
	@FXML
	public void onStartTimer(ActionEvent event) {
		
        this.timeline.playFromStart();
        
	}
	
	/**
	 * Stoppen des Timers
	 * @param event Stop-Button ActionEvent
	 */
	@FXML
	public void onStopTimer(ActionEvent event) {
		this.timeline.stop();
	}
	
	/**
	 * Übertragen der Kosten sowie der Zeit und das resetten der Stoppuhr
	 * @param event Submit-Button ActionEvent
	 */
	@FXML
	public void onSubmit(ActionEvent event) {
		
		this.currentWorkPackage.addTime(this.chronograph);
		this.currentWorkPackage.addCosts(this.calculateCost());
		this.chronograph.setToZero();
		
	}
	
	/**
	 * Auwahl ds Employees berücksichtigen
	 * @param event Select-Employee Dropdown ActionEvet
	 */
	@FXML
	public void onSelectEmployee(ActionEvent event) {
		Employee currentEmployee = (Employee) this.userComboBox.getValue();
		this.hourlyWageLabel.setText(currentEmployee.getHourlyWageAsString());
	}
	
	/**
	 * Auswahl des Employees
	 */
	public void selectFirstEmployee() {
		this.userComboBox.getSelectionModel().selectFirst();
		Employee currentEmployee = (Employee) this.userComboBox.getValue();
		this.hourlyWageLabel.setText(currentEmployee.getHourlyWageAsString());
	}
	
	/**
	 * Stundenlohn des Employees auslesen und Methode zur Kostenberechnung (chronograph.calculateCost) aufrufen
	 * @return Stundenlohnkosten des Workpackages
	 * @see application.Chronograph#calculateCost
	 */
	private double calculateCost() {
		Employee currentEmployee = (Employee) this.userComboBox.getValue();
		return chronograph.calculateCost(currentEmployee.getHourlyWage());
	}
	
	/**
	 * Eine View zurück (WorkPackage auswahl)
	 * @param event Back-Button ActionEvent
	 */
	@FXML
	public void goBack(ActionEvent event) {
		Stage stage = (Stage) chronographLabel.getScene().getWindow();
		stage.setScene(this.prevScene);
		
	}
	
	/**
	 * Eintragen der PrevScerne
	 * @param s Scene
	 */
	public void registerPrevScene(Scene s) {
		this.prevScene = s;
	}

	/**
	 * Initialisieren
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.chronographLabel.textProperty().bind(this.chronograph.getTimeProperty());
		this.workPackageNameLabel.setText(this.currentWorkPackage.getWPName());
		this.userComboBox.setItems(this.listOfUsers);
		this.selectFirstEmployee();
	}
	
}
