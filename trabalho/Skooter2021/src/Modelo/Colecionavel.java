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
public class Colecionavel extends Elemento implements Serializable{

    //Variaveis publicas que definem se o Colecionavel eh um Coracao ou se ele eh um sol
    public boolean ehCoracao;
    public boolean ehSol;

    public Colecionavel(String sNomeImagePNG, boolean sEhCoracao, boolean sEhSol) {
        super(sNomeImagePNG);
        this.ehCoracao = sEhCoracao;
        this.ehSol = sEhSol;
        this.setbTransponivel(true);
    }

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}
