import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import java.math.BigInteger;
import java.lang.Math;


public class BigThreadEquacao extends Thread{
    private BigInteger nCalculations;
    Random r;
    double j;
    double temp;

    public BigThreadEquacao(BigInteger iNCalculations){
        nCalculations = iNCalculations;
        r = new Random();
    }

    public void run(){
        for(BigInteger n = BigInteger.valueOf(0);n.compareTo(nCalculations) <=0;n=n.add(BigInteger.ONE)){
          temp = r.nextDouble();
          j = (Math.pow(temp,2)) + (Math.sqrt(temp)) + (Math.cos(temp));
        }
    }
}
