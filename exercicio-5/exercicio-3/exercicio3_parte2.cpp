#include <iostream>
#include <vector>
#include "../getset.hpp"

class PegadaDeCarbono
{
    public:
        virtual int getPegadaDeCarbono() = 0;
};

class Carro: public PegadaDeCarbono
{
    GETSET(int, KilometrosRodados);
    GETSET(int, EficienciaDoMotor);
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
            return this->getPegadaDeCarbono()*this->getEficienciaDoMotor();
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
        int getPegadaDeCarbono()
        {
            return getNumeroDeAlunos()*(int)getConsumoDeEnergiaPorAndar();
        }
};

class Casa: public Predio
{
    GETSET(int, Andares);
    GETSET(int, ConsumoDeEnergiaPorAndar);
    public:
        Casa(int Andares, double ConsumoDeEnergiaPorAndar)
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
            return this->getConsumoDeEnergiaPorAndar()*this->getAndares();
        }
};

int main()
{
    /*O aplicativo nao funciona pois nao e possivel instanciar um objeto de uma classe abstrata*/
    std::vector<PegadaDeCarbono*> listaPolimorfica = {new Carro(10, 3), new Carro(11, 4), new Bicicleta("Canoi"), new Bicicleta("Cannondale"), new Predio(5, 4), new Predio(3, 3)};
    for(PegadaDeCarbono *p: listaPolimorfica) {
        std::cout << p->getPegadaDeCarbono() << std::endl;
    }
}
