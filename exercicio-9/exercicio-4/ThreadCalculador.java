import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

public class ThreadCalculador extends Thread{
    private long nCalculations;
    Random r;
    double j;

    public ThreadCalculador(long iNCalculations){
        nCalculations = iNCalculations;
        r = new Random();
    }

    public void run(){
        for(long i = 0; i < nCalculations; i++){
            j = r.nextDouble();
            Math.sqrt(j);
        }
    }
}
