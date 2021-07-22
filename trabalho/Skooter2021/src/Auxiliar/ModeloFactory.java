import Modelo.*;
import java.util.ArrayList;

public class ModeloFactory {
    public Elemento criarElemento(String seletor, String sNomeImagePNG, int linha, int coluna) {
        switch(seletor) {
            case "BlocoSeta":
                return new BlocoSeta(sNomeImagePNG, sOrientacaArgs[0], linha, coluna);
            case "Colecionavel":
                return new Colecionavel(sNomeImagePNG, linha, coluna);
            case "Coracao":
                return new Coracao(sNomeImagePNG, linha, coluna);
        }
    }

    //Method overloading para Elementos do tipo BlocoNaoInteragivel
    public Elemento criarElemento(String seletor, int linha, int coluna, int sOrientacao) {
        switch (seletor) {
            default:
                return new BlocoNaoInteragivel(sNomeImagePNG[0], linha, coluna);
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
}
