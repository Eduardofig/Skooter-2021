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
    int saldoTemporario = this.saldo;
    saldoTemporario += iValor;
    System.out.println("Saldo temporario: " + saldoTemporario);
    this.saldo = saldoTemporario;
  }

  public int saca(int iValor){
    int saldoTemporario = this.saldo;
    saldoTemporario -= iValor;
    System.out.println("Saldo temporario: " + saldoTemporario);
    this.saldo = saldoTemporario;
    return this.saldo;
  }

  public int saldo(){
    return this.saldo;
  }
}
