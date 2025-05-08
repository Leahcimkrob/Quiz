package quiz;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Scanner;

public class JavaChecker implements Aufgabe {
    String frageText = "";
    String antwort = "";

	@Override
	public void initialisiereNummer() {
        try {
            // Parse the JSON file
            Gson gson = new Gson();
            Reader reader = new FileReader("javaaufgabe.json");
            JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);

            // Extract all numbers
            Integer[] numbers = new Integer[jsonArray.size()];
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject task = jsonArray.get(i).getAsJsonObject();
                String key = task.keySet().iterator().next(); // Get the first key
                numbers[i] = Integer.parseInt(key); // Convert key to integer
            }

            // Print the numbers (or use them as needed)
            System.out.println("Extracted numbers: " + Arrays.toString(numbers));
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}    
    
    
	@Override
    public void initialiereFrage() {
        try {
            // JSON-Datei einlesen
            Gson gson = new Gson();
            Reader reader = new FileReader("javaaufgabe.json");
            JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);

            // Erste Aufgabe aus dem JSON auswählen
            if (jsonArray.size() > 0) {
                JsonObject firstTask = jsonArray.get(0).getAsJsonObject();
                for (String key : firstTask.keySet()) {
                    JsonObject taskDetails = firstTask.getAsJsonObject(key);
                    frageText = taskDetails.get("Frage").getAsString(); // Frage
                    antwort = taskDetails.get("Antwort").getAsString(); // Erwartete Antwort
                    break; // Nur die erste Frage lesen
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            frageText = "Fehler beim Laden der Aufgabe.";
            antwort = "";
        }
    }

    @Override
    public void stelleFrage() {
        System.out.println(frageText);
    }

    @Override
    public String leseAntwort(Scanner scanner) {
        try {
            return leseAntwortException(scanner);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
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

    @Override
    public void pruefeAntwort(String antwort) {
        try {
            pruefeAntwortExeption(antwort, antwort, antwort);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String pruefeAntwortExeption(String sourceCode, String currentQuestion, String currentAnswer) throws IOException, InterruptedException {
        String className = "HelloWorld";
        Path sourceFile = Paths.get(className + ".java");
        Files.writeString(sourceFile, sourceCode);

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        ByteArrayOutputStream errStream = new ByteArrayOutputStream();
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int compileResult = compiler.run(null, outStream, errStream, "--release", "17", sourceFile.toString());

        StringBuilder output = new StringBuilder();

        if (compileResult != 0) {
            output.append("Kompilierungsfehler:\n");
            output.append(errStream.toString());
        } else {
            output.append("Kompilierung erfolgreich. Starte Programm...\n");

            ProcessBuilder processBuilder = new ProcessBuilder("java", className);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            StringBuilder programOutput = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    programOutput.append(line).append(System.lineSeparator());
                }
            }

            int exitCode = process.waitFor();
            output.append("Ausgabe des Programms:\n");
            output.append(programOutput.toString());

            if (programOutput.toString().trim().equals(antwort)) {
                output.append("\n✅ Aufgabe erfüllt: ").append(antwort).append(" korrekt ausgegeben!");
            } else {
                output.append("\n❌ Aufgabe nicht korrekt gelöst.");
            }
        }

        Files.deleteIfExists(sourceFile);
        Files.deleteIfExists(Paths.get(className + ".class"));

        System.out.println(output.toString());
        return output.toString();
    }
    
    public String pruefeAntwortExeption(String sourceCode) throws IOException, InterruptedException {
        String className = "HelloWorld";
        Path sourceFile = Paths.get(className + ".java");
        Files.writeString(sourceFile, sourceCode);

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        ByteArrayOutputStream errStream = new ByteArrayOutputStream();
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int compileResult = compiler.run(null, outStream, errStream, "--release", "17", sourceFile.toString());

        StringBuilder output = new StringBuilder();

        if (compileResult != 0) {
            output.append("Kompilierungsfehler:\n");
            output.append(errStream.toString());
        } else {
            output.append("Kompilierung erfolgreich. Starte Programm...\n");

            ProcessBuilder processBuilder = new ProcessBuilder("java", className);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            StringBuilder programOutput = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    programOutput.append(line).append(System.lineSeparator());
                }
            }

            int exitCode = process.waitFor();
            output.append("Ausgabe des Programms:\n");
            output.append(programOutput.toString());

            if (programOutput.toString().trim().equals(antwort)) {
                output.append("\n✅ Aufgabe erfüllt: ").append(antwort).append(" korrekt ausgegeben!");
            } else {
                output.append("\n❌ Aufgabe nicht korrekt gelöst.");
            }
        }

        Files.deleteIfExists(sourceFile);
        Files.deleteIfExists(Paths.get(className + ".class"));

        System.out.println(output.toString());
        return output.toString();
    }


}