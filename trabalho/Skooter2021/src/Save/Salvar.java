package Save;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import Auxiliar.FasesWrapper;
import Auxiliar.Fase;
import Data.Fases;

/**
 *
 * @author Eduardo, Jonatas
 */
public class Salvar extends Thread{

    public void salvarFase(Fases fFases){
        try{
            File fTemp = new File("save.zip");
            if(fTemp.exists()){
                fTemp.createNewFile();
            }

            FileOutputStream canoOut = new FileOutputStream(fTemp);
            GZIPOutputStream compactador = new GZIPOutputStream(canoOut);
            ObjectOutputStream serializador = new ObjectOutputStream(compactador);


            serializador.writeObject(fFases);

            serializador.close();
            compactador.close();
            canoOut.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void carregarFase(FasesWrapper fWrapper){
        try {
            File fTemp = new File("save.zip");

            if (fTemp.exists()) {
                fTemp.createNewFile();
            }

            FileInputStream canoIn = new FileInputStream("save.zip");
            GZIPInputStream gis = new GZIPInputStream(canoIn);
            ObjectInputStream deserializador = new ObjectInputStream(gis);

            fWrapper.loadFases((Fases) deserializador.readObject());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
