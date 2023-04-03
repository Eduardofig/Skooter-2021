#include <iostream>
#include <cmath>
#include "../getset.hpp"

using namespace std;

class NumeroComplexo
{
    GETSET(double, ParteReal);
    GETSET(double, ParteImaginaria);
    public:
        NumeroComplexo() = default;
        NumeroComplexo(double ParteReal, double ParteImaginaria)
        {
            setParteReal(ParteReal);
            setParteImaginaria(ParteImaginaria);
        }
        //Operacoes
        NumeroComplexo soma(NumeroComplexo &z)
        {
            return *new NumeroComplexo(getParteReal() + z.getParteReal(), getParteImaginaria() + z.getParteImaginaria());
        }
        NumeroComplexo subtracao(NumeroComplexo &z)
        {
            return *new NumeroComplexo(getParteReal() - z.getParteReal(), getParteImaginaria() - z.getParteImaginaria());
        }
        NumeroComplexo multiplicacao(NumeroComplexo &z)
        {
            return *new NumeroComplexo(getParteReal()*z.getParteReal() - getParteImaginaria()*z.getParteImaginaria(),
                    getParteReal()*z.getParteImaginaria() + getParteImaginaria()*z.getParteReal());
        }
        int modulo()
        {
            return sqrt(pow(getParteReal(), 2) + pow(getParteImaginaria(), 2));
        }
        //Impressao do numero
        void printNumero()
        {
            cout << getParteReal() << " + " << getParteImaginaria() << "i\n";
        }
};
