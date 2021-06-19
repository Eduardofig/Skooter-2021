package Data;

import java.util.ArrayList;
import Auxiliar.Fase;

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

    public void getFaseAtual() {
        return this.Fases.get(this.faseAtual);
    }

    public Fases() {
        //Desenhar as fases
    }

}
