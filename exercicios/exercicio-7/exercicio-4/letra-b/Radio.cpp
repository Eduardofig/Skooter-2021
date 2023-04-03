#include "Dispositivo.cpp"

using namespace std;

class Radio: public Dispositivo
{
    GETSET(int, Estacao);
    GETSET(string, Modulacao);
    public:
        virtual void Liga_Desliga()
        {
            if(getLigado()){
                cout << "Desligando Radio\n";
                setLigado(false);
                return;
            }
            cout << "Ligando Radio\n";
            setLigado(true);
        }
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
        Radio(int estacao, string fabricante):
            Dispositivo(fabricante)
        {
            setModulacao("FM");
            setEstacao(estacao);
        }
};
