import java.util.logging.Level;
import java.util.logging.Logger;


public class UserThread extends Thread{
  ContaBancaria c;

  public UserThread (ContaBancaria c){
    this.c = c;
  }

  public void run(){
    for(int i = 0; i <= 5000; i++){
      c.saca(300);
      c.saca(700);
      c.saca(200);
      c.saca(100);
      c.deposita(300);
      c.saca(500);
    }
  }
}
