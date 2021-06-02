#include <iostream>
#include "../../getset.hpp"

using namespace std;

class Horario
{
    GETSET(int, Hora);
    GETSET(int, Minutos);
    GETSET(int, Segundos);
    public:
        void incrementaHora()
        {
            if(getSegundos() == 60) {
                setSegundos(0);
                if(Minutos == 60) {
                    setMinutos(0);
                    setHora(getHora() + 1);
                    return;
                }
                setMinutos(getMinutos() + 1);
                return;
            }
            setSegundos(getSegundos() + 1);
        }
        bool operator==(Horario h)
        {
            return getSegundos() == h.getSegundos() && getMinutos() == h.getMinutos() && getHora() == h.getHora();
        }
        Horario() = default;
        Horario(int hora, int minutos, int segundos)
        {
            setHora(hora);
            setMinutos(minutos);
            setSegundos(segundos);
        }
};

class Relogio
{
    GETSET(Horario, Horas);
    GETSET(Horario, Alarme);
    public:
        //Funcao virtual dispara alarme que sera alterada na classe RadioRelogio
        virtual void disparaAlarme()
        {
            cout << "Alarme, Alarme, Alarme";
        }
        void relogioTick()
        {
            if(getHoras() == getAlarme()) disparaAlarme();
            this->Horas.incrementaHora();
        }
        Relogio(Horario horas, Horario alarme)
        {
            setHoras(horas);
            setAlarme(alarme);
        }
};
