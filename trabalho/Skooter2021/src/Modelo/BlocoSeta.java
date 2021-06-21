package Modelo;

/**
 *
 * @author Junio
 */

//Classe do bloco com uma seta que define que o heroi so possa mover para 
//uma direcao quando esta atravessando ele
public class BlocoSeta extends Elemento {

    //Atributo Orientacao que define para aonde aponta a seta e seus getters e setters
    protected int pOrientacao;

    public void setOrientacao(int sOrientacao) {
        this.pOrientacao = sOrientacao;
    }

    public int getOrientacao() {
        return this.pOrientacao;
    }

    //Quando o Heroi atravessa o bloco seta ele eh empurrado
    public void moverHeroi(Hero hHero) {
        hHero.autoDesenho();
        switch(this.getOrientacao()) {
            case 0:
                hHero.moveLeft();
                break;
            case 1:
                hHero.moveUp();
                break;
            case 2:
                hHero.moveRight();
                break;
            default:
                hHero.moveDown();
                break;
        }
    }

    public BlocoSeta(String sNomeImagePNG, int sOrientacao, int linha, int coluna) {
        super(sNomeImagePNG, linha, coluna);
        this.setbTransponivel(false);
        this.setOrientacao(sOrientacao);
    }
}
