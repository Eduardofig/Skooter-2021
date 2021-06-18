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
    protected Posicao Olhando;

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

    public Hero(String sNomeImagePNG) {
        super(sNomeImagePNG);
        setNumVidas(4);
        setEnergizado(false);
    }

    public void passarDeFase(ArrayList<Elemento> eElementos, ArrayList<Elemento> novaFase) {
        eElementos.clear();
        for(int i = 0; i < eElementos.size(); i++) {
            eElementos.add(eElementos.get(i));
        }
    }

    //Mudar pra ele receber uma fase e resetar a fase
    public void morrer(ArrayList<Elemento> eElementos, ArrayList<Elemento> faseAtual) {
        setNumVidas(getNumVidas() - 1);
        eElementos.clear();
        //Inserir um if que checa se ha um game over
        for(int i = 0; i < eElementos.size(); i++) {
            eElementos.add(eElementos.get(i));
        }
        System.out.println("Voce Morreu");
    }

    //Overrides dos metodos move
    public boolean moveLeft() {
        this.setPosicao(this.getPosicao().getLinha(), this.getPosicao.getColuna() - 1);
        this.setOlhando(this.getPosicao().getLinha(), this.getPosicao().getColuna() - 1);
    }
    public boolean moveUp() {
        this.setPosicao(this.getPosicao().getLinha() - 1, this.getPosicao.getColuna());
        this.setOlhando(this.getPosicao().getLinha() - 1, this.getPosicao().getColuna());
    }
    public boolean moveRight() {
        this.setPosicao(this.getPosicao().getLinha(), this.getPosicao.getColuna() + 1);
        this.setOlhando(this.getPosicao().getLinha(), this.getPosicao().getColuna() + 1);
    }
    public boolean moveDown() {
        this.setPosicao(this.getPosicao().getLinha(), this.getPosicao.getColuna());
        this.setOlhando(this.getPosicao().getLinha(), this.getPosicao().getColuna());
    }

    //Funcao que eh chamada quando o heroi destroi o bloco interagivel
    public void empurrarBloco(BlocoInteragivel bBloco, int destino) {
        switch(destino) {
            case 0:
                bBloco.moveLeft();
                this.moveLeft();
                this.getOlhando().setPosicao(this.getPosicao().getLinha(), this.getPosicao().getColuna() - 1);
                break;
            case 1:
                bBloco.moveUp();
                this.moveUp();
                this.getOlhando().setPosicao(this.getPosicao().getLinha() - 1, this.getPosicao().getColuna());
                break;
            case 2:
                bBloco.moveRight();
                this.moveRight();
                this.getOlhando().setPosicao(this.getPosicao().getLinha(), this.getPosicao().getColuna() + 1);
                break;
            default:
                bBloco.moveDown();
                this.moveDown();
                this.getOlhando().setPosicao(this.getPosicao().getLinha() + 1, this.getPosicao().getColuna());
                break;
        }
    }

    public void removerBloco(ArrayList<Elemento> listaBlocosInteragiveis, ArrayList<Elemento> eElementos) {
        for(int i = 0; i < listaBlocosInteragiveis.size(); i++) {
            Elemento bBloco = listaBlocosInteragiveis.get(i);
            if(bBloco.pPosicao.estaNaMesmaPosicao(this.getOlhando())) eElementos.remove(bBloco);
            return;
        }
    }

    public void ficarEnergizado() {
        setEnergizado(true);
        //Contar um timer
    }

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}
