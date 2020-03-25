package application;

import java.util.ArrayList;

/**
 * ListOfCompanies Class beinhaltet eine ArrayList über alle Companies
 * Beschränkter Nutzen. Dient momentan als Grundlage für das potentielle Erweiterungen des Programms.
 * @author Nicolas Haefeli, Vivienne Rufle
 * @version 1.0
 * 
 */
public class ListOfCompanies {
	
	private ArrayList<Company> companies = new ArrayList<Company>();
	
	
	public void addCompany(Company c) {
		
		this.companies.add(c);
	}
	
	public ArrayList<Company> getCompanies(){
		return this.companies;
	}

}
