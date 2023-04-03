#include <iostream>
#include "Dispositivo.hpp"

GETSET_C(bool, Ligado, Dispositivo);
GETSET_C(int, Status, Dispositivo);

//Implementacao dos metodos ligar a desligar da classe abstrada Dispositivo(os metodos virtuais estao no .hpp)

void Dispositivo::ligar()
{
    if(getLigado()) {
        std::cout << "Dispositivo ja esta ligado" << std::endl;
        return;
    }
    std::cout << "Ligando dispositivo" << std::endl;
    setLigado(true);
}

void Dispositivo::desligar()
{
    if(!getLigado()) {
        std::cout << "Dispositivo ja esta desligado" << std::endl;
        return;
    }
    std::cout << "Desligando dispositivo" << std::endl;
    setLigado(false);
}
