package Auxiliar;

import Behaviors.*;

/**
 *
 * @author Eduardo, Jonatas
 */

public class BehaviorFactory {
    public Behavior criarBehavior(String seletor) {
        switch(seletor) {
            case "BehaviorEstatico":
                return new BehaviorEstatico();
            case "BehaviorOscilador":
                return new BehaviorOscilador();
            default:
                return new BehaviorTeletransportador();
        }
    }
}
