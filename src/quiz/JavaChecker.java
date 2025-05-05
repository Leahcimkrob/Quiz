package quiz;

/**
 * Programm, das Benutzereingaben für ein Java-Programm entgegennimmt,
 * den Code kompiliert und überprüft, ob "Hello World" ausgegeben wird.
 */
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class JavaChecker implements Aufgabe {
		private String frageText = "" ;
		private String antwort = "" ;		

	@Override
	public void initialiereFrage() {
		frageText = "Bitte gib dein Hello-World Java-Programm ein (Ende mit einer Leerzeile):";
		antwort = "Hello World";		
	}

	@Override
	public void stelleFrage() {
		System.out.println(frageText);
	}
	
	public String leseAntwortException(Scanner scanner) throws IOException {
		BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sourceCode = new StringBuilder();
        String line;

        while (!(line = userInputReader.readLine()).isEmpty()) {
            sourceCode.append(line).append(System.lineSeparator());
        }
		return sourceCode.toString();
	}

	public void pruefeAntwortExeption(String sourceCode) throws IOException, InterruptedException {
		String line ="";
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

	@Override
	public String leseAntwort(Scanner scanner) {
		try {
			return leseAntwortException(scanner);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public void pruefeAntwort(String antwort) {
		 try {
			 pruefeAntwortExeption(antwort);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	
}
