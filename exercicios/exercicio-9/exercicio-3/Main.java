import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main{
  public static void main(String args[]){
    ContaBancaria c1 = new ContaBancaria(1000);
    ContaBancariaSync c2 = new ContaBancariaSync(1000);

    // Conta1 com problemas de processamento em paralelo sem sincronia
    UserThread ut = new UserThread(c1);
    BankThread bt = new BankThread(c1);
    ut.start();
    bt.start();
    try{
      ut.join();
      bt.join();
    }catch(InterruptedException ex){
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }

    int saldo1 = c1.saldo();
    System.out.println("Threads rodando sem sincronia gera o saldo abaixo não deterministico");
    System.out.println(saldo1 + "\n");

    // Conta 2 usando sincronização
    UserThreadSync ut2 = new UserThreadSync(c2);
    BankThreadSync bt2 = new BankThreadSync(c2);
    ut2.start();
    bt2.start();
    try{
      ut2.join();
      bt2.join();
    }catch(InterruptedException ex){
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }

    int saldo2 = c2.saldo();
    System.out.println("Threads rodando com sincronia gera o saldo abaixo deterministico\n");
    System.out.println(saldo2);
  }
}
