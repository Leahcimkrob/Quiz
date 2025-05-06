package quiz;

import java.util.Scanner;

/**
 * 
 */
public class JavaCheckerBack implements Aufgabe {
	String frage = "";
	String antwort = "";
	
	@Override
	public void initialiereFrage() {
		frage = "public class HelloWorld {\n"
				+ "	\n"
				+ "	/**\n"
				+ "	 * @param args\n"
				+ "	 */\n"
				+ "	public static void main(String[] args) {\n"
				+ "		System.out.println(\"Hello World\");\n"
				+ "	}\n"
				+ "	\n"
				+ "}\n"
				+ "";
		antwort = "Hello World";
	}

	@Override
	public void stelleFrage() {
		System.out.println(frage);
		System.out.println("Was macht dieses Java-Programm mit Aufruf von main?");
		System.out.println("Antwort bitte in einer Zeile");
	}

	@Override
	public String leseAntwort(Scanner scanner) {
		String auswahl = scanner.nextLine();
		return auswahl;
	}

	@Override
	public void pruefeAntwort(String gegebemeAntwort) {
		boolean resultCheck = antwort.equals(gegebemeAntwort);
		if(resultCheck) {
			System.out.println("Korrekte Antwort");
		} else {
			System.out.println("falsche Antwort");
		}
	}

}
