package quiz;

import java.io.*;

public class FehlerTrenner {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "quiz.FehlerProgramm");
            Process process = pb.start();

            // 🔄 Threads zur parallelen Verarbeitung beider Streams
            Thread outputThread = new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("STDOUT: " + line);
                    }
                } catch (IOException e) {
                    System.err.println("Fehler beim Lesen der Standardausgabe: " + e.getMessage());
                }
            });

            Thread errorThread = new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.err.println("STDERR: " + line);
                    }
                } catch (IOException e) {
                    System.err.println("Fehler beim Lesen der Fehlerausgabe: " + e.getMessage());
                }
            });

            // ▶️ Starten
            outputThread.start();
            errorThread.start();

            // 🧘‍♂️ Warten auf Beendigung
            outputThread.join();
            errorThread.join();

            int exitCode = process.waitFor();
            System.out.println("🔚 Prozess beendet mit Code " + exitCode);

        } catch (Exception e) {
            System.err.println("❌ Fehler beim Starten oder Verarbeiten: " + e.getMessage());
        }
    }
}
