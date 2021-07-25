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

        try {
            FileOutputStream ofStream = new FileOutputStream("ElementoTransportador.obj");
            ObjectOutputStream obStream = new ObjectOutputStream(ofStream);
            obStream.writeObject(eGenerico1);
            obStream.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
