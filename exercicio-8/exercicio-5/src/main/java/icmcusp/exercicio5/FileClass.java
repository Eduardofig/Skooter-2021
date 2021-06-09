/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icmcusp.exercicio5;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/**
 *
 * @author jonat
 */
public class FileClass {
    
    

    public void EscritaDeObjetosCompacta(String sAFile) {
        try {
            File fTemp = new File(sAFile+".zip");
            if (fTemp.exists()) {
                fTemp.createNewFile();
            }

            DadosPessoais dp = new DadosPessoais("Aurelio Migliori", 71, "00000-00", "Guará", "SP");
            Filmes f = new Filmes("Me and Earl and the dying girl", 2015);

            FileOutputStream canoOut = new FileOutputStream(fTemp);
            GZIPOutputStream compactador = new GZIPOutputStream(canoOut);
            ObjectOutputStream serializador = new ObjectOutputStream(compactador);

            
            serializador.writeObject(dp);
            serializador.writeObject(f);

            serializador.close();
            compactador.close();
            canoOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void LeituraDeObjetosCompactos(String sAFile){
        try {
            File fTemp = new File(sAFile);
            if (fTemp.exists()) {
                fTemp.createNewFile();
            }
            DadosPessoais dp;
            Filmes f;
           

            FileInputStream canoIn = new FileInputStream(sAFile);
            GZIPInputStream gis = new GZIPInputStream(canoIn);
            ObjectInputStream deserializador = new ObjectInputStream(gis);
            
            /*FileInputStream fin = new FileInputStream("c:\\address.gz");
            GZIPInputStream gis = new GZIPInputStream(fin);
            ObjectInputStream ois = new ObjectInputStream(gis);*/

            dp = (DadosPessoais) deserializador.readObject();
            f = (Filmes) deserializador.readObject();
            System.out.println(dp);
            System.out.println(f);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
