import java.util.logging.Level;
import java.util.logging.Logger;

public class BankThread extends Thread{
  ContaBancaria c;

  public BankThread (ContaBancaria c){
    this.c = c;
  }

  public void run(){
    for(int i = 0; i <= 5000; i++){
      c.deposita(300);
      c.deposita(500);
      c.deposita(700);
      c.deposita(200);
      c.deposita(100);;
      c.saca(150);
      c.saca(150);
    }
  }
}
