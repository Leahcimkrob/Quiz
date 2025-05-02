package quiz;

public class FehlerTrenner {
    public static void main(String[] args) {
        // Erstellen von Instanzen der Sammlerklassen
        FehlerSammlerKompilierung kompFehler = new FehlerSammlerKompilierung();
        FehlerSammlerLaufzeit laufFehler = new FehlerSammlerLaufzeit();

        // Kompilierungsfehler verarbeiten
        System.out.println("🔍 Sammle Kompilierungsfehler...");
        kompFehler.sammleKompilierungsfehler();

        // Laufzeitfehler verarbeiten
        System.out.println("🔍 Sammle Laufzeitfehler...");
        laufFehler.sammleLaufzeitfehler();

        System.out.println("✅ Fehlertrennung abgeschlossen.");
    }
}