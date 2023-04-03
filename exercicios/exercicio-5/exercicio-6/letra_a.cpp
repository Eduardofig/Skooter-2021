#include <iostream>
#include <vector>
#include "Dispositivo.hpp"

//classe impressora que extende dispositivo
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
            this->setStatus(rand() % 5);
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
        Impressora()
        {
            ligar();
            calibrar();
        }
};

//classe mouse que extende dispositivo
class Mouse: public Dispositivo
{
    public:
        void calibrar()
        {
            int Status;
            if(!this->getLigado()) {
                std::cout << "Mouse nao esta conectado no computador!" << std::endl;
                return;
            }
            std::cout << "Calibrando Botoes do Mouse" << std::endl;
            std::cout << "Calibrando sensor optico do Mouse" << std::endl;
            setStatus(rand() % 7);
        }
        int checarStatus()
        {
            if(!this->getLigado()) {
                std::cout << "Mouse nao esta conectado no computador!" << std::endl;
                return 0;
            }
            std::cout << "Checkando o status do Mouse" << std::endl;
            return this->getStatus();
        }
        Mouse()
        {
            ligar();
            calibrar();
        }
};

int main()
{
    std::vector<Dispositivo*> dispositivos;
    dispositivos.push_back(new Mouse);
    dispositivos.push_back(new Impressora);
    //chamada polimorfica dos metodos calibrar e checarStatus
    for(Dispositivo *dispositivo: dispositivos) {
        std::cout << dispositivo->checarStatus() << std::endl;
        dispositivo->calibrar();
        std::cout << dispositivo->checarStatus() << std::endl;
        dispositivo->desligar();
    }
}
