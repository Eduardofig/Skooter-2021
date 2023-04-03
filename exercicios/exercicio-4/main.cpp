#include <iostream>
#include "Superpoder.h"
#include "Personagem.h"
#include "SuperHeroi.h"
#include "Vilao.h"

int main()
{
    //Criacao de poderes do Superman
    Superpoder VisaoLaser(1, 10.0, 0.5, "Visao Laser");
    Superpoder SuperSoco(1, 10.0, 0.7, "Super Soco");
    //Criacao de SuperHeroi
    SuperHeroi Superman("Superman", "Clark Kent", {VisaoLaser, SuperSoco}, 150.00);
    //Vetor com o nome dos superpoderes para utilizar no loop
    std::vector<std::string> poderesSuperman = {VisaoLaser.getNome(), SuperSoco.getNome()};
    //Criacao de poderes do Lex LexLuthor
    Superpoder SocoKryptonita(1, 20.0, 0.8, "Soco Kryptonita");
    Superpoder GranadaGasKryptonita(1, 5.0, 0.4, "Granada de Gas de Kryptonita");
    //Adicao de poder ao Superman Pelo metodo addPoder()
    Superman.addPoder(*new Superpoder(2, 0.0, 0.7, "Bloquear"));
    poderesSuperman.push_back("Bloquear");
    //Criacao do Vilao LexLuthor
    Vilao LexLuthor("Lex Luthor", "Lex Luthor",{SocoKryptonita, GranadaGasKryptonita}, 150, 200.00);
    //Vetor com o nome dos superpoderes para utilizar no loop
    std::vector<std::string> poderesLexLuthor = {SocoKryptonita.getNome(), GranadaGasKryptonita.getNome()};
    //Adicao de poder ao lex luthor pelo metodo add Poder
    LexLuthor.addPoder(*new Superpoder(2, 0.0, 0.9, "Escudo de Kryptonita"));
    poderesLexLuthor.push_back("Escudo de Kryptonita");
    std::cout << "Nome de Heroi: " << Superman.getNome() << std::endl;
    std::cout << "Nome Verdadeiro: " << Superman.getNomeVidaReal() << std::endl;
    std::cout << "Nivel de Poder: " << Superman.getTotalPoder() << std::endl;
    std::cout << "     Versus " << std::endl;
    std::cout << "Nome de Vilao: " << LexLuthor.getNome() << std::endl;
    std::cout << "Nome Verdadeiro: " << LexLuthor.getNomeVidaReal() << std::endl;
    std::cout << "Nivel de Poder: " << LexLuthor.getTotalPoder() << std::endl;
    std::cout << "Anos de prisao: " << LexLuthor.getAnosDePrisao() << std::endl;
    std::cout << "\nBegin\n\n";
    //Loop da batalha
    while(LexLuthor.getVida() != 0 || Superman.getVida() != 0) {
        Superman.Attack(&LexLuthor, poderesSuperman[rand() % 3], (double)(rand() % 20));
        if(LexLuthor.getVida() == 0) {
            break;
        }
        LexLuthor.Attack(&Superman, poderesLexLuthor[rand() % 3], (double)(rand() % 20));
    }
    if(LexLuthor.getVida() == 0) {
        std::cout << Superman.getNome() << " WINS" << std::endl;
    } else {
        std::cout << LexLuthor.getNome() << " WINS" << std::endl;
    }
}
