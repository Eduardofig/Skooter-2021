package Modelo;

/**
 *
 * @author Eduardo, Jonatas
 */

public class Colecionavel extends Elemento {

    public Colecionavel(String sNomeImagePNG, int linha, int coluna) {
        super(sNomeImagePNG, linha, coluna);
        this.setbTransponivel(false);
    }
}
