package Controler;

import Modelo.Elemento;
import Modelo.Hero;
import Modelo.BlocoSeta;
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
        BlocoSeta bBlocoSeta;
        int moveLinha, moveColuna;

        //Colisoes com Blocos Seta
        for(int i = 0; i < fFase.getBlocosSeta.size(); ++i) {
            bBlocoSeta = (BlocoSeta)fFase.getBlocosSeta().get(i);
            if(hHero.getPosicao().estaNaMesmaPosicao(bBlocoSeta.getPosicao())) {
                bBlocoSeta.moverHeroi(hHeroi);
            }
        }

        //Colisoes de Blocos interagiveis
        for(int i = 0; i < fFase.getBlocosInteragiveis().size(); i++) {
            eTemp = fFase.getBlocosInteragiveis().get(i);
            //Processa o Heroi empurrando o bloco
            if(hHero.getPosicao().estaNaMesmaPosicao(eTemp.getPosicao())) {
                moveLinha = hHero.getPosicao().getLinha() - hHeroi.getPosicao().getLinhaAnterior() + eTemp.getPosicao().getLinha();
                moveColuna = hHero.getPosicao().getColuna() - hHeroi.getPosicao().getColunaAnterior() + eTemp.getPosicao().getColuna();
                eTemp.getPosicao().setPosicao(moveLinha, moveColuna);
            }

            //Processa coisoes dos Blocos interagiveis com os demais elementos
            if(!cControle.ehPosicaoValida(fFase.getElementos(), eTemp.getPosicao())) {
                eTemp.voltaAUltimaPosicao();
            }
        }

        //Colisoes de inimigos
        for(int i = 0; i < fFase.getInimigos().size(); i++) {
            eTemp = fFase.getInimigos().get(i);
            //Processa possiveis colisoes do inimigo com o heroi
            if(hHero.getPosicao().estaNaMesmaPosicao(eTemp.getPosicao())) {
                if(hHero.isEnergizado()) { fFase.matarInimigo(eTemp);
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
        //Processa colisoes do heroi com colecionaveis
        for(int i = 0; i < fFase.getColecionaveis().size(); i++) {
            eTemp = fFase.getColecionaveis().get(i);
            if(hHero.getPosicao().estaNaMesmaPosicao(eTemp.getPosicao())) {
                fFase.removeColecionavel(eTemp);
                if(!fFase.getColecionaveis().size()) {
                    //Passar de fase
                }
            }
        }
        //Processa as colicoes do heroi com todos os elementos que estao atualmente na tela
        for(int i = 1; i < fFase.getElementos().size(); i++){
            eTemp = fFase.getElementos().get(i); /*Pega o i-esimo elemento do jogo*/
            /*Verifica se o heroi se sobrepoe ao i-ésimo elemento*/
            if(hHero.getPosicao().estaNaMesmaPosicao(eTemp.getPosicao())) {
                if(!eTemp.isbTransponivel()) {
                    hHero.voltaAUltimaPosicao();
                    //Se o heroi vai para uma posicao invalida ele volta e fica olhando para a posicao que ele 
                    //tentou ir
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
