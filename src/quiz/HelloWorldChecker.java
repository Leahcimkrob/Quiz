package quiz;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.nio.file.*;

public class HelloWorldChecker {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 1. Benutzer-Eingabe
        System.out.println("Bitte gib dein Java-Programm ein (Ende mit einer Leerzeile):");

        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sourceCode = new StringBuilder();
        String line;

        while (!(line = userInputReader.readLine()).isEmpty()) {
            sourceCode.append(line).append(System.lineSeparator());
        }

        String className = "UserProgram";
        Path sourceFile = Paths.get(className + ".java");

        // 2. Quellcode speichern
        Files.writeString(sourceFile, sourceCode.toString());

        // 3. Kompilieren (explizit auf Java 17 eingestellt)
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        ByteArrayOutputStream errStream = new ByteArrayOutputStream();
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int compileResult = compiler.run(null, outStream, errStream, "--release", "17", sourceFile.toString());

        if (compileResult != 0) {
            System.out.println("Kompilierungsfehler:");
            System.out.println(errStream.toString());
        } else {
            System.out.println("Kompilierung erfolgreich. Starte Programm...");

            // 4. Programm ausführen
            ProcessBuilder processBuilder = new ProcessBuilder("java", className);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            StringBuilder programOutput = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                while ((line = reader.readLine()) != null) {
                    programOutput.append(line).append(System.lineSeparator());
                }
            }

            int exitCode = process.waitFor();
            System.out.println("Ausgabe des Programms:");
            System.out.println(programOutput.toString());

            // 5. Überprüfung der Ausgabe
            if (programOutput.toString().trim().equals("Hello World")) {
                System.out.println("✅ Aufgabe erfüllt: 'Hello World' korrekt ausgegeben!");
            } else {
                System.out.println("❌ Aufgabe nicht korrekt gelöst.");
            }
        }

        // 6. Aufräumen
        Files.deleteIfExists(sourceFile);
        Files.deleteIfExists(Paths.get(className + ".class"));
    }
}
