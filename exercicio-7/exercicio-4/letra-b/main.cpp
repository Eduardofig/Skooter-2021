#include <vector>
#include "Radio.cpp"
#include "Relogio.cpp"

int main()
{
    vector<Dispositivo*> dispositivos(2);
    dispositivos[0] = new Relogio(*new Horario(2, 34, 30), *new Horario(15, 8, 16), "Rolex");
    dispositivos[1] = new Radio(23, "Samsung");
    //Ligando
    for(Dispositivo* dispositivo: dispositivos) dispositivo->Liga_Desliga();
    //Desligando
    for(Dispositivo* dispositivo: dispositivos) dispositivo->Liga_Desliga();
    
}
