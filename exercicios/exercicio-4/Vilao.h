#ifndef VILAO_H
#define VILAO_H
#include "Personagem.h"

class Vilao: public Personagem
{
    private:
        int _anosDePrisao;
    public:
        void setAnosDePrisao(int pAnosDePrisao);
        int getAnosDePrisao();
        Vilao(std::string pNome, std::string pNomeVidaReal, std::vector<Superpoder> pPoderes, int pAnosDePrisao, double vida);
};

#endif /* ifndef VILAO_H */
