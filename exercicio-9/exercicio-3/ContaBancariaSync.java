import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContaBancariaSync{
  protected int saldo;

  public ContaBancariaSync(int saldo){
    this.saldo = saldo;
  }

  synchronized public void deposita(int iValor){
    this.saldo += iValor;
  }

  synchronized public int saca(int iValor){
    this.saldo -= iValor;
    return this.saldo;
  }

  synchronized public int saldo(){
    return this.saldo;
  }
}
