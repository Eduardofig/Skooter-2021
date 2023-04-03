import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import java.math.BigInteger;

public class BigThreadCalculador extends Thread{
    private BigInteger nCalculations;
    Random r;
    double j;

    public BigThreadCalculador(BigInteger iNCalculations){
        nCalculations = iNCalculations;
        r = new Random();
    }

    public void run(){
        for(BigInteger n = BigInteger.valueOf(0);n.compareTo(nCalculations) <=0;n=n.add(BigInteger.ONE)){
          j = r.nextDouble();
          Math.sqrt(j);
        }
    }
}
