package application;
import java.util.ArrayList;

/**
 * Project Class beinhaltet alle Atribute und Methoden bezüglich dem Object Project
 * @author Nicolas Haefeli, Vivienne Rufle
 * @version 1.0
 * 
 */
public class Project {

	private String pName;
	private String describtion;
	private int pNumber;
	private double pCosts;
	private ArrayList<WorkPackage> workPackages = new ArrayList<WorkPackage>();
	
	/**
	 * Konstruktor Project
	 * @param pName Name des Projects
	 * @param describtion Beschreibung des Projects
	 * @param pNumber Project Number
	 */
	public Project(String pName, String describtion, int pNumber) {
		this.pName = pName;
		this.describtion = describtion;
		this.pNumber = pNumber;
		this.pCosts = 0;
	}

	/**
	 * Rückgabe des Projectnaens
	 * @return Projectname
	 */
	public String getPName() {
		return pName;
	}

	/**
	 * Rückgabe der Projectnummer
	 * @return Projectnummer
	 */
	public int getPNumber() {
		return pNumber;
	}

	/**
	 * Rückgabe der Projectkosten
	 * @return Projectkosten
	 */
	public double getPCosts() {
		return pCosts;
	}
	
	/**
	 * Rückgabe der ArrayList WorkPackages
	 * @return Workpackages
	 */
	public ArrayList<WorkPackage> getworkPackages(){
		return this.workPackages;
		
	}

	/**
	 * Setzen der Kosten
	 * @param PCosts Project Kosten
	 */
	public void setPCosts(double PCosts) {
		this.pCosts = PCosts;
	}

	/**
	 * Hinzufügen eines Workpackages zur ArryList
	 * @param workPackage Object Workpackage
	 */
	public void addWorkPackage(WorkPackage workPackage) {
		this.workPackages.add(workPackage);
	}
	
	/**
	 * Hinzufügen eines Workpackages zur ArryList
	 * @param name Workpackage Name
	 * @param describtion Workpackage Beschreibung
	 */
	public void addWorkPackage(String name, String describtion) {
		
		if(workPackages.isEmpty()) {
			workPackages.add(new WorkPackage(name, 1 , describtion));
		} else {
			int latestWorkPackageNo = workPackages.get(workPackages.size() - 1).getID();
			workPackages.add(new WorkPackage (name, ++latestWorkPackageNo, describtion));
		}
		
	}
	
	/**
	 * Rückgabe des Project Namens als String
	 * @preturn pName
	 */
	public String toString() {
		return this.pName;
	}
	
}
