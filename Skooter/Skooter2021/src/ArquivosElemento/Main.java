package ArquivosElemento;

import Behaviors.*;
import Auxiliar.BehaviorFactory;
import Modelo.ElementoGenerico;
import Auxiliar.ModeloFactory;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        ModeloFactory factory = new ModeloFactory();
        BehaviorFactory bFactory = new BehaviorFactory();

        Behavior behavior1 = bFactory.criarBehavior("BehaviorTeletransportador");
        Behavior behavior2 = bFactory.criarBehavior("BehaviorOscilador");
        Behavior behavior3 = bFactory.criarBehavior("BehaviorEstatico");

        ElementoGenerico eGenerico1 = (ElementoGenerico)factory.criarElemento("ElementoGenerico", "genericos" + File.separator + "enderman.png", 0, 0, behavior1);
        ElementoGenerico eGenerico2 = (ElementoGenerico)factory.criarElemento("ElementoGenerico", "genericos" + File.separator + "flash.png", 0, 0, behavior2);
        ElementoGenerico eGenerico3 = (ElementoGenerico)factory.criarElemento("ElementoGenerico", "genericos" + File.separator + "snorlax.png", 0, 0, behavior3);
        try {
            FileOutputStream ofStream = new FileOutputStream("ElementoTransportador.obj");
            ObjectOutputStream obStream = new ObjectOutputStream(ofStream);
            obStream.writeObject(eGenerico1);
            obStream.close();

            FileOutputStream ofStream2 = new FileOutputStream("ElementoOscilador.obj");
            ObjectOutputStream obStream2 = new ObjectOutputStream(ofStream2);
            obStream2.writeObject(eGenerico2);
            obStream2.close();

            FileOutputStream ofStream3 = new FileOutputStream("ElementoEstatico.obj");
            ObjectOutputStream obStream3 = new ObjectOutputStream(ofStream3);
            obStream3.writeObject(eGenerico3);
            obStream3.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
