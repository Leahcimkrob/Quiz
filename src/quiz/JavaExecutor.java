package quiz;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.nio.file.*;

public class JavaExecutor {

    public static void main(String[] args) throws IOException, InterruptedException {
        String className = "HelloWorld";
        String sourceCode = """
            public class HelloWorld {
                public static void main(String[] args) {
                    System.out.println("Hello, World!");
                }
            }
            """;

        Path sourceFile = Paths.get(className + ".java");
        Files.writeString(sourceFile, sourceCode);

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int compilationResult = compiler.run(null, System.out, System.err, sourceFile.toString());

        if (compilationResult == 0) {
            System.out.println("Kompilierung erfolgreich!");

            ProcessBuilder processBuilder = new ProcessBuilder("java", className);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            int exitCode = process.waitFor();
            System.out.println("Programm beendet mit Code: " + exitCode);

        } else {
            System.out.println("Kompilierung fehlgeschlagen.");
        }

        Files.deleteIfExists(sourceFile);
        Files.deleteIfExists(Paths.get(className + ".class"));
    }
}
