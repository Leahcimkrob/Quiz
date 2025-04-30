package quiz;
	/**
	 * Definiert die Struktur für alle Aufgaben:
	 * - Ausgabe
	 * - Eingabe
	 * - Prüfung
	 */
	public interface Aufgabe {
	    void stelleFrage();
	    void leseAntwort();
	    void pruefeAntwort();
}
