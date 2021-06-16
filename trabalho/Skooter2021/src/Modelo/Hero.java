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

/**
 *
 * @author Junio
 */
public class Hero extends Elemento implements Serializable {

    protected bool estaEnergizado;

    public void setEnergizado(bool sEstaEnergizado) {
        this.estaEnergizado = sEstaEnergizado;
    }

    public bool getEnergizado() {
        return this.estaEnergizado;
    }

    public Hero(String sNomeImagePNG) {
        super(sNomeImagePNG);
        setEnergizado(false);
    }

    public void passarDeFase(ArrayList<Elemento> eElementos, ArrayList<Elemento> novaFase) {
        eElementos.clear();
        for(Elemento e: novaFase) {
            eElementos.add(e);
        }
    }

    public void Morrer(ArrayList<Elemento> eElementos, ArrayList<Elemento> faseAtual) {
        eElementos.clear();
        for(Elemento e: faseAtual) {
            eElementos.add(e);
        }
    }

    //Funcao que eh chamada quando o heroi destroi o bloco interagivel
    public void EmpurrarBloco(BlocoInteragivel bBloco, int destino) {
        switch(destino) {
            case 0:
                hHeroi.moveLeft();
                break;
            case 1:
                hHeroi.moveUp();
                break;
            case 2:
                hHeroi.moveRight();
                break;
            default:
                hHeroi.moveDown();
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
