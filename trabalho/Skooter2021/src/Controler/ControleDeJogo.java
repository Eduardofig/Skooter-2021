package Controler;

import Modelo.Elemento;
import Modelo.Hero;
import Auxiliar.Fase;
import Auxiliar.Posicao;
import java.util.ArrayList;

/**
 *
 * @author junio
 */
public class ControleDeJogo {
    public void desenhaTudo(Fase fFase){
        for(int i = 0; i < fFase.getElementos().size(); i++){
            fFase.getElementos().get(i).autoDesenho();
        }
    }
    public void processaTudo(Fase fFase){
        Hero hHero = (Hero)fFase.getElementos().get(0); /*O heroi (protagonista) eh sempre o primeiro do array*/
        Elemento eTemp;
        //Processa coisoes dos Blocos interagiveis com os demais elementos
        for(int i = 0; i < fFase.getBlocosInteragiveis().size(); i++) {
            eTemp = fFase.getBlocosInteragiveis().get(i);
            if(!cControle.ehPosicaoValida(fFase.getElementos(), eTemp.getPosicao())) {
                eTemp.voltaAUltimaPosicao();
            }
        }
        //Processa possiveis colisoes do inimigo com o heroi
        for(int i = 0; i < fFase.getInimigos().size(); i++) {
            eTemp = fFase.getInimigos().get(i);
            if(hHero.getPosicao().estaNaMesmaPosicao(eTemp.getPosicao())) {
                if(hHero.isEnergizado()) {
                    fFase.matarInimigo(eTemp);
                } else {
                    hHero.morrer();
                    fFase.reset();
                }
            }
            //Processa colisoes do inimigo com os outros elementos
            if(!cControle.ehPosicaoValida(fFase.getElementos(), eTemp.getPosicao())) {
                eTemp.voltaAUltimaPosicao();
            }
        }
        //Processa colisoes do heroi
        for(int i = 1; i < fFase.getElementos().size(); i++){
            eTemp = fFase.getElementos().get(i); /*Pega o i-esimo elemento do jogo*/
            /*Verifica se o heroi se sobrepoe ao i-ésimo elemento*/
            if(hHero.getPosicao().estaNaMesmaPosicao(eTemp.getPosicao())) {
                if(eTemp.isbTransponivel())
                    fFase.getElementos().remove(eTemp);
                else  {
                    hHero.voltaAUltimaPosicao();
                    hHero.setOlhando(hHero.getPosicao().getLinhaAnterior(), hHero.getPosicao().getColunaAnterior());
                }
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

    public void destruirBloco(Fase fFase, Hero hHeroi) {
        Elemento bBloco;
        for(int i = 0; i < fFase.getBlocosInteragiveis(); i++) {
            bBloco = fFase.getBlocosInteragiveis.get(i);
            if(bBloco.getPosicao().estaNaMesmaPosicao(hHeroi.getOlhando()))
                fFase.destruirBloco(bBloco);
        }
    }
}
