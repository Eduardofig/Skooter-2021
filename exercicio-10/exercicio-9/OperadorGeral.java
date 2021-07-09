import java.lang.Math;

public class OperadorGeral implements Operador {
    public double raizQuadrada(double num) {
        return Math.sqrt(num);
    }

    public double quadrado(double num) {
        return Math.pow(num, 2);
    }
}
