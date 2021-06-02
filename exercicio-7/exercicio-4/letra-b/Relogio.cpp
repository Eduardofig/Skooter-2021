#include "Dispositivo.cpp"

using namespace std;

//Classe que define um horario que sera usada na classe relogio
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

class Relogio: public Dispositivo
{
    GETSET(Horario, Horas);
    GETSET(Horario, Alarme);
    public:
        virtual void Liga_Desliga()
        {
            if(getLigado()){
                cout << "Desligando Relogio\n";
                setLigado(false);
                return;
            }
            cout << "Ligando Relogio\n";
            setLigado(true);
        }
        virtual void disparaAlarme()
        {
            cout << "Alarme, Alarme, Alarme";
        }
        //Funcao que seria chamada a cada segundo durante o 
        //funcionamento do relogio
        void relogioTick()
        {
            if(getHoras() == getAlarme()) disparaAlarme();
            this->Horas.incrementaHora();
        }
        Relogio(Horario horas, Horario alarme, string fabricante):
            Dispositivo(fabricante)
    {
        setHoras(horas);
        setAlarme(alarme);
    }
};
