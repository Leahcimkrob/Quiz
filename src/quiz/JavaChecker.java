package quiz;

/**
 * Programm, das Benutzereingaben für ein Java-Programm entgegennimmt,
 * den Code kompiliert und überprüft, ob "Hello World" ausgegeben wird.
 */
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.nio.file.*;

public class JavaChecker {
    /**
     * Hauptmethode, die das Benutzerprogramm kompiliert, ausführt und überprüft.
     *
     * @param args die Konsolenargumente
     * @throws IOException falls ein Fehler beim Datei-Handling auftritt
     * @throws InterruptedException falls der Prozess unterbrochen wird
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Bitte gib dein Hello-World Java-Programm ein (Ende mit einer Leerzeile):");

        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sourceCode = new StringBuilder();
        String line;

        while (!(line = userInputReader.readLine()).isEmpty()) {
            sourceCode.append(line).append(System.lineSeparator());
        }

        String className = "HelloWorld";
        Path sourceFile = Paths.get(className + ".java");
        Files.writeString(sourceFile, sourceCode.toString());

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        ByteArrayOutputStream errStream = new ByteArrayOutputStream();
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int compileResult = compiler.run(null, outStream, errStream, "--release", "17", sourceFile.toString());

        if (compileResult != 0) {
            System.out.println("Kompilierungsfehler:");
            System.out.println(errStream.toString());
        } else {
            System.out.println("Kompilierung erfolgreich. Starte Programm...");

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

            if (programOutput.toString().trim().equals("Hello World")) {
                System.out.println("✅ Aufgabe erfüllt: 'Hello World' korrekt ausgegeben!");
            } else {
                System.out.println("❌ Aufgabe nicht korrekt gelöst.");
            }
        }

        Files.deleteIfExists(sourceFile);
        Files.deleteIfExists(Paths.get(className + ".class"));
    }
}
