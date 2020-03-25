package models;

import java.util.ArrayList;

import application.Company;
import application.ListOfCompanies;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * MainModel Class ist eine Model Class, welche eine ObservableList über das Company Object beinhaltet
 * @author Nicolas Haefeli, Vivienne Rufle
 * @version 1.0
 * 
 */
public class MainModel {

	ObservableList<Company> list = FXCollections.observableArrayList();
	
	/**
	 * Die Methode MainModel generiert eine ObservableList aus dem Object ListOfCompanies (ArrayList)
	 * @param companies
	 */
	public MainModel(ListOfCompanies companies){
		this.list = FXCollections.observableArrayList(companies.getCompanies());
	}
	
	/**
	 * Die MEthode getCompanies gibt die ObservabeList Company zurück
	 * @return ObservabeList Company
	 */
	public ObservableList<Company> getCompanies() {
		return this.list;
	}
	
}
