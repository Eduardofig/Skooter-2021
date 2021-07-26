package Modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import Data.Fases;
import Auxiliar.FasesWrapper;
/**
 *
 * @author Eduardo, Jonatas
 */
 public class ChamaAutoSave extends Thread{

   public void iniciaAutoSave(Fases fFases){
     AutoSave asJogo = new AutoSave(fFases,2000);

     asJogo.start();
     try{
       asJogo.join();
     }catch(InterruptedException ex){
       Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
     }
   }
 }
