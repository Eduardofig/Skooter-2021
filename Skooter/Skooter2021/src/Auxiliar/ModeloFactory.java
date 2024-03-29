package Auxiliar;

import Modelo.*;
import Behaviors.Behavior;
import java.util.ArrayList;

//Factory Design pattern
public class ModeloFactory {
    public Elemento criarElemento(String seletor, String sNomeImagePNG, int linha, int coluna) {
        switch(seletor) {
            case "Colecionavel":
                return new Colecionavel(sNomeImagePNG, linha, coluna);
            case "BlocoNaoInteragivel":
                return new BlocoNaoInteragivel(sNomeImagePNG, linha, coluna);
            case "BlocoInteragivel":
                return new BlocoInteragivel(sNomeImagePNG, linha, coluna);
            default:
                return new Coracao(sNomeImagePNG, linha, coluna);
        }
    }

    //Method overloading para Elementos do tipo BlocoNaoInteragivel
    public Elemento criarElemento(String seletor, String sNomeImagePNG, int sOrientacao, int linha, int coluna) {
        switch (seletor) {
            default:
                return new BlocoSeta(sNomeImagePNG, sOrientacao, linha, coluna);
        }
    }

    //Method overloading para Elementos do tipo Hero e Robo Inimigo
    public Elemento criarElemento(String seletor, ArrayList<String> sNomeImagePNGList, int linha, int coluna) {
        switch(seletor) {
            case "Hero":
                return new Hero(sNomeImagePNGList, linha, coluna);
            default:
                return new RoboInimigo(sNomeImagePNGList, linha, coluna);
        }
    }

    //Method overloading para Elementos do tipo ElementoGenerico
    public Elemento criarElemento(String seletor, String sNomeImagePNG, int linha, int coluna, Behavior bBehavior) {
        switch(seletor) {
            default:
                return new ElementoGenerico(sNomeImagePNG, linha, coluna, bBehavior);
        }
    }
}
