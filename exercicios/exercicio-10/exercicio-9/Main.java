import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OperadorMultiplos3 op3 = new OperadorMultiplos3();
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();

        System.out.println("Raiz quadrada: " + op3.raizQuadrada(num));
        System.out.println("Quadrado: " + op3.quadrado(num));

        scanner.close();
    }
}
