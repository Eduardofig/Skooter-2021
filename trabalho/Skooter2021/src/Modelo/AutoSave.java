package Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

import Data.Fases;
/**
 *
 * @author Eduardo, Jonatas
 */

public class AutoSave extends Thread{
  private Fases fFases;
  private int temp;
  private boolean running = true;

  public AutoSave(Fases fFases,int temp){
    this.fFases = fFases;
    this.temp = temp;
  }

  public void run(){
    while(running){
      Salvar sJogo = new Salvar();
      try {
        sJogo.salvarFase(this.fFases);
        Thread.sleep(2000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
    }
  }
}
