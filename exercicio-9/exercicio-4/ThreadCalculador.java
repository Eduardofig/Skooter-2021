import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

public class ThreadCalculador extends Thread{
    private long nCalculations;
    Random r;
    RaizQuadrada rq;

    public ThreadCalculador(long iNCalculations){
        nCalculations = iNCalculations;
        r = new Random();
        rq = new RaizQuadrada();
    }

    public void run(){
        for(long i = 0; i < nCalculations; i++){
            rq.RaizQuadrada(r.nextDouble());
        }
    }
}
