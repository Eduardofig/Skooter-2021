package Data;

import java.util.ArrayList;
import Auxiliar.Fase;
import Modelo.Hero;

public class Fases {
    protected ArrayList<Fase> Fases;
    protected int faseAtual;

    public void addFase(Fase fFase) {
        this.Fases.add(fFase);
    }

    public void passarDeFase() {
        if(this.faseAtual == this.Fases.size() - 1) {
            System.out.println("Parabens, voce zerou o jogo!");
            System.exit(0);
        }
        this.faseAtual++;
    }

    public Fase getFaseAtual() {
        return this.Fases.get(this.faseAtual);
    }

    public Hero getHeroAtual() {
        return this.getFaseAtual().getElementos().get(0);
    }

    public Fases() {
        //Desenhar as fases
    }

}
