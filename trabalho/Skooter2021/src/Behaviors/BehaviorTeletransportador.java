package Behaviors;

import Auxiliar.Posicao;
import java.util.Random;

/**
 *
 * @author Eduardo, Jonatas
 */

public class BehaviorTeletransportador extends Behavior {

    protected Random rRandom;

    public void agir(Posicao pPosicao) {
        int move = this.rRandom.nextInt();
        for(int i = 0; i < 3; ++i) {
            switch(move) {
                case 0:
                    pPosicao.moveLeft();
                    break;
                case 1:
                    pPosicao.moveRight();
                    break;
                case 2:
                    pPosicao.moveUp();
                    break;
                default:
                    pPosicao.moveDown();
                    break;
            }
        }
    }
     
    public BehaviorTeletransportador() {
        this.rRandom = new Random();
    }
}
