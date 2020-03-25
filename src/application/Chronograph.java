package application;

import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Chronograph Class beinhaltet alle Atribute und Methoden bezÃ¼glich dem Object Chronograph
 * Repräsentiert Zeit im Format tage, stunden, minuten sekunden
 * @author Nicolas Haefeli, Vivienne Rufle
 * @version 1.0
 * 
 */
public class Chronograph implements EventHandler{
	
	private int days;
	
	private int hours;
	
	private int minutes;

	private int seconds;
	
	private StringProperty timeProperty = new SimpleStringProperty();
	
	/**
	 * Konstruktor Chronograph
	 * Setzt alle Zeitwerte auf 0
	 */
	public Chronograph() {
		this.days = 0;
		this.hours = 0;
		this.minutes = 0;
		this.seconds = 0;
		this.timeProperty.setValue(this.returnTime());
		
	}
	
	/**
	 * RÃ¼ckgabe der TimeProperty
	 * @return StringProperty Object timeProperty
	 */
	public StringProperty getTimeProperty() {
		return this.timeProperty;
	}
	
	
	/**
	 * Zeiten hinzufÃ¼gen
	 * @param c Chronograph Object c
	 */
	public void addTime(Chronograph c) {
		
		this.seconds +=  c.getSeconds();
		this.minutes += c.getMinutes();
		this.hours += c.getHours();
		this.days += c.getDays();
		this.refactorTime();
		this.timeProperty.setValue(this.returnTime());
		
		
	}
	
	/**
	 * Zeitübergabe zu korrektem Zeitformat
	 * 60 Sekunden -> 1 Minute
	 * 60 Minuten -> 1 Stunde
	 * 24 Stunden -> 1 Tag
	 */
	private void refactorTime() {
		if(this.seconds >= 60) {
			this.seconds -= 60;
			this.minutes++;
		}
		
		if(this.minutes >= 60) {
			this.minutes -= 60;
			this.hours++;
		}
		
		if(this.hours >= 24) {
			this.hours -= 24;
			this.days++;
		}
	}
	
	/**
	 * Hinzufügen einer Sekunde & anpassen an korrektes Zeitformat
	 * 60 Sekunden -> 1 Minute
	 * 60 Minuten -> 1 Stunde
	 * 24 Stunden -> 1 Tag
	 */
	private void addOneSecond() {
		this.seconds++;
		if(this.seconds == 60) {
			this.minutes++;
			this.seconds = 0;
		}
		
		if(this.minutes == 60) {
			this.hours++;
			this.minutes = 0;
		}
		
		if (this.hours == 24) {
			this.days++;
			this.hours = 0;
		}
	}
	
	
	/**
	 * Auslesen der Tage
	 * @return days
	 */
	public int getDays() {
		return days;
	}


	/**
	 * Auslesen der Stunden
	 * @return hours
	 */
	public int getHours() {
		return hours;
	}


	/**
	 * Auslesen der Minuten
	 * @return minutes
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * Auslesen der Sekunden
	 * @return Seconds
	 */
	public int getSeconds() {
		return seconds;
	}

	/**
	 * Zeitwerte auf 0 setzen
	 */
	public void setToZero(){
		this.seconds = 0;
		this.minutes = 0;
		this.hours = 0;
		this.days = 0;
	}
	
	/**
	 * Tage und Stunden um 10 erhÃ¶hen
	 */
	public void addTenSeconds() {
		this.days += 10;
		this.hours += 10;
	}	
	
	/**
	 * BErechnen der Kosten abhÃ¤ngig von dem Stunden Lohn und der aktuellen Zeit
	 * @param hourlyWage Stundenlohn des Employees
	 * @return Arbeitszeit-Kosten
	 */
	public double calculateCost(int hourlyWage) {
		System.out.println(returnTimeInHours());
		return this.returnTimeInHours() * hourlyWage;
	}
	
	/**
	 * Ausgabe der aktuellen Zeit (StoppuhrzÃ¤hler)
	 * @return Zeitangabe inform eines Strings
	 */
	public String returnTime() {
		
		return days + " days " + hours + " hours " + minutes + " minutes " + seconds + " seconds";
	}
	
	/**
	 * Zeitausgabe auf stunden gerechnet/gerundet
	 * @return Anzahl Arbeitsstunden
	 */
	private double returnTimeInHours() {
		double minutes = (double)this.minutes;
		return (this.days * 24) + (this.hours)+(minutes/60);
	}
	
	/**
	 * Setzen der Zeit am StringProperty
	 */
	public void setTime() {
		this.timeProperty.setValue(this.returnTime());
	}


	/**
	 * Hinzufügen einer Sekunde und Zeitanzeige erneuern
	 *
	 */
	@Override
	public void handle(Event arg0) {
		this.addOneSecond();
		this.setTime();
	}
	
	

}
