package quiz;

import java.util.Scanner;

/**
	 * Definiert die Struktur für alle Aufgaben:
	 * - Ausgabe
	 * - Eingabe
	 * - Prüfung
	 */
	public interface Aufgabe {
		public void initialiereFrage();
	    public void stelleFrage();
	    public void initialisiereNummer();
	    public String leseAntwort(Scanner scanner);
	    public void pruefeAntwort(String antwort);
}
