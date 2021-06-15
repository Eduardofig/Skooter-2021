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

//Classe do bloco com uma seta que define que o heroi so possa mover para 
//uma direcao quando esta atravessando ele
public class BlocoSeta extends Elemento implements Serializable{
    //Atributo Orientacao que define para aonde aponta a seta e seus getters e setters
    protected Posicao pOrientacao;

    public void setOrientacao(Posicao sOrientacao) {
        this.pOrientacao = sOrientacao;
    }

    public void getOrientacao() {
        return this.pOrientacao;
    }

    public void restringirHeroi(Hero hHeroi) {
        hHeroi.setRestringido(this.getOrientacao());
    }


    public BlocoSeta(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.setbTransponivel(true);
    }
}
