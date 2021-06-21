package Modelo;

import java.util.Random;

/**
 *
 * @author Eduardo, Jonatas
 */

public class RoboInimigo extends Elemento {

    protected Random rRandom;
    protected int iAtrasador;

    public RoboInimigo(String sNomeImagePNG, int linha, int coluna) {
        super(sNomeImagePNG, linha, coluna);
        this.rRandom = new Random();
        this.iAtrasador = 0;
        this.setbTransponivel(false);
    }
    public void move() {
        if(iAtrasador > 0) {
            iAtrasador--;
            return;
        }
        iAtrasador = 2;
        switch(this.rRandom.nextInt(4)) {
            case 0:
                this.moveLeft();
                return;
            case 1:
                this.moveRight();
                return;
            case 2:
                this.moveUp();
                return;
            default:
                this.moveDown();
                return;
        }
    }
}
