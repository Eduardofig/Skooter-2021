#ifndef DISPOSITIVO
#define DISPOSITIVO
#include <iostream>
#include "../../getset.hpp"

using namespace std;

//Classe mae dispositivo
class Dispositivo
{
    GETSET(string, Fabricante);
    GETSET(bool, Ligado);
    public:
        virtual void Liga_Desliga() = 0;
        Dispositivo(string fabricante)
        {
            setLigado(false);
            setFabricante(fabricante);
        }
};

#endif
