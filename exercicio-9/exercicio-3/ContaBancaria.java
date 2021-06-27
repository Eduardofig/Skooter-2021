import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContaBancaria{
  protected int saldo;
  public ContaBancaria(int saldo){
    this.saldo = saldo;
  }

  public void deposita(int iValor){
    this.saldo += iValor;
  }

  public int saca(int iValor){
    this.saldo -= iValor;
    return this.saldo;
  }

  public int saldo(){
    return this.saldo;
  }
}
