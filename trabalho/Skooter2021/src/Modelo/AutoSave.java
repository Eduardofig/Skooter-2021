package Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

import Data.Fases;
import Auxiliar.FasesWrapper;
/**
 *
 * @author Eduardo, Jonatas
 */

public class AutoSave extends Thread{
  private FasesWrapper fWrapper;
  private int temp;
  private boolean running = true;

  public AutoSave(FasesWrapper sWrapper,int temp){
    this.fWrapper = sWrapper;
    this.temp = temp;
  }

  public void run(){
    while(running){
      Salvar sJogo = new Salvar();
      try {
        sJogo.salvarFase(this.fWrapper.getFases());
        System.out.println("Salvou");
        Thread.sleep(2000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
    }
  }
}
