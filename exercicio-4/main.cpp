#include <iostream>
#include "Superpoder.h"
#include "Personagem.h"
#include "SuperHeroi.h"
#include "Vilao.h"

int main()
{
    Superpoder VisaoLaser(1, 10.0, 0.5, "Visao Laser", false);
    Superpoder SuperSoco(1, 10.0, 0.7, "Super Soco", false);
    SuperHeroi Superman("Superman", "Clark Kent", {VisaoLaser, SuperSoco}, 150.00);
    std::vector<std::string> poderesSuperman = {VisaoLaser.getNome(), SuperSoco.getNome()};
    Superpoder SocoKryptonita(1, 20.0, 0.8, "Soco Kryptonita", false);
    Superpoder GranadaGasKryptonita(1, 5.0, 0.4, "Granada de Gas de Kryptonita", false);
    Vilao LexLuthor("Lex Luthor", "Lex Luthor",{SocoKryptonita, GranadaGasKryptonita}, 150, 200.00);
    std::vector<std::string> poderesLexLuthor = {SocoKryptonita.getNome(), GranadaGasKryptonita.getNome()};
    std::cout << Superman.getNomeVidaReal() << std::endl;
    std::cout << Superman.getNome() << std::endl;
    std::cout << Superman.getTotalPoder() << std::endl;
    std::cout << " Versus " << std::endl;
    std::cout << LexLuthor.getNomeVidaReal() << std::endl;
    std::cout << LexLuthor.getNome() << std::endl;
    std::cout << LexLuthor.getTotalPoder() << std::endl;
    std::cout << LexLuthor.getAnosDePrisao() << std::endl;
    while(LexLuthor.getVida() != 0 || Superman.getVida() != 0) {
        Superman.Attack(&LexLuthor, poderesSuperman[rand() % 2]);
        if(LexLuthor.getVida() == 0) {
            break;
        }
        LexLuthor.Attack(&Superman, poderesLexLuthor[rand() % 2]);
    }
    if(LexLuthor.getVida() == 0) {
        std::cout << Superman.getNome() << " WINS" << std::endl;
    } else {
        std::cout << LexLuthor.getNome() << " WINS" << std::endl;
    }
}
