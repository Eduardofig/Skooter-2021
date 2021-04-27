#ifndef PERSONAGEM_H
#define PERSONAGEM_H value
#include "Superpoder.h"

class Personagem 
{
    private:
        std::string _nome;
        std::string _nomeVidaReal;
        double vida;
        bool protegido;
        std::vector<Superpoder> _poderes;
    public:
        std::string getNome();
        std::string getNomeVidaReal();
        double getTotalPoder();
        double getVida();
        bool getProtegido();
        void setNome(std::string pNome);
        void setNomeVidaReal(std::string pNomeVidaReal);
        void addPoder(Superpoder pPoder);
        void setVida(double pVida);
        void setProtegido(bool pProtegido);
        void Attack(Personagem *Oponente, int PowerIndex);
};

#endif /* ifndef PERSONAGEM_H */
