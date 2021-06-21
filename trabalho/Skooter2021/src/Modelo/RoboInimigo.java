package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenhador;
import Auxiliar.Posicao;
import Modelo.BlocoInteragivel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jonatas
 */
public class RoboInimigo extends Elemento implements Serializable{

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
