package Data;

import java.util.ArrayList;
import Auxiliar.Fase;
import Modelo.*;

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
        return (Hero)this.getFaseAtual().getElementos().get(0);
    }

    public Fases() {
        this.Fases = new ArrayList<Fase>();
        this.faseAtual = 0;
        //Fase 1
        Hero hHero1 = new Hero("skooter_hero.png", 0, 0);
        Colecionavel Colecionavel1 = new Colecionavel("vacina.png", 0, 1);
        Colecionavel Colecionavel2 = new Colecionavel("vacina.png", 5, 3);
        BlocoInteragivel BlocoInteragivel1 = new BlocoInteragivel("bricks.png", 8, 8);
        BlocoInteragivel BlocoInteragivel2 = new BlocoInteragivel("bricks.png", 7, 7);
        Fase Fase1 = new Fase(hHero1);
        Fase1.addColecionavel(Colecionavel1);
        Fase1.addColecionavel(Colecionavel2);
        Fase1.addBlocoInteragivel(BlocoInteragivel1);
        Fase1.addBlocoInteragivel(BlocoInteragivel2);
        this.addFase(Fase1);
        //Fase 2
        Hero hHeroi2 = new Hero("skooter_hero.png", 4, 4);
        Colecionavel Colecionavel3 = new Colecionavel("vacina.png", 6, 6);
        Colecionavel Colecionavel4 = new Colecionavel("vacina.png", 2, 5);
        BlocoSeta BlocoSeta1 = new BlocoSeta("covid.png", 2, 3, 3);
        BlocoNaoInteragivel BlocoNaoInteragivel1 = new BlocoNaoInteragivel("asfalto.png", 7, 7);
        RoboInimigo roboInimigo1 = new RoboInimigo("caveira.png", 1, 1);
        Fase Fase2 = new Fase(hHeroi2);
        Fase2.addColecionavel(Colecionavel3);
        Fase2.addColecionavel(Colecionavel4);
        Fase2.addInimigo(roboInimigo1);
        Fase2.addBlocoSeta(BlocoSeta1);
        Fase2.addBlocoNaoInteragivel(BlocoNaoInteragivel1);
        Fase2.addBlocoInteragivel(BlocoInteragivel1);
        this.addFase(Fase2);
        
    }

}
