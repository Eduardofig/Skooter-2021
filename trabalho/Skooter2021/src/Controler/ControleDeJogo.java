package Controler;

import Modelo.Elemento;
import Modelo.Hero;
import Modelo.BlocoSeta;
import Modelo.RoboInimigo;
import Modelo.Coracao;
import Auxiliar.Fase;
import Auxiliar.Posicao;
import Data.Fases;
import java.util.ArrayList;

/**
 *
 * @author junio
 */
public class ControleDeJogo {
    public void desenhaTudo(Fases fFases){
        Fase fFase = fFases.getFaseAtual();
        for(int i = 0; i < fFase.getElementos().size(); i++){
            fFase.getElementos().get(i).autoDesenho();
        }
    }
    public void processaTudo(Fases fFases){
        Fase fFase = fFases.getFaseAtual();
        Hero hHero = (Hero)fFase.getElementos().get(0); /*O heroi (protagonista) eh sempre o primeiro do array*/
        Elemento eTemp;
        BlocoSeta bBlocoSeta;
        RoboInimigo rRobo;
        Coracao cCoracao;

        int moveLinha, moveColuna;

        //Colisoes com Blocos Seta
        for(int i = 0; i < fFase.getBlocosSeta().size(); ++i) {
            bBlocoSeta = (BlocoSeta)fFase.getBlocosSeta().get(i);
            if(hHero.getPosicao().estaNaMesmaPosicao(bBlocoSeta.getPosicao())) {
                bBlocoSeta.moverHeroi(hHero);
            }
        }

        //Colisoes de Blocos interagiveis
        for(int i = 0; i < fFase.getBlocosInteragiveis().size(); i++) {
            eTemp = fFase.getBlocosInteragiveis().get(i);
            //Processa o Heroi empurrando o bloco
            if(hHero.getPosicao().estaNaMesmaPosicao(eTemp.getPosicao())) {
                moveLinha = hHero.getPosicao().getLinha() - hHero.getPosicao().getLinhaAnterior() + eTemp.getPosicao().getLinha();
                moveColuna = hHero.getPosicao().getColuna() - hHero.getPosicao().getColunaAnterior() + eTemp.getPosicao().getColuna();
                eTemp.getPosicao().setPosicao(moveLinha, moveColuna);
            }

            //Processa coisoes dos Blocos interagiveis com os demais elementos
            if(!this.ehPosicaoValida(fFase.getElementos(), eTemp.getPosicao())) {
                eTemp.voltaAUltimaPosicao();
            }
        }

        //Processamento dos inimigos
        for(int i = 0; i < fFase.getInimigos().size(); i++) {
            rRobo = (RoboInimigo)fFase.getInimigos().get(i);
            rRobo.move();
            //Processa possiveis colisoes do inimigo com o heroi
            if(hHero.getPosicao().estaNaMesmaPosicao(rRobo.getPosicao())) {
                if(hHero.isEnergizado()) {
                    fFase.matarInimigo(rRobo);
                } else {
                    hHero.morrer();
                    fFase.reset();
                }
            }
            //Processa colisoes do inimigo com os outros elementos
            if(!this.ehPosicaoValida(fFase.getElementos(), rRobo.getPosicao())) {
                rRobo.voltaAUltimaPosicao();
            }
        }

        //Processa colisoes do heroi com colecionaveis
        for(int i = 0; i < fFase.getColecionaveis().size(); i++) {
            eTemp = fFase.getColecionaveis().get(i);
            if(hHero.getPosicao().estaNaMesmaPosicao(eTemp.getPosicao())) {
                fFase.removeColecionavel(eTemp);
                if(fFase.getColecionaveis().isEmpty()) {
                    fFases.passarDeFase();
                }
            }
        }

        //Processamento dos coracoes
        for(int i = 0; i < fFase.getCoracoes().size(); ++i) {
            cCoracao = (Coracao)fFase.getCoracoes().get(i) ;
            //Movimento dos coracoes
            cCoracao.move();
            if(hHero.getPosicao().estaNaMesmaPosicao(cCoracao.getPosicao())) {
                fFase.removeCoracao(cCoracao);
                hHero.ficarEnergizado();
            }
        }

        //Processa as colicoes do heroi com todos os elementos que estao atualmente na tela
        for(int i = 1; i < fFase.getElementos().size(); i++){
            eTemp = fFase.getElementos().get(i);
            if(hHero.getPosicao().estaNaMesmaPosicao(eTemp.getPosicao())) {
                if(!eTemp.isbTransponivel()) {
                    hHero.voltaAUltimaPosicao();
                    //Se o heroi vai para uma posicao invalida ele volta e fica olhando para a posicao que ele 
                    //tentou ir
                    hHero.setOlhando(hHero.getPosicao().getLinhaAnterior(), hHero.getPosicao().getColunaAnterior());
                }
            }
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

    public void destruirBloco(Fase fFase, Hero hHero) {
        Elemento bBloco;
        for(int i = 0; i < fFase.getBlocosInteragiveis().size(); i++) {
            bBloco = fFase.getBlocosInteragiveis().get(i);
            if(bBloco.getPosicao().estaNaMesmaPosicao(hHero.getOlhando()))
                fFase.destruirBlocosInteragiveis(bBloco);
        }
    }
}
