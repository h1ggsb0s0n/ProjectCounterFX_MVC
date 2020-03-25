package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import utilis.NumberUtils;

/**
 * WorkPackage Class beinhaltet alle Atribute und Methoden bezüglich dem Object WorkPackage
 * @author Nicolas Haefeli, Vivienne Rufle
 * @version 1.0
 * 
 */
public class WorkPackage {
	
	private String wPName;
	private int id;
	private String description;
	private boolean wPStatus; //true=bearbeitung, false=abgeschlossen
	private int wPCosts;
	private StringProperty costProperty;
	private Chronograph chronograph;


	/**
	 * Konstruktor WorkPackage
	 * Erstellen von Object Chronograph & CostProperty
	 * @param wPName WorkPackage Name
	 * @param id WorkPackage ID
	 * @param task WorkPackage Beschreibung
	 */
	public WorkPackage(String wPName, int id, String task) {
		this.wPName = wPName;
		this.wPCosts = 0;
		this.description = task;
		this.id = id;
		this.wPStatus = true;
		this.chronograph = new Chronograph();
		this.costProperty = new SimpleStringProperty("0");
	}
	
	/**
	 * Rückgabe von Workpackage Status
	 * @return WorkPackage Status
	 */
	public boolean isWPStatus() {
		return wPStatus;
	}
	
	/**
	 * Setzen der WorkPackage Beschreibung
	 * @param task
	 */
	public void setDescribtion(String task) {
		this.description = task;
	}
	
	/**
	 * Rückgabe der WorkPackage Beschreibung
	 * @return WorkPackage Beschreibung
	 */
	public String getDescribtion() {
		return this.description;
	}

	/**
	 * Setzen des WorkPackage Statuses
	 * @param wPStatus WorkPackage Status
	 */
	public void setWPStatus(boolean wPStatus) {
		this.wPStatus = wPStatus;
	}
	
	/**
	 * Rückgabe der WorkPackage Zeit
	 * @return WorkPackage Zeit
	 */
	public StringProperty getTimeProperty() {
		return this.chronograph.getTimeProperty();
	}

	/**
	 * Rückgabe der WorkPackage Kosten
	 * @return WorkPackage Kosten
	 */
	public StringProperty getCostProperty() {
		return this.costProperty;
	}
	
	//rounds to the next integer
	/**
	 * Double WorkPackage Kosten zu Int runden
	 * @param cost WorkPackage Kosten als Double
	 */
	public void addCosts(double cost) {
		this.wPCosts +=(NumberUtils.roundDoubleToInteger(cost));
		this.costProperty.setValue(Integer.toString(wPCosts));
	}

	/**
	 * Rückgabe der WorkPackage Namens
	 * @return WorkPackage Name
	 */
	public String getWPName() {
		return wPName;
	}

	/**
	 * Rückgabe der WorkPackage ID
	 * @return WorkPackage IS
	 */
	public int getID() {
		return id;
	}
	
	/**
	 * Rückgabe der WorkPackage Zeit
	 * @return
	 */
	public String returnTime(){
		return this.chronograph.returnTime();
	}
	
	/**
	 * Hinzufügen der WorkPackage Zeit
	 * @param c Chronograph c
	 */
	public void addTime(Chronograph c) {
		this.chronograph.addTime(c);
	}
	
}
