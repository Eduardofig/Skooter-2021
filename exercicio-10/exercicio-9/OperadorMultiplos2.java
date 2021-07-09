import java.lang.Math;

public class OperadorMultiplos2 implements Operador {
    final Operador proxOperador = new OperadorGeral();

    public double raizQuadrada(double num) {
        if(num % 2 != 0) {
            return this.proxOperador.raizQuadrada(num);
        } else {
            return Math.sqrt(num);
        }

    }

    public double quadrado(double num) {
        if(num % 2 != 0) {
            return this.proxOperador.quadrado(num);
        } else {
            return Math.pow(num, 2);
        }
    }
}
