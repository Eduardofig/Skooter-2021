#ifndef SUPERHEROI_H
#define SUPERHEROI_H value
#include "Personagem.h"

class SuperHeroi: public Personagem
{
    public:
        SuperHeroi(std::string nome, std::string pNomeVidaReal, std::vector<Superpoder> pPoderes, double vida);
};

#endif /* ifndef SUPERHEROI_H */
