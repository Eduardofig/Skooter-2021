package Behaviors;

import Auxiliar.Posicao;
import java.util.Random;

/**
 *
 * @author Eduardo, Jonatas
 */

public class BehaviorOscilador extends Behavior {
    protected boolean right;

    public void agir(Posicao pPosicao) {
        if(this.right) {
            pPosicao.moveRight();
            this.right = false;
            return;
        }
        pPosicao.moveLeft();
        this.right = true;
    }

    public BehaviorOscilador() {
        this.right = true;
    }
}
