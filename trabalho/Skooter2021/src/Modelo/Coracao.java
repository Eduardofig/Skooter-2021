/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenhador;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Random;

/**
 *
 * @author jonatas
 */
public class Coracao extends Colecionavel implements Serializable {

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
