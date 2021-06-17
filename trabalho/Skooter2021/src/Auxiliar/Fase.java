import java.util.ArrayList;
import java.io.Serializable;
import Modelo.Elemento;
import Modelo.Hero;

public class Fase implements Serializable {
    protected ArrayList<Elemento> listaBlocosInteragiveis;
    protected ArrayList<Elemento> listaInimigos;
    protected ArrayList<Elemento> listaBlocosNaoInteragiveis;
    protected Hero hHero;

    public void setHero(Hero sHero) {
        this.hHero = sHero;
    }

    public void addBlocoInteragivel(Elemento bBloco) {
        this.listaBlocosInteragiveis.add(bBloco);
    }

    public void addInimigo(Elemento bInimigo) {
        this.listaInimigos.add(bInimigo);
    }

    public void addBlocoNaoInteragivel(Elemento bBloco) {
        this.listaBlocosNaoInteragiveis.add(bBloco);
    }

    public ArrayList<Elemento> getInimigos() {
        return this.listaInimigos;
    }

    public ArrayList<Elemento> getBlocosInteragiveis() {
        return this.listaBlocosInteragiveis;
    }

    public ArrayList<Elemento> getBlocosNaoInteragiveis() {
        return this.listaBlocosNaoInteragiveis;
    }

    public ArrayList<Elemento> getElementos() {
        ArrayList<Elemento> eElementos = new ArrayList<Elemento>();
        eElementos.add(this.hHero);
        for(int i = 0; i < this.listaBlocosNaoInteragiveis.size(); i++) {
            eElementos.add(this.listaBlocosNaoInteragiveis.get(i));
        }
        for(int i = 0; i < this.listaBlocosInteragiveis.size(); i++) {
            eElementos.add(this.listaBlocosInteragiveis.get(i));
        }
        for(int i = 0; i < this.listaInimigos.size(); i++) {
            eElementos.add(this.listaInimigos.get(i));
        }
        return eElementos;
    }

    public Fase (Hero hHero) {
        this.setHero(hHero);
    }
    
}
