#include <iostream>
#include "../../getset.hpp"

using namespace std;

class Radio
{
    GETSET(int, Estacao);//Funcoes que definem e retornam a estacao
    GETSET(string, Modulacao);
    public:
        //Funcao que alterna de FM para AM e vice e versa
        void alternarModulacao()
        {
            if(getModulacao() == "AM") {
                setModulacao("FM");
                cout << "Modulacao agora em FM";
                return;
            }
            setModulacao("AM");
            cout << "Modulacao agora em AM";
        }
        Radio(int estacao)
        {
            setModulacao("FM");
            setEstacao(estacao);
        }
};
