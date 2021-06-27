import java.util.logging.Level;
import java.util.logging.Logger;


public class UserThreadSync extends Thread{
  ContaBancariaSync c;

  public UserThreadSync (ContaBancariaSync c){
    this.c = c;
  }

  public void run(){
    for(int i = 0; i <= 5000; i++){
      c.deposita(300);
      c.saca(300);
    }
  }
}
