#include <iostream>
#include "../../getset.hpp"

using namespace std;

class Radio
{
    GETSET(int, Estacao);
    GETSET(string, Modulacao);
    public:
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
