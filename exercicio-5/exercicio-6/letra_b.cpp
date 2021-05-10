#include <iostream>
#include <vector>
#include "Dispositivo.hpp"

class Impressora: public Dispositivo
{
    public:
        void calibrar()
        {
            if(!this->getLigado()) {
                std::cout << "Impressora nao esta ligada!" << std::endl;
                return;
            }
            std::cout << "Calibrando funcoes da impressora" << std::endl;
            this->setStatus(rand() % 3);
        }
        int checarStatus()
        {
            if(!this->getLigado()) {
                std::cout << "Impressora nao esta ligada!" << std::endl;
                return 0;
            }
            std::cout << "Checkando o Status da Impressora" << std::endl;
            return this->getStatus();
        }
};

class ImpressoraTinta: public Impressora
{
    GETSET(int, QuantidadeDeTinta);
    public:
        ImpressoraTinta(int QuantidadeDeTinta)
        {
            ligar();
            calibrar();
            setQuantidadeDeTinta(QuantidadeDeTinta);
        }
};

class ImpressoraLaser: public Impressora
{
    GETSET(double, IntegridadeDoLaser);
    public:
        ImpressoraLaser(double IntegridadeDoLaser)
        {
            ligar();
            calibrar();
            setIntegridadeDoLaser(IntegridadeDoLaser);
        }
};

int main()
{
    std::vector<Dispositivo*> dispositivos = {new ImpressoraLaser(5.2), new ImpressoraTinta(10)};
    for(Dispositivo *dispositivo: dispositivos) {
        std::cout << dispositivo->checarStatus() << std::endl;
        dispositivo->calibrar();
        std::cout << dispositivo->checarStatus() << std::endl;
        dispositivo->desligar();
    }
}
