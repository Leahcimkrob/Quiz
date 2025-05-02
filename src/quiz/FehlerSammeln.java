package quiz;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;

public class FehlerSammeln {
    public static void main(String[] args) {
        try {
            // Name der Java-Datei und Quellcode mit absichtlichem Fehler (fehlendes Semikolon)
            String className = "Fehlerhaft";
            String sourceCode = """
                public class Fehlerhaft {
                    public static void main(String[] args) {
                        System.out.println("Hallo Welt") // Fehler: fehlendes Semikolon
                    }
                }
            """;

            // Erstelle die .java-Datei
            File sourceFile = new File(className + ".java");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(sourceFile))) {
                writer.write(sourceCode);
            }

            // Initialisiere JavaCompiler
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

            // StringWriter zum Sammeln der Fehlermeldungen
            ByteArrayOutputStream errorStream = new ByteArrayOutputStream();

            // Kompiliere die Datei und schreibe die Fehlermeldungen in errorStream
            int compilationResult = compiler.run(
                null, // InputStream
                null, // OutputStream (z. B. Standardausgabe, hier ignoriert)
                new PrintStream(errorStream), // Fehlerausgabe
                sourceFile.getPath() // Datei, die kompiliert wird
            );

            // Ausgabe der Ergebnisse
            if (compilationResult == 0) {
                System.out.println("Kompilierung erfolgreich!");
            } else {
                System.out.println("Kompilierung fehlgeschlagen!");
                System.out.println("Fehlerausgabe:");
                System.out.println(errorStream.toString());
            }

            // Lösche die erzeugte Datei
            if (!sourceFile.delete()) {
                System.out.println("Die Datei konnte nicht gelöscht werden: " + sourceFile.getName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}