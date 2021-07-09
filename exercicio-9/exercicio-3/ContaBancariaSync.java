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
    int saldoTemporario = this.saldo;
    saldoTemporario += iValor;
    //System.out.println("Saldo temporario: " + saldoTemporario);
    this.saldo = saldoTemporario;
  }

  synchronized public int saca(int iValor){
    int saldoTemporario = this.saldo;
    saldoTemporario -= iValor;
    //System.out.println("Saldo temporario: " + saldoTemporario);
    this.saldo = saldoTemporario;
    return this.saldo;
  }

  synchronized public int saldo(){
    return this.saldo;
  }
}
