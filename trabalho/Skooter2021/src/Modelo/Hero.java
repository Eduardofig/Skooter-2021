package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenhador;
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

    protected boolean estaEnergizado;
    protected int numVidas;

    public void setNumVidas(int sNumVidas) {
        this.numVidas = sNumVidas;
    }

    public int getNumVidas() {
        return this.numVidas;
    }

    public void setEnergizado(boolean sEstaEnergizado) {
        this.estaEnergizado = sEstaEnergizado;
    }

    public boolean getEnergizado() {
        return this.estaEnergizado;
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

    public void morrer(ArrayList<Elemento> eElementos, ArrayList<Elemento> faseAtual) {
        setNumVidas(getNumVidas() - 1);
        eElementos.clear();
        //Inserir um if que checa se ha um game over
        for(int i = 0; i < eElementos.size(); i++) {
            eElementos.add(eElementos.get(i));
        }
        System.out.println("Voce Morreu");
    }

    //Funcao que eh chamada quando o heroi destroi o bloco interagivel
    public void empurrarBloco(BlocoInteragivel bBloco, int destino) {
        switch(destino) {
            case 0:
                this.moveLeft();
                break;
            case 1:
                this.moveUp();
                break;
            case 2:
                this.moveRight();
                break;
            default:
                this.moveDown();
                break;
        }
    }

    public void removerBloco(BlocoInteragivel bBloco, ArrayList<Elemento> eElementos)
    {
        eElementos.remove(bBloco);
    }

    public void ficarEnergizado() {
        setEnergizado(true);
        //Contar um timer
    }

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}
