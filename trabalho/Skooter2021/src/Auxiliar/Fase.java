package Auxiliar;

import java.util.ArrayList;
import java.io.Serializable;
import Modelo.Elemento;
import Modelo.BlocoSeta;
import Modelo.BlocoInteragivel;

public class Fase implements Serializable {
    //Backups para o reset da fase apos o heroi morrer
    protected ArrayList<Elemento> listaBlocosInteragiveisBackup;
    protected ArrayList<Elemento> listaInimigosBackup;
    protected ArrayList<Elemento> listaColecionaveisBackup;
    protected ArrayList<Elemento> listaCoracoesBackup;
    protected ArrayList<Elemento> eElementosBackup;
    //Elementos que serao utilizados
    protected ArrayList<Elemento> listaBlocosInteragiveis;
    protected ArrayList<Elemento> listaBlocosSeta;
    protected ArrayList<Elemento> listaInimigos;
    protected ArrayList<Elemento> listaColecionaveis;
    protected ArrayList<Elemento> listaCoracoes;
    protected ArrayList<Elemento> eElementos;

    public void addCoracao(Elemento Coracao) {
        this.listaCoracoes.add(Coracao);
        this.listaCoracoesBackup.add(Coracao);
        this.eElementos.add(Coracao);
        this.eElementosBackup.add(Coracao);
    }

    public void addColecionavel(Elemento sColecionavel) {
        this.listaColecionaveis.add(sColecionavel);
        this.listaColecionaveisBackup.add(sColecionavel);
        this.eElementos.add(sColecionavel);
        this.eElementosBackup.add(sColecionavel);
    }

    public void addBlocoSeta(Elemento bBloco) {
        this.listaBlocosSeta.add(bBloco);
        this.eElementos.add(bBloco);
        this.eElementosBackup.add(bBloco);
    }

    public void addBlocoInteragivel(Elemento bBloco) {
        this.listaBlocosInteragiveis.add(bBloco);
        this.listaBlocosInteragiveisBackup.add(bBloco);
        this.eElementos.add(bBloco);
        this.eElementosBackup.add(bBloco);
    }

    public void addInimigo(Elemento bInimigo) {
        this.listaInimigos.add(bInimigo);
        this.listaInimigosBackup.add(bInimigo);
        this.eElementos.add(bInimigo);
    }

    public ArrayList<Elemento> getCoracoes() {
        return this.listaCoracoes;
    }

    public ArrayList<Elemento> getInimigos() {
        return this.listaInimigos;
    }

    public ArrayList<Elemento> getBlocosInteragiveis() {
        return this.listaBlocosInteragiveis;
    }

    public ArrayList<Elemento> getColecionaveis() {
        return this.listaColecionaveis;
    }

    public ArrayList<Elemento> getBlocosSeta() {
        return this.listaBlocosSeta;
    }

    public void removeCoracao(Elemento Coracao) {
        this.listaCoracoes.remove(Coracao);
        this.eElementos.remove(Coracao);
    }

    public void removeColecionavel(Elemento rColecionavel) {
        this.listaColecionaveis.remove(rColecionavel);
    }

    public void matarInimigo(Elemento rInimigo) {
        this.listaInimigos.remove(rInimigo);
        this.eElementos.remove(rInimigo);
    }

    public void destruirBlocosInteragiveis(Elemento rBloco) {
        this.listaBlocosInteragiveis.remove(rBloco);
        this.eElementos.remove(rBloco);
    }

    public void reset() {
        this.listaBlocosInteragiveis = new ArrayList<Elemento>(this.listaBlocosInteragiveisBackup);
        this.listaInimigos = new ArrayList<Elemento>(this.listaInimigosBackup);
        this.listaColecionaveis = new ArrayList<Elemento>(this.listaColecionaveisBackup);
        this.listaCoracoes = new ArrayList<Elemento>(this.listaCoracoesBackup);
        this.eElementos = new ArrayList<Elemento>(this.eElementosBackup);
    }

    public ArrayList<Elemento> getElementos() {
        return this.eElementos;
    }

    public Fase(Elemento hHero) {
        this.eElementos.add(hHero);
    }

}
