#include <iostream>
#include "Vilao.h"

void Vilao::setAnosDePrisao(int pAnosDePrisao)
{
    this->_anosDePrisao = pAnosDePrisao;
}
int Vilao::getAnosDePrisao()
{
    return this->_anosDePrisao;
}
Vilao::Vilao(std::string pNome, std::string pNomeVidaReal, std::vector<Superpoder> pPoderes, int pAnosDePrisao, double vida)
{
    setNome(pNome);
    setNomeVidaReal(pNomeVidaReal);
    setAnosDePrisao(pAnosDePrisao);
    for(Superpoder pPoder: pPoderes) {
        addPoder(pPoder);
    }
    setVida(vida);
    setProtegido(false);
}
