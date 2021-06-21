package Modelo;

/**
 *
 * @author Eduardo, Jonatas
 */

public class BlocoNaoInteragivel extends Elemento {
    public BlocoNaoInteragivel(String sNomeImagePNG, int linha, int coluna) {
        super(sNomeImagePNG, linha, coluna);
        this.setbTransponivel(false);
    }
}
