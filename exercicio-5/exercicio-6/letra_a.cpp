#include <iostream>
#include <vector>
#include "Dispositivo.hpp"

class Impressora: public Dispositivo
{
    public:
        void calibrar()
        {
            if(!getLigado()) {
                std::cout << "Impressora nao esta ligada!" << std::endl;
                return;
            }
            std::cout << "Calibrando funcoes da impressora" << std::endl;
            setStatus(rand() % 3);
        }
        int checarStatus()
        {
            if(!getLigado()) {
                std::cout << "Impressora nao esta ligada!" << std::endl;
                return 0;
            }
            std::cout << "Checkando o Status da Impressora" << std::endl;
            return getStatus();
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
            if(!getLigado()) {
                std::cout << "Mouse nao esta conectado no computador!" << std::endl;
                return;
            }
            std::cout << "Calibrando Botoes do Mouse" << std::endl;
            Status += rand() % 3;
            std::cout << "Calibrando sensor optico do Mouse" << std::endl;
            Status += rand() % 3;
            setStatus(Status);
        }
        int checarStatus()
        {
            if(!getLigado()) {
                std::cout << "Mouse nao esta conectado no computador!" << std::endl;
                return 0;
            }
            std::cout << "Checkando o status do Mouse" << std::endl;
            return getStatus();
        }
        Mouse()
        {
            ligar();
            calibrar();
        }
};

int main()
{
    std::vector<Dispositivo> dispositivos;
    dispositivos.push_back(*new Mouse);
    dispositivos.push_back(*new Impressora);
    for(int i = 0; i < dispositivos.size(); ++i) {
        std::cout << dispositivos[i].checarStatus() << std::endl;
        dispositivos[i].calibrar();
        std::cout << dispositivos[i].checarStatus() << std::endl;
        dispositivos[i].desligar();
    }
}
