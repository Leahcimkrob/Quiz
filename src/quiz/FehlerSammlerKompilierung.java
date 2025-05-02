package quiz;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Desktop;

public class FehlerSammlerKompilierung {

    public void sammleKompilierungsfehler() {
        try {
            // Pfad zur Datei, die kompiliert werden soll
            String datei = "src/quiz/FehlerProgramm.java";
            ProcessBuilder pb = new ProcessBuilder("javac", datei);

            Process process = pb.start();

            BufferedReader fehlerReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            StringBuilder fehlerAusgabe = new StringBuilder();

            String zeile;
            boolean fehlerGefunden = false;

            while ((zeile = fehlerReader.readLine()) != null) {
                fehlerGefunden = true;
                fehlerAusgabe.append(zeile).append(System.lineSeparator());
            }

            // Logdatei erstellen und schreiben
            File logDatei = new File("fehler_kompilierung.log");
            try (PrintWriter logWriter = new PrintWriter(new FileWriter(logDatei))) {
                String zeit = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                logWriter.println(zeit + "\tStart Kompilierungsprotokoll");
                logWriter.println();
                logWriter.print(fehlerAusgabe.toString());
                logWriter.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\tEnde Kompilierungsprotokoll");
            }

            // Fehlerausgabe öffnen, falls Fehler gefunden wurden
            if (fehlerGefunden && Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(logDatei);
            }

        } catch (Exception e) {
            System.err.println("❌ Fehler beim Kompilieren: " + e.getMessage());
        }
    }
}