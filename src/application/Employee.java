package application;

/**
 * Employee Class beinhaltet alle Atribute und Methoden bezüglich dem Object Employee
 * @author Nicolas Haefeli, Vivienne Rufle
 * @version 1.0
 * 
 */
public class Employee {
	private String firstName;
	private String position;
	private int hourlyWage;
	
	/**
	 * Konstruktor Employee
	 * @param firstName Vorname des Mitarbeiters
	 * @param position Position des Mitarbeiters
	 * @param hourlyWage Stundenlohn des Mitarbeiters
	 */
	public Employee(String firstName, String position, int hourlyWage) {
		this.firstName = firstName;
		this.position = position;
		this.hourlyWage = hourlyWage;
	}

	/**
	 * Rückgabe der Mitarbeiterposition
	 * @return position des Employees
	 */
	public String getPosition() {
		return this.position;
	}

	/**
	 * Rückgabe des Stundenlohns als String
	 * @return Stundenlohn des Mitarbeiters als String
	 */
	public String getHourlyWageAsString() {
		return Integer.toString(this.hourlyWage);
	}
	
	/**
	 * Rückgabe des Stundenlohns als Int
	 * @return Stundenlohn des Mitarbeiters als Int
	 */
	public int getHourlyWage() {
		return this.hourlyWage;
	}
	
	/**
	 * Rückgabe des Vornamens als String
	 * @return firstName
	 */
	@Override
	public String toString() {
		return this.firstName;
	}

	
	
}
