import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import java.math.BigInteger;

public class Main{
  public static void main(String args[]){
    Random r = new Random();
    RaizQuadrada rq = new RaizQuadrada();
    double j;
    int i;

    //Implementando alternativa a
    long inicioa = System.currentTimeMillis();
    for(i = 0; i<= 10000000; i++){
      j = r.nextDouble();
      rq.RaizQuadrada(j);
    }
    long finala = System.currentTimeMillis();
    System.out.println("Alternativa A\nTempo de execucao: " + (finala-inicioa)+ "ms\n");

    //Implementando alternativa b
    long iniciob = System.currentTimeMillis();
      try {
        long TotalDeCalculos = 10000000;
        int nCores = Runtime.getRuntime().availableProcessors();
        ThreadCalculador[] cs = new ThreadCalculador[nCores];
        for (i = 0; i < nCores; i++) {
          /*Cada core recebe uma fatia igual da carga*/
          cs[i] = new ThreadCalculador(TotalDeCalculos / nCores);
          cs[i].start();
        }
        for (i = 0; i < nCores; i++) {
          cs[i].join();
        }
      } catch (InterruptedException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
      }
    long finalb = System.currentTimeMillis();
    System.out.println("Alternativa B\nTempo de execucao: " + (finalb - iniciob) + " ms\n");

    //Implementando alternativa c
    BigInteger k;
    long tempct;
    long tempst;

    System.out.println("Alternativa C");

    //10⁷
    //Sem thread
    long inicioc = System.currentTimeMillis();
      for(k = BigInteger.valueOf(0);k.compareTo(new BigInteger("10000000"))<=0;k=k.add(BigInteger.ONE)){
        j = r.nextDouble();
      }
    long finalc = System.currentTimeMillis();
    tempst = (finalc - inicioc);

      //Com thread
      /*inicioc = System.currentTimeMillis();
        try {
          int nCores = Runtime.getRuntime().availableProcessors();
          ThreadCalculador[] cs = new ThreadCalculador[nCores];
          for (i = 0; i < nCores; i++) {
            cs[i] = new ThreadCalculador(contador / nCores);
            cs[i].start();
          }
          for (i = 0; i < nCores; i++) {
            cs[i].join();
          }
        } catch (InterruptedException ex) {
          Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
      finalc = System.currentTimeMillis();
      tempct = finalc - inicioc;

      //Exibe as informações
      System.out.println("Potencia da carga de processamento: 10^" + potencia);
      System.out.println("Tempo de processamento sem thread: " + tempst + " ms");
      System.out.println("Tempo de processamento com thread: " + tempct + " ms\n");
      potencia++; */

      System.out.println("Potencia da carga de processamento: 10^7");
      System.out.println("Tempo de processamento sem thread: " + tempst + " ms");

    //Fim alternativa C
  }
}
