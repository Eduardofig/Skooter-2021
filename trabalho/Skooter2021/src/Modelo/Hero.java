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
/**
 *
 * @author Junio
 */
public class Hero extends Elemento implements Serializable {

    protected boolean Energizado;
    protected int numVidas;
    protected int tempoEnergizado;
    protected Posicao Olhando;

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
        this.Energizado = sEnergizado;
    }

    public boolean isEnergizado() {
        return this.Energizado;
    }

    public Hero(String sNomeImagePNG, int linha, int coluna) {
        super(sNomeImagePNG, linha, coluna);
        this.Olhando = new Posicao(0, 0);
        setNumVidas(4);
        setEnergizado(false);
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
        return true;
    }
    public boolean moveUp() {
        this.setPosicao(this.getPosicao().getLinha() - 1, this.getPosicao().getColuna());
        this.setOlhando(this.getPosicao().getLinha() - 1, this.getPosicao().getColuna());
        return true;
    }
    public boolean moveRight() {
        this.setPosicao(this.getPosicao().getLinha(), this.getPosicao().getColuna() + 1);
        this.setOlhando(this.getPosicao().getLinha(), this.getPosicao().getColuna() + 1);
        return true;
    }
    public boolean moveDown() {
        this.setPosicao(this.getPosicao().getLinha() + 1, this.getPosicao().getColuna());
        this.setOlhando(this.getPosicao().getLinha() + 1, this.getPosicao().getColuna());
        return true;
    }

    public void removerBloco(ArrayList<Elemento> listaBlocosInteragiveis, ArrayList<Elemento> eElementos) {
        for(int i = 0; i < listaBlocosInteragiveis.size(); i++) {
            Elemento bBloco = listaBlocosInteragiveis.get(i);
            if(bBloco.pPosicao.estaNaMesmaPosicao(this.getOlhando())){
                eElementos.remove(bBloco);
                return;
            } 
        }
    }

    public void ficarEnergizado() {
        setEnergizado(true);
        System.out.println("Esta Energizado");
        //Fica energizado por 90 frames
        this.tempoEnergizado = 90;
    }
}
