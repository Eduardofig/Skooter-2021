package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.IOException;

import Controler.Tela;
import Save.*;

/**
 *
 * @author Eduardo, Jonatas
 */

public class Main {

    /**
     * @param args the command line arguments
     */


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
      int temp = 30000;
      //Le arquivo para definir intervalo de autosave
      try{
        BufferedReader buffRead = new BufferedReader(new FileReader("intervaloAutoSave.txt"));
        String linha = "";
        linha = buffRead.readLine();
        if(linha!=null){
          temp = Integer.parseInt(linha);
        }
        buffRead.close();
      }catch(FileNotFoundException ex){
        System.out.println(ex);
      }catch (IOException ex){
        System.out.println(ex);
      }

      as.iniciaAutoSave(tTela.getFWrapper(),temp);
    }
}
