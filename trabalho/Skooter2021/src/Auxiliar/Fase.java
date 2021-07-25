package Auxiliar;

import java.util.ArrayList;
import java.io.Serializable;
import Modelo.Elemento;
import Modelo.BlocoSeta;
import Modelo.BlocoInteragivel;

/**
 *
 * @author Eduardo, Jonatas
 */

public class Fase implements Serializable {
    //Backups para o reset da fase apos o heroi morrer ou apos o jogador apertar r
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
    protected ArrayList<Elemento> listaElementosGenericos;

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
        this.eElementosBackup.add(bInimigo);
    }

    public void addBlocoNaoInteragivel(Elemento bBloco) {
        this.eElementos.add(bBloco);
        this.eElementosBackup.add(bBloco);
    }

    public void addElementoGenerico(Elemento eElemento) {
        this.getElementosGenericos().add(eElemento);
        this.eElementos.add(eElemento);
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

    public ArrayList<Elemento> getElementosGenericos() {
        return this.listaElementosGenericos;
    }

    public void removeCoracao(Elemento Coracao) {
        this.listaCoracoes.remove(Coracao);
        this.eElementos.remove(Coracao);
    }

    public void removeColecionavel(Elemento rColecionavel) {
        this.listaColecionaveis.remove(rColecionavel);
        this.eElementos.remove(rColecionavel);
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
        this.listaElementosGenericos = new ArrayList<Elemento>();
        this.listaBlocosInteragiveis = new ArrayList<Elemento>(this.listaBlocosInteragiveisBackup);
        this.listaInimigos = new ArrayList<Elemento>(this.listaInimigosBackup);
        this.listaColecionaveis = new ArrayList<Elemento>(this.listaColecionaveisBackup);
        this.listaCoracoes = new ArrayList<Elemento>(this.listaCoracoesBackup);
        this.eElementos = new ArrayList<Elemento>(this.eElementosBackup);
        for(int i = 0; i < this.eElementos.size(); i++) {
            this.eElementos.get(i).reset();
        }
    }

    public ArrayList<Elemento> getElementos() {
        return this.eElementos;
    }

    //Funcao que remove um elemento de uma determinada posicao
    public void removerElementoPosicao(Posicao pPosicao) {
        Elemento eElemento;
        for(int i = 0; i < getElementos().size(); ++i) {
            eElemento = this.getElementos().get(i);
            if(pPosicao.estaNaMesmaPosicao(getElementos().get(i).getPosicao())) {

                if(eElemento.getClass().getName() == "Hero") return;

                this.getElementos().remove(eElemento);

                System.out.println(eElemento.getClass().getName() + " Removido");

                switch(eElemento.getClass().getName()) {
                    case "Modelo.BlocoInteragivel":
                        this.getBlocosInteragiveis().remove(eElemento);
                        return;
                    case "Modelo.RoboInimigo":
                        this.getInimigos().remove(eElemento);
                        return;
                    case "Modelo.Colecionavel":
                        this.getColecionaveis().remove(eElemento);
                        return;
                    case "Modelo.Coracao":
                        this.getCoracoes().remove(eElemento);
                        return;
                    case "Modelo.BlocoSeta":
                        this.getBlocosSeta().remove(eElemento);
                        return;
                    case "Modelo.ElementoGenerico":
                        this.getElementosGenericos().remove(eElemento);
                    default:
                        return;
                }
            }
        }
    }

    public Fase(Elemento hHero) {
        this.listaElementosGenericos = new ArrayList<Elemento>();
        this.listaBlocosInteragiveisBackup = new ArrayList<Elemento>();
        this.listaInimigosBackup = new ArrayList<Elemento>();
        this.listaColecionaveisBackup = new ArrayList<Elemento>();
        this.listaCoracoesBackup = new ArrayList<Elemento>();
        this.eElementosBackup = new ArrayList<Elemento>();
        this.listaBlocosInteragiveis = new ArrayList<Elemento>();
        this.listaBlocosSeta = new ArrayList<Elemento>();
        this.listaInimigos = new ArrayList<Elemento>();
        this.listaColecionaveis = new ArrayList<Elemento>();
        this.listaCoracoes = new ArrayList<Elemento>();
        this.eElementos = new ArrayList<Elemento>();
        this.eElementosBackup.add(hHero);
        this.eElementos.add(hHero);
    }

}
