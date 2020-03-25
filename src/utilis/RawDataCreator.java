package utilis;

import application.Company;
import application.ListOfCompanies;
import application.Project;

/**
 * RawDataCreator Class in welcher die Daten hart-codiert hinterlegt sind
 * @author Nicolas Haefeli, Vivienne Rufle
 * @version 1.0
 * 
 */
public class RawDataCreator {

	/**
	 * Die Methode createProjectRawData beinhaltet hardcodiert alle Daten des Programms
	 * @return Object ListOfCompanies
	 */
	public static ListOfCompanies createProjectRawData() {
		
		ListOfCompanies companies = new ListOfCompanies();
		
		Company novartis = new Company("Novartis", "Stein");
		Project projectERP = new Project("ERP", "Einf�hrung des SAP", 1);
		Project projectSynthesis = new Project("Synthese", "Synthese von Adrenalin", 2);
		Project projectRestructure = new Project("Umstrukturierung", "Umstrukturierung des Produktionswerkes A3", 3);
		projectERP.addWorkPackage("RequirementEngineering", "Get the Requirements");
		projectERP.addWorkPackage("CostEvaluation", "Evaluate the costs");
		novartis.addProject(projectERP);
		novartis.addProject(projectSynthesis);
		novartis.addProject(projectRestructure);
		
		
		
		Company syngenta = new Company("Syngenta", "Keiseraugst");
		Project projectLims = new Project("LIMS", "Lims Einf�hrung", 1);
		Project projectHplcPurchase = new Project("HPLC" , "Kauf eines neuen HPLC ger�tes", 2);
		Project projectAnalysis = new Project("Automatisierung", "Automatisierung von Analysen", 3);
		syngenta.addProject(projectLims);
		syngenta.addProject(projectHplcPurchase);
		syngenta.addProject(projectAnalysis);
		
		
		
		Company roche = new Company ("Roche", "Basel");
		Project receptor = new Project("Receptor B12", "Atack of Receptor B12", 1);
		Project serialisation = new Project("Serialisation" , "Serialisation of packaging process", 2);
		roche.addProject(receptor);
		roche.addProject(serialisation);
		
		
		
		companies.addCompany(novartis);
		companies.addCompany(syngenta);
		companies.addCompany(roche);
		
		return companies;
	}
}
