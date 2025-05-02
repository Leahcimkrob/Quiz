package quiz;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Desktop;


public class FehlerSammlerLaufzeit {

	    public static void main(String[] args) {
	        try {
	            ProcessBuilder pb = new ProcessBuilder("java", "quiz.FehlerProgramm");
	            pb.redirectErrorStream(true); // stderr → stdout

	            Process process = pb.start();

	            File logDatei = new File("fehler_laufzeit.log");
	            PrintWriter logWriter = new PrintWriter(new FileWriter(logDatei));

	            String zeitStart = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	            logWriter.println(zeitStart + "\tStart des Fehlerprotokolls");
	            logWriter.println();

	            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	            String line;
	            boolean fehlerGefunden = false;

	            while ((line = reader.readLine()) != null) {
	                System.out.println(line);
	                logWriter.println(line);
	                logWriter.println();

	                // Prüfe auf typische Fehlermeldungen
	                if (line.contains("Exception") || line.contains("Error") || line.trim().startsWith("at ")) {
	                    fehlerGefunden = true;
	                }
	            }

	            int exitCode = process.waitFor();
	            System.out.println("🔚 Prozess beendet mit Code: " + exitCode);

	            String zeitEnde = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	            logWriter.println(zeitEnde + "\tEnde des Fehlerprotokolls");
	            logWriter.close();

	            if (fehlerGefunden && Desktop.isDesktopSupported()) {
	                Desktop.getDesktop().open(logDatei);
	            }

	        } catch (Exception e) {
	            System.err.println("❌ Fehler beim Ausführen: " + e.getMessage());
	        }
	    }
	}

