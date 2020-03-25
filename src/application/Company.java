package application;

import java.util.ArrayList;

/**
 * Company Class beinhaltet alle Atribute und Methoden bezüglich dem Object Company
 * @author Nicolas Haefeli, Vivienne Rufle
 * @version 1.0
 * 
 */
public class Company {

	private String name;
	private String location;
	private Employee employee;
	private ArrayList<Project> projects;
	
	/**
	 * Konstruktor Company 
	 * @param name Name der Company
	 * @param location Ort der Company
	 */
	public Company(String name, String location) {
		this.projects = new ArrayList<Project>();
		this.name = name;
		this.location = location;
	}

	/**
	 * Rückgabe des Objects Employee
	 * @return Employees
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * Employee setzen
	 * @param employee Mitarbeiter einer Firma
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * ArrayList der Projects einer Company
	 * @return Project
	 */
	public ArrayList<Project> getProjects() {
		return projects;
	}

	/**
	 * Hinzufügen eines Projects zu einer Firma
	 * @param project Object Project
	 */
	public void addProject(Project project) {
		this.projects.add(project);
	}

	/**
	 * Ausgeben des Company Namens
	 * @return Name der Company
	 */
	public String getName() {
		return name;
	}

	/**
	 * Ausgabe der Company Location
	 * @return Company Location
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Ausgabe des Namens als String
	 * @return name
	 */
    @Override
	public String toString() {
		return this.name;
	}

	
	
	
	
}
