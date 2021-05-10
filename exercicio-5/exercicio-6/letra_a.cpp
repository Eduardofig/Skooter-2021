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
        Impressora()
        {
            ligar();
            calibrar();
        }
};

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
            Status += rand() % 2;
            std::cout << "Calibrando sensor optico do Mouse" << std::endl;
            Status += rand() % 2;
            setStatus(Status);
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
    for(int i = 0; i < dispositivos.size(); ++i) {
        std::cout << dispositivos[i]->checarStatus() << std::endl;
        dispositivos[i]->calibrar();
        std::cout << dispositivos[i]->checarStatus() << std::endl;
        dispositivos[i]->desligar();
    }
}
