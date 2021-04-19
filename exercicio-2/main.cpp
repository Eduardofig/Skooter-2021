#include <bits/stdc++.h>

class Termo
{
    private:
        int coeficiente;
        int grau;
    public:

        void mudarCoeficiente(int coeficiente) {
            this->coeficiente = coeficiente;
        }

        void mudarGrau(int grau)
        {
            this->grau = grau;
        }

        int acessarCoeficiente()
        {
            return this->coeficiente;
        }

        int acessarGrau()
        {
            return this->grau;
        }
};

class Polinomio
{
    private:
        int grauMaximo;
        std::vector<Termo> termos;
    public:
        Polinomio(int grauMaximo)
        {
            this->grauMaximo = grauMaximo;
        }
        void Add(Termo termo) 
        {
            if(termo.acessarGrau() > this->grauMaximo) {
                return;
            }
            for(int i = 0; i < this->termos.size(); i++) {
                if(this->termos[i].acessarGrau() == termo.acessarGrau()) {
                    this->termos[i].mudarCoeficiente(this->termos[i].acessarCoeficiente() + termo.acessarCoeficiente());
                    return;
                }
            }
            this->termos.push_back(termo);
        }
        void Mostra()
        {
            for(Termo termo: this->termos) {
                std::cout << termo.acessarCoeficiente() << "x^" << termo.acessarGrau() << " ";
            }
            std::cout << std::endl;
        }
        int Calcula(int num)
        {
            int resposta;
            for(Termo termo: this->termos) {
                resposta += termo.acessarCoeficiente()*(int)pow(num, termo.acessarCoeficiente());
            }
            return resposta;
        }
};

int main()
{
    Polinomio polinomio(7);
    Termo termo;
    for (int i = 1; i < 7; ++i) {
        termo.mudarGrau(i);
        termo.mudarCoeficiente(i);
        polinomio.Add(termo);
    }
    termo.mudarGrau(5);
    termo.mudarCoeficiente(5);
    polinomio.Add(termo);
    polinomio.Mostra();
    std::cout << polinomio.Calcula(10) << std::endl;
}
