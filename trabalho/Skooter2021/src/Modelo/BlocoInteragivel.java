package Modelo;

/**
 *
 * @author Eduardo, Jonatas
 */
public class BlocoInteragivel extends Elemento {

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
