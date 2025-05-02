package quiz;

import java.io.*;

public class FehlerProgramm {
    public static void main(String[] args) {
        try {
            // 🔄 Starte den FehlerTrenner
            System.out.println("🔍 Starte FehlerTrenner...");
            ProcessBuilder pbTrenner = new ProcessBuilder("java", "quiz.FehlerTrenner");
            Process trennerProcess = pbTrenner.start();

            // 🔄 Führt die Hauptlogik des FehlerProgramms aus
            System.out.println("ℹ️ FehlerProgramm wird ausgeführt...");
            beispielhafteHauptlogik();

            // 🧘‍♂️ Warten auf Beendigung des FehlerTrenners
            int trennerExitCode = trennerProcess.waitFor();
            System.out.println("👋 FehlerTrenner beendet mit Code: " + trennerExitCode);

        } catch (Exception e) {
            System.err.println("❌ Fehler im FehlerProgramm: " + e.getMessage());
        }
    }

    private static void beispielhafteHauptlogik() {
        // Hier kommt die Hauptlogik des FehlerProgramms
        System.out.println("⚙️ Beispielhafte Logik wird ausgeführt...");
        // Beispiel: Simuliere Fehler
        if (Math.random() > 0.5) {
            System.err.println("💥 Simulierter Fehler in FehlerProgramm!");
        }
    }
}