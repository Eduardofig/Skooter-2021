import java.lang.Math;

public class OperadorGeral implements Operador {
    public double raizQuadrada(double num) {
        System.out.println("Calculado Com OperadorGeral");
        return Math.sqrt(num);
    }

    public double quadrado(double num) {
        System.out.println("Calculado Com OperadorGeral");
        return Math.pow(num, 2);
    }
}
