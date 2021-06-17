import java.util.ArrayList;
import java.io.Serializable;
import Modelo.Elemento;
import Modelo.Hero;

public class Fase implements Serializable {
    //Backups para o reset da fase apos o heroi morrer
    protected ArrayList<Elemento> listaBlocosInteragiveisBackup;
    protected ArrayList<Elemento> listaInimigosBackup;
    protected ArrayList<Elemento> listaBlocosNaoInteragiveisBackup;
    //Elementos que serao utilizados
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

    public void backup() {
        this.listaBlocosNaoInteragiveisBackup = new ArrayList<Elemento>(this.listaBlocosNaoInteragiveis);
        this.listaBlocosInteragiveisBackup = new ArrayList<Elemento>(this.listaBlocosInteragiveis);
        this.listaInimigosBackup = new ArrayList<Elemento>(this.listaInimigos);
    }

    public void reset() {
        this.listaBlocosNaoInteragiveis = new ArrayList<Elemento>(this.listaBlocosNaoInteragiveisBackup);
        this.listaBlocosInteragiveis = new ArrayList<Elemento>(this.listaBlocosInteragiveisBackup );
        this.listaInimigos = new ArrayList<Elemento>(this.listaInimigosBackup);
    }

    public ArrayList<Elemento> getElementos() {
        ArrayList<Elemento> eElementos = new ArrayList<Elemento>();
        eElementos.add(this.hHero);
        for(int i = 0; i < this.listaBlocosNaoInteragiveisBackup.size(); i++) {
            eElementos.add(this.listaBlocosNaoInteragiveisBackup.get(i));
        }
        for(int i = 0; i < this.listaBlocosInteragiveisBackup.size(); i++) {
            eElementos.add(this.listaBlocosInteragiveisBackup.get(i));
        }
        for(int i = 0; i < this.listaInimigosBackup.size(); i++) {
            eElementos.add(this.listaInimigosBackup.get(i));
        }
        return eElementos;
    }

    public Fase(Hero hHero) {
        this.setHero(hHero);
    }
    
}
