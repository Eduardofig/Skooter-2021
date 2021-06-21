package Modelo;

import java.util.Random;

/**
 *
 * @author Eduardo, Jonatas
 */
public class Coracao extends Elemento {

    protected Random rRandom;
    protected int iAtrasador;

    public Coracao(String sNomeImagePNG, int linha, int coluna) {
        super(sNomeImagePNG, linha, coluna);
        this.rRandom = new Random();
        this.iAtrasador = 0;
    }

    public void move() {
        if(this.iAtrasador > 0) {
            this.iAtrasador--;
            return;
        }
        this.iAtrasador = 1;
        switch(this.rRandom.nextInt(3)) {
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
