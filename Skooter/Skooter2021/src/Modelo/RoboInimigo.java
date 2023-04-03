package Modelo;

import java.util.Random;
import Auxiliar.Consts;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.ImageIcon;

/**
 *
 * @author Eduardo, Jonatas
 */

public class RoboInimigo extends Elemento {

    protected Random rRandom;
    protected int iAtrasador;
    protected ArrayList<ImageIcon> iSprites;

    public RoboInimigo(ArrayList<String> sNomeImages, int linha, int coluna) {
        super(sNomeImages.get(0), linha, coluna);

        ImageIcon Image;
        Image img;
        BufferedImage bi;
        Graphics g;

        this.rRandom = new Random();
        this.iAtrasador = 0;
        this.setbTransponivel(false);
        this.iSprites = new ArrayList<ImageIcon>();

        for(int i = 0; i < sNomeImages.size(); i++) {
            try {
                Image = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImages.get(i));
                img = Image.getImage();
                bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
                g = bi.createGraphics();
                g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                this.iSprites.add(new ImageIcon(bi));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
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
                this.mudarImagem(this.iSprites.get(1));
                return;
            case 1:
                this.moveRight();
                this.mudarImagem(this.iSprites.get(2));
                return;
            case 2:
                this.moveUp();
                this.mudarImagem(this.iSprites.get(3));
                return;
            default:
                this.moveDown();
                this.mudarImagem(this.iSprites.get(0));
                return;
        }
    }
}
