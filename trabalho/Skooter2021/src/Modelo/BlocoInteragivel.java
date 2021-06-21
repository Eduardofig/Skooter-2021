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

    protected boolean ehEmpurravel;
    protected boolean ehDestruivel;

    public void setEmpurravel(boolean sEmpurravel) {
        this.ehEmpurravel = sEmpurravel;
    }

    public void setDestruivel(boolean sDestruivel) {
        this.ehDestruivel = sDestruivel;
    }

    public boolean isEmpurravel() {
        return this.ehEmpurravel;
    }

    public boolean isDestruivel() {
        return this.ehDestruivel;
    }

    public BlocoInteragivel(String sNomeImagePNG, int linha, int coluna) {
        super(sNomeImagePNG, linha, coluna);
        this.setbTransponivel(false);
        this.setEmpurravel(true);
        this.setDestruivel(true);
    }
}
