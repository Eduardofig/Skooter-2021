#include <iostream>
#include <vector>
#include "getset.hpp"

class PegadaDeCarbono
{
    public:
        virtual int getPegadaDeCarbono() = 0;
};

class Carro: public PegadaDeCarbono
{
    GETSET(int, KilometrosRodados);
    GETSET(double, EficienciaDoMotor);
        public:
        Carro(int KilometrosRodados, double EficienciaDoMotor) 
        {
            setKilometrosRodados(KilometrosRodados);
            setEficienciaDoMotor(EficienciaDoMotor);
        }
        void andar()
        {
            std::cout << "Vrum Vrum\n";
        }
        int getPegadaDeCarbono()
        {
            return getPegadaDeCarbono()*(int)getEficienciaDoMotor();
        }
};

class Bicicleta: public PegadaDeCarbono
{
    GETSET(std::string, Marca);
    public:
        Bicicleta(std::string Marca) 
        {
            setMarca(Marca);
        }
        int getPegadaDeCarbono()
        {
            return 0;
        }
};

class Predio: public PegadaDeCarbono
{
    GETSET(int, Andares);
    GETSET(double, ConsumoDeEnergiaPorAndar);
    public:
        virtual void construirNovoAndar() = 0;
};

class Escola: public Predio
{
    GETSET(int, NumeroDeAlunos)
    public:
        Escola(int Andares, int NumeroDeAlunos, double ConsumoDeEnergiaPorAndar)
        {
            setConsumoDeEnergiaPorAndar(ConsumoDeEnergiaPorAndar);
            setAndares(Andares);
            setNumeroDeAlunos(NumeroDeAlunos);
        }
        void construirNovoAndar()
        {
            std::cout << "A escola esta em periodo de aula, nao e possivel construir novos andares" << std::endl;
        }
};

class Casa: public Predio
{

};

int main()
{
    std::vector<PegadaDeCarbono> listaPolimorfica;
    listaPolimorfica.push_back(*new Carro(10, 4.5));
    listaPolimorfica.push_back(*new Carro(11, 5.5));
    listaPolimorfica.push_back(*new Bicicleta("Canoi"));
    listaPolimorfica.push_back(*new Bicicleta("Cannondale"));
    listaPolimorfica.push_back(*new Predio(5, 4.4));
    listaPolimorfica.push_back(*new Predio(3, 3.3));
    for(int i = 0; i < listaPolimorfica.size(); ++i) {
        std::cout << listaPolimorfica[i].getPegadaDeCarbono() << std::endl;
    }
}
