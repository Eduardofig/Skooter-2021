package ArquivosElemento;

import Behaviors.*;
import Modelo.ElementoGenerico;
import Auxiliar.ModeloFactory;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        ModeloFactory factory = new ModeloFactory();
        ElementoGenerico eGenerico1 = (ElementoGenerico)factory.criarElemento("ElementoGenerico", "colecionaveis" + File.separator + "sol.png", 0, 0, new BehaviorTeletransportador());
        ElementoGenerico eGenerico2 = (ElementoGenerico)factory.criarElemento("ElementoGenerico", "colecionaveis" + File.separator + "lampada.png", 0, 0, new BehaviorOscilador());
        try {
            FileOutputStream ofStream = new FileOutputStream("ElementoTransportador.obj");
            ObjectOutputStream obStream = new ObjectOutputStream(ofStream);
            obStream.writeObject(eGenerico1);
            obStream.close();

            FileOutputStream ofStream2 = new FileOutputStream("ElementoOscilador.obj");
            ObjectOutputStream obStream2 = new ObjectOutputStream(ofStream2);
            obStream2.writeObject(eGenerico2);
            obStream2.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
