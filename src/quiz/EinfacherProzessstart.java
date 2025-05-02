package quiz;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EinfacherProzessstart {
    public static void main(String[] args) {
        try {
            // Verwende cmd.exe, um den Befehl auszuführen
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "echo Hello World");

            // Fehlerausgabe umleiten
            processBuilder.redirectErrorStream(true);

            // Prozess starten
            Process process = processBuilder.start();

            // Ausgabe zeilenweise lesen
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line); // Ausgabe auf Konsole
                }
            }

            // Auf Beendigung warten und Exit-Code anzeigen
            int exitCode = process.waitFor();
            System.out.println("Prozess beendet mit Exit-Code: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}