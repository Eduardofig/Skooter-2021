import java.lang.Math;

public class OperadorMultiplos3 implements Operador {
    final Operador proxOperador = new OperadorMultiplos2();

    public double raizQuadrada(double num) {
        if(num % 3 != 0) {
            return this.proxOperador.raizQuadrada(num);
        } else {
            System.out.println("Calculado Com OperadorMultiplos3");
            return Math.sqrt(num);
        }

    }

    public double quadrado(double num) {
        if(num % 3 != 0) {
            return this.proxOperador.quadrado(num);
        } else {
            System.out.println("Calculado Com OperadorMultiplos3");
            return Math.pow(num, 2);
        }
    }
}
