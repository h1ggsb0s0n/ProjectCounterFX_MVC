package models;

import java.util.ArrayList;

import application.WorkPackage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * WorkPackageModel Class ist eine Model Class, welche eine ObservableList über das WorkPackage Object beinhaltet
 * @author Nicolas Haefeli, Vivienne Rufle
 * @version 1.0
 * 
 */
public class WorkPackageModel {

	private ObservableList<WorkPackage> workPackages;
	
	/**
	 * Die Methode setWorkPackages wandelt eine ArrayList in eine ObservableList um
	 * @param ls ArrayList mit den entsprechenden Daten des WorkPackage
	 */
	public void setWorkPackages(ArrayList<WorkPackage> ls)  {
		this.workPackages = FXCollections.observableList(ls);
	}
	
	/**
	 * Die Methode getWorkPackages gibt die ObservableList WorkPackage zurück
	 * @return ObservableList WorkPackage
	 */
	public ObservableList<WorkPackage> getWorkPackages() {
		return workPackages;
	}
	
	/**
	 * Die Methode addWorkPackage fügt ein WorkPackage Object der ObservableList hinzu
	 * @param p WorkPackage Objec
	 */
	public void addWorkPackage(WorkPackage p) {
		this.workPackages.add(p);
	}
}
