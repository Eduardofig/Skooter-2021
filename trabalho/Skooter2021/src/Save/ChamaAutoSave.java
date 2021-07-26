package Save;

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

    public void iniciaAutoSave(FasesWrapper fWrapper, int temp){
        AutoSave asJogo = new AutoSave(fWrapper,temp);

        asJogo.start();
        try{
            asJogo.join();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
