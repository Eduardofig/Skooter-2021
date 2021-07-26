package Modelo;

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

    /*while(running){
      Thread.sleep(this.temp);
    }*/
  }

  /*public void run(){
    new AutoSave();
    try{
      this.AutoSave.join();
    }catch(InterruptedException ex){
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
  }*/

  public void encerrarAutoSave(){
    this.running = false;
  }

  /*public static void main(String[] args){
    AutoSave aSave = new AutoSave(fFases,temp);
    aSave.start();
    try{
      aSave.join();
    }catch(InterruptedException ex){
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
  }*/
}
