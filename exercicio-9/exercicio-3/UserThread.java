import java.util.logging.Level;
import java.util.logging.Logger;


public class UserThread extends Thread{
  ContaBancaria c;

  public UserThread (ContaBancaria c){
    this.c = c;
  }

  public void run(){
    for(int i = 0; i <= 5000; i++){
      c.deposita(300);
      c.saca(300);
      /*int saldo = c.saldo;
      System.out.println(saldo);*/
    }
  }
}
