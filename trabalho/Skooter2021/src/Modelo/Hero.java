package Modelo;

import Auxiliar.Posicao;
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

public class Hero extends Elemento {

    protected boolean Energizado;
    protected int numVidas;
    protected int tempoEnergizado;
    protected int iDeslocadorSprites;
    protected Posicao Olhando;
    protected ArrayList<ImageIcon> iSprites;

    public void processarEnergizado() {
        if(!this.isEnergizado()) return;
        if(this.tempoEnergizado == 0) {
            this.setEnergizado(false);
            System.out.println("Nao esta mais Energizado");
            return;
        }
        this.tempoEnergizado--;
        System.out.println("Tempo Energizado: " + String.valueOf(this.tempoEnergizado));
    }

    public Posicao getOlhando() {
        return this.Olhando;
    }

    public void setOlhando(int linha, int coluna) {
        this.Olhando.setPosicao(linha, coluna);
    }

    public void setNumVidas(int sNumVidas) {
        this.numVidas = sNumVidas;
    }

    public int getNumVidas() {
        return this.numVidas;
    }

    public void setEnergizado(boolean sEnergizado) {
        if(sEnergizado) this.iDeslocadorSprites = 4;
        else this.iDeslocadorSprites = 0;
        this.Energizado = sEnergizado;
    }

    public boolean isEnergizado() {
        return this.Energizado;
    }

    public Hero(ArrayList<String> sNomeImages, int linha, int coluna) {
        super(sNomeImages.get(0), linha, coluna);

        ImageIcon Image;
        Image img;
        BufferedImage bi;
        Graphics g;

        this.iSprites = new ArrayList<ImageIcon>();
        this.iDeslocadorSprites = 0;
        this.Olhando = new Posicao(0, 0);
        setNumVidas(4);
        setEnergizado(false);

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

    //Metodo chamado quando o heroi morre
    public void morrer() {
        if(this.numVidas > 1) {
            this.numVidas--;
            System.out.println("Voce Morreu");
            System.out.println("Numero de vidas: " + String.valueOf(this.numVidas));
            return;
        }
        System.out.println("Game Over");
        System.exit(0);
    }

    //Overrides dos metodos move
    public boolean moveLeft() {
        this.setPosicao(this.getPosicao().getLinha(), this.getPosicao().getColuna() - 1);
        this.setOlhando(this.getPosicao().getLinha(), this.getPosicao().getColuna() - 1);
        this.mudarImagem(this.iSprites.get(1 + this.iDeslocadorSprites));
        return true;
    }
    public boolean moveUp() {
        this.setPosicao(this.getPosicao().getLinha() - 1, this.getPosicao().getColuna());
        this.setOlhando(this.getPosicao().getLinha() - 1, this.getPosicao().getColuna());
        this.mudarImagem(this.iSprites.get(2 + this.iDeslocadorSprites));
        return true;
    }
    public boolean moveRight() {
        this.setPosicao(this.getPosicao().getLinha(), this.getPosicao().getColuna() + 1);
        this.setOlhando(this.getPosicao().getLinha(), this.getPosicao().getColuna() + 1);
        this.mudarImagem(this.iSprites.get(3 + this.iDeslocadorSprites));
        return true;
    }
    public boolean moveDown() {
        this.setPosicao(this.getPosicao().getLinha() + 1, this.getPosicao().getColuna());
        this.setOlhando(this.getPosicao().getLinha() + 1, this.getPosicao().getColuna());
        this.mudarImagem(this.iSprites.get(0 + this.iDeslocadorSprites));
        return true;
    }

    public boolean removerBloco(ArrayList<Elemento> listaBlocosInteragiveis, ArrayList<Elemento> eElementos) {
        for(int i = 0; i < listaBlocosInteragiveis.size(); i++) {
            BlocoInteragivel bBloco = (BlocoInteragivel)listaBlocosInteragiveis.get(i);
            if(!bBloco.isDestruivel()) return false;
            if(bBloco.pPosicao.estaNaMesmaPosicao(this.getOlhando())){
                eElementos.remove(bBloco);
                return true;
            } 
        }
        return false;
    }

    public void ficarEnergizado() {
        setEnergizado(true);
        System.out.println("Esta Energizado");
        //Fica energizado por 90 frames
        this.tempoEnergizado = 90;
    }
}
