package quiz;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FehlerStarter {
    public static void main(String[] args) {
        StringBuilder ausgabe = new StringBuilder();

        try {
            ProcessBuilder pb = new ProcessBuilder("java", "quiz.FehlerProgramm");
            pb.redirectErrorStream(true);  // Fehlerausgabe wird umgeleitet
            Process process = pb.start();

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {
                String zeile;
                while ((zeile = reader.readLine()) != null) {
                    ausgabe.append(zeile).append(System.lineSeparator());
                }
            }

            int exitCode = process.waitFor();
            ausgabe.append("Prozess beendet mit Code ").append(exitCode);

        } catch (Exception e) {
            ausgabe.append("Fehler beim Starten: ").append(e.getMessage());
        }

        System.out.println("🔍 Gesammelte Ausgabe:");
        System.out.println(ausgabe);
    }
}
