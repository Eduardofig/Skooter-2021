#include <iostream>
#include "getset.hpp"

using namespace std;

class PegadaDeCarbono
{
    virtual int getPegadaDeCarbono() = 0;
};

class Carro: public PegadaDeCarbono
{
    GETSET(int, KilometrosRodados);
    GETSET(double, EficienciaDoMotor);
    Carro(int KilometrosRodados, double EficienciaDoMotor) 
    {
        setKilometrosRodados(KilometrosRodados);
        setEficienciaDoMotor(EficienciaDoMotor);
    }
    void andar()
    {
        cout << "Vrum Vrum\n";
    }
    int getPegadaDeCarbono()
    {
        return getPegadaDeCarbono()*(int)getEficienciaDoMotor();
    }
};

class Bicicleta: public PegadaDeCarbono
{
    GETSET(string, Marca);
    int getPegadaDeCarbono()
    {
        return 0;
    }
};

class Predio: public PegadaDeCarbono
{
    GETSET(int, Andares);
    GETSET(int, ConsumoDeEnergiaPorAndar);
    Predio(int Andares, int ConsumoDeEnergiaPorAndar)
    {
        setConsumoDeEnergiaPorAndar(ConsumoDeEnergiaPorAndar);
        setAndares(Andares);
    }
    void construirNovoAndar()
    {
        setAndares(getAndares() + 1);
    }
    int getPegadaDeCarbono()
    {
        return getConsumoDeEnergiaPorAndar()*getAndares();
    }
};

class Escola: public Predio
{

};

class Casa: public Predio
{

};
