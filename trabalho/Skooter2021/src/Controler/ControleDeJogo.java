package Controler;

import Modelo.Elemento;
import Modelo.Hero;
import Auxiliar.Posicao;
import java.util.ArrayList;

/**
 *
 * @author junio
 */
public class ControleDeJogo {
    public void desenhaTudo(ArrayList<Elemento> e){
        for(int i = 0; i < e.size(); i++){
            e.get(i).autoDesenho();
        }
    }
    public void processaTudo(ArrayList<Elemento> e){
        //Implementar a classe Fase
        Hero hHero = (Hero)e.get(0); /*O heroi (protagonista) eh sempre o primeiro do array*/
        Elemento eTemp;
        /*Processa todos os demais em relacao ao heroi*/
        //Processa coisoes dos Blocos interagiveis com os demais elementos
        for(int i = 0; i < listaBlocosInteragiveis.size(); i++) {
            eTemp = listaBlocosInteragiveis.get(i);
            if(!cControle.ehPosicaoValida(this.eElementos, eTemp.getPosicao())) {
                eTemp.voltaAUltimaPosicao();
            }
        }
        for(int i = 0; i < listaInimigos.size(); i++) {
            eTemp = listaInimigos.get(i);
            //Processa possiveis colisoes do inimigo com o heroi
            if(hHero.getOlhando().estaNaMesmaPosicao(eTemp.getPosicao())) {
                if(hHero.setEnergizado()) {
                    eElementos.remove(eTemp);
                    listaInimigos.remove(eTemp);
                } else {
                    //hHero.morrer;
                }
            }
            //Processa colisoes do inimigo com os outros elementos
            if(!cControle.ehPosicaoValida(this.eElementos, listaInimigos.get(i).getPosicao())) {
                listaInimigos.get(i).voltaAUltimaPosicao();
            }
        }
        //Processa colisoes do heroi
        for(int i = 1; i < e.size(); i++){
            eTemp = e.get(i); /*Pega o i-esimo elemento do jogo*/
            /*Verifica se o heroi se sobrepoe ao i-ésimo elemento*/
            if(hHero.getPosicao().estaNaMesmaPosicao(eTemp.getPosicao())) {
                if(eTemp.isbTransponivel())
                    e.remove(eTemp);
                else 
                    hHero.voltaAUltimaPosicao();
            }
                /*Nem todos os elementos podem ser transpostos pelo heroi*/
        }
    }
    public boolean ehPosicaoValida(ArrayList<Elemento> e, Posicao p){
        Elemento eTemp;
        /*Validacao da posicao de todos os elementos com relacao a Posicao p*/
        for(int i = 1; i < e.size(); i++){ /*Olha todos os elementos*/
            eTemp = e.get(i); /*Pega o i-esimo elemento do jogo*/
            if(!eTemp.isbTransponivel())
                if(eTemp.getPosicao().estaNaMesmaPosicao(p))
                    return false; /*A posicao p é invalida, pois ha um elemento (i-esimo eTemp) intransponivel lá*/
        }
        return true;
    }
}
