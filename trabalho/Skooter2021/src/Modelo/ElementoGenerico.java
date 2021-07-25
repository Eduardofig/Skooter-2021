package Modelo;

import Behaviors.Behavior;

/**
 *
 * @author Eduardo, Jonatas
 */

public class ElementoGenerico extends Elemento {

    protected Behavior bBehavior;

    public void acao() {
        this.bBehavior.agir(this.getPosicao());
    }

    public ElementoGenerico(String sNomeImagePNG, int linha, int coluna, Behavior sBehavior) {
        super(sNomeImagePNG, linha, coluna);
        this.bBehavior = sBehavior;
    }
}
