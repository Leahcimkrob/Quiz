package quiz;

public class FehlerProgramm {
    public static void main(String[] args) {
        int x = 10;
        int y = 0;
        int z = x / y;  // ⛔ Division durch 0 – Laufzeitfehler
        System.out.println("Ergebnis: " + z);
    }
}
