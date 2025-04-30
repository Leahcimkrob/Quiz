package quiz;

public class AufgabenTrainer {
    public static void main(String[] args) {
        Aufgabe aufgabe1 = new MultipleChoiceFrage();
        Aufgabe aufgabe2 = new JavaProgrammFrage();

        aufgabe1.stelleFrage();
        aufgabe1.leseAntwort();
        aufgabe1.pruefeAntwort();

        System.out.println("---");

        aufgabe2.stelleFrage();
        aufgabe2.leseAntwort();
        aufgabe2.pruefeAntwort();
    }
}
