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
public class BlocoInteragivel extends Elemento implements Serializable {
    public BlocoInteragivel(String sNomeImagePNG) {
        super(sNomeImagePNG);
    }
}
