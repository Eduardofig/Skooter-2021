#include "../getset.hpp"

#ifndef EXERCICIO6_LETRA_A_HPP
#define EXERCICIO6_LETRA_A_HPP
#endif

class Dispositivo
{
    GETSET_H(bool, Ligado);
    GETSET_H(int, Status);
    public:
    void ligar();
    void desligar();
    virtual int checarStatus() = 0;
    virtual void calibrar() = 0;
};
