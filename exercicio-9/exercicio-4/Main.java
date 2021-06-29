import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import java.math.BigInteger;
import java.lang.Math;

public class Main{
  public static void main(String args[]){
    Random r = new Random();
    double j;
    int i;

    //Implementando alternativa a
    long inicioa = System.currentTimeMillis();
    for(i = 0; i<= 10000000; i++){
      j = r.nextDouble();
      Math.sqrt(j);
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
    BigInteger[] k = new BigInteger[5];
    k[0] = new BigInteger("10000000"); //10⁷
    k[1] = new BigInteger("100000000"); //10⁸
    k[2] = new BigInteger("1000000000"); //10⁹
    k[3] = new BigInteger("10000000000"); //10¹0
    k[4] = new BigInteger("100000000000"); //10¹1
    long tempct;
    long tempst;
    int m=0;
    int potencia = 7;
    BigInteger n;

    System.out.println("Alternativa C");
    while(m < 4){
      //Sem thread
      long inicioc = System.currentTimeMillis();
        for(n = BigInteger.valueOf(0);n.compareTo(k[m]) <=0;n=n.add(BigInteger.ONE)){
          j = r.nextDouble();
          Math.sqrt(j);
        }
      long finalc = System.currentTimeMillis();
      tempst = (finalc - inicioc);

      //Com thread
      inicioc = System.currentTimeMillis();
        try {
          int nCores = Runtime.getRuntime().availableProcessors();
          BigThreadCalculador[] cs = new BigThreadCalculador[nCores];
          for (i = 0; i < nCores; i++) {
            BigInteger nc = BigInteger.valueOf(nCores);
            cs[i] = new BigThreadCalculador(k[m].divide(nc));
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
      potencia++;
      m++;
    }
    //Fim alternativa C

    //Implementando alternativa D
    m = 0;
    potencia = 7;
    System.out.println("Alternativa D");
    while(m < 4){
      //Sem thread
      long iniciod = System.currentTimeMillis();
        for(n = BigInteger.valueOf(0);n.compareTo(k[m]) <=0;n=n.add(BigInteger.ONE)){
          j = r.nextDouble() * 5;
        }
      long finald = System.currentTimeMillis();
      tempst = (finald - iniciod);

      //Com thread
      iniciod = System.currentTimeMillis();
        try {
          int nCores = Runtime.getRuntime().availableProcessors();
          BigThreadSoma[] cs = new BigThreadSoma[nCores];
          for (i = 0; i < nCores; i++) {
            BigInteger nc = BigInteger.valueOf(nCores);
            cs[i] = new BigThreadSoma(k[m].divide(nc));
            cs[i].start();
          }
          for (i = 0; i < nCores; i++) {
            cs[i].join();
          }
        } catch (InterruptedException ex) {
          Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
      finald = System.currentTimeMillis();
      tempct = finald - iniciod;

      //Exibe as informações
      System.out.println("Potencia da carga de processamento: 10^" + potencia);
      System.out.println("Tempo de processamento sem thread: " + tempst + " ms");
      System.out.println("Tempo de processamento com thread: " + tempct + " ms\n");
      potencia++;
      m++;
    }
    //Fim alternativa D

    //Implementando alternativa E
    m = 0;
    potencia = 7;
    System.out.println("Alternativa E");
    while(m < 4){
      //Sem thread
      long iniciod = System.currentTimeMillis();
      double temp;
        for(n = BigInteger.valueOf(0);n.compareTo(k[m]) <=0;n=n.add(BigInteger.ONE)){
          temp = r.nextDouble();
          j = (Math.pow(temp,2)) + (Math.sqrt(temp)) + (Math.cos(temp));
        }
      long finald = System.currentTimeMillis();
      tempst = (finald - iniciod);

      //Com thread
      iniciod = System.currentTimeMillis();
        try {
          int nCores = Runtime.getRuntime().availableProcessors();
          BigThreadEquacao[] cs = new BigThreadEquacao[nCores];
          for (i = 0; i < nCores; i++) {
            BigInteger nc = BigInteger.valueOf(nCores);
            cs[i] = new BigThreadEquacao(k[m].divide(nc));
            cs[i].start();
          }
          for (i = 0; i < nCores; i++) {
            cs[i].join();
          }
        } catch (InterruptedException ex) {
          Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
      finald = System.currentTimeMillis();
      tempct = finald - iniciod;

      //Exibe as informações
      System.out.println("Potencia da carga de processamento: 10^" + potencia);
      System.out.println("Tempo de processamento sem thread: " + tempst + " ms");
      System.out.println("Tempo de processamento com thread: " + tempct + " ms\n");
      potencia++;
      m++;
    }
    //Fim alternativa E
  }
}
