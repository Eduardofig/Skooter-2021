#include "Radio.cpp"
#include "Relogio.cpp"

class RadioRelogio: public Radio, public Relogio
{
    GETSET(int, EstacaoAlarme);
    public:
        virtual void disparaAlarme()
        {
            setEstacao(getEstacaoAlarme());
            cout << "Mudando a estacao para: " << getEstacaoAlarme() << getModulacao();
        }
        RadioRelogio(int estacaoAlarme, int estacao, Horario horas, Horario alarme):
            Radio(estacao),
            Relogio(horas, alarme)
        {
            setEstacaoAlarme(estacaoAlarme);
        }

};

