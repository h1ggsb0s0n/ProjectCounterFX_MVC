package utilis;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * NumberUtils Class ist eine Klasse um Werte zu runden
 * @author Nicolas Haefeli, Vivienne Rufle
 * @version 1.0
 * 
 */
public class NumberUtils {
	public static final int PLACES_0 = 0;
	public static final int PLACES_2 = 2;
	public static final int PLACES_3 = 3;
	
	/**
	 * Die Methode round rundet einen double Wert auf ein bestimmte Länge
	 * @param value zu rundender Wert
	 * @param places Anzahl NAchkommastellen
	 * @return gerundeter Wert
	 */
	public static double round(double value, int places) {
		 BigDecimal d = new BigDecimal(Double.toString(value));
		 d = d.setScale(places, RoundingMode.HALF_UP);
		 return d.doubleValue();
	}
	
	/**
	 * Die Methode roundDoubleToInteger wandelt einen double Wert in einen Int um (Keine Nachkommastelle)
	 * @param value zu rundender Wert (double)
	 * @return gerundeter Wert (Int)
	 */
	public static int roundDoubleToInteger(double value) {
		 BigDecimal d = new BigDecimal(Double.toString(value));
		 d = d.setScale(PLACES_0, RoundingMode.HALF_UP);
		 return d.intValue();
	}
}
