package quiz;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.nio.file.*;

public class JavaExecutorWithCapture {

    public static void main(String[] args) throws IOException, InterruptedException {
        String className = "HelloWorld";
        String sourceCode = """ 
            public class HelloWorld {
                public static void main(String[] args) {
                    System.out.println("Hello, World!");
                    int x = 5 / 0; // absichtlicher Fehler zur Laufzeit
                }
            }
        """;

        Path sourceFile = Paths.get(className + ".java");
        Files.writeString(sourceFile, sourceCode);

        StringWriter compilationOutput = new StringWriter();
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int compilationResult = compiler.run(
        	    null, // InputStream (z. B. keine Eingabe)
        	    System.out, // OutputStream für Standardausgabe
        	    System.err, // OutputStream für Standardfehlerausgabe
        	    sourceFile.toString() // Datei, die kompiliert werden soll
        	);

        if (compilationResult == 0) {
            System.out.println("Kompilierung erfolgreich!");

            ProcessBuilder processBuilder = new ProcessBuilder("java", className);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            StringBuilder runtimeOutput = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    runtimeOutput.append(line).append(System.lineSeparator());
                }
            }

            int exitCode = process.waitFor();
            System.out.println("Laufzeitausgabe:");
            System.out.println(runtimeOutput);
            System.out.println("Programm beendet mit Code: " + exitCode);

        } else {
            System.out.println("Kompilierung fehlgeschlagen.");
            System.out.println("Fehlerausgabe:");
            System.out.println(compilationOutput.toString());
        }

        Files.deleteIfExists(sourceFile);
        Files.deleteIfExists(Paths.get(className + ".class"));
    }
}
