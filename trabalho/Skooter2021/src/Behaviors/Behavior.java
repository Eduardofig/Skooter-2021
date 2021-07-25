package Behaviors;

import java.io.Serializable;
import Auxiliar.Posicao;

/**
 *
 * @author Eduardo, Jonatas
 */

public abstract class Behavior implements Serializable{
    public abstract void agir(Posicao pPosicao);
}
