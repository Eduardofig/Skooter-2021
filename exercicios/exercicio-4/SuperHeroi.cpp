#include <iostream>
#include "SuperHeroi.h"

SuperHeroi::SuperHeroi(std::string pNome, std::string pNomeVidaReal, std::vector<Superpoder> pPoderes, double vida)
{
    setNome(pNome);
    setNomeVidaReal(pNomeVidaReal);
    for(Superpoder pPoder: pPoderes) {
        addPoder(pPoder);
    }
    setVida(vida);
    setProtegido(true);
}
