package Modelo;

import Data.Fases;
/**
 *
 * @author Eduardo, Jonatas
 */
public class Salvar extends Thread{
  private Fases fFases;
  private int temp;
  private boolean running = true;

  public void setTemp(int temp){
    this.temp = temp;
  }
}
