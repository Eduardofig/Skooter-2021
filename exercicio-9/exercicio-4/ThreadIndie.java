import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

public class ThreadIndie extends Thread{
  RaizQuadrada rq = new RaizQuadrada();
  Random r = new Random();
  double j;
  long potencia;

  public ThreadIndie(long potencia){
    this.potencia = potencia;
  }

  public void run(){
    for(int i = 0; i<= 10000000; i++){
      j = r.nextDouble();
      rq.RaizQuadrada(j);
    }
  }
}
