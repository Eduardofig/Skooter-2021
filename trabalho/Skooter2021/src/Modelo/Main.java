package Modelo;

import Controler.Tela;
import Modelo.ChamaAutoSave;

/**
 *
 * @author Eduardo, Jonatas
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              Controle c1 = new Controle();
              c1.run();
            }
        });

    }*/


    public static void main(String[] args){
        ChamaAutoSave as = new ChamaAutoSave();
          Tela tTela = new Tela();
      java.awt.EventQueue.invokeLater(new Runnable(){
        public void run(){
          tTela.setVisible(true);
          tTela.createBufferStrategy(2);
          tTela.go();
        }
      });
      as.iniciaAutoSave(tTela.getFWrapper());
    }
}
