#include <bits/stdc++.h>

//Classe geral para termo
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

//Classe para Polinomio
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
            //itera por todos os termos do polinomio para ver se ha um termo com o mesmo grau do termo a ser adicionado
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
                resposta += termo.acessarCoeficiente()*(int)pow(num, termo.acessarGrau());
            }
            return resposta;
        }
};

//Main para teste
int main()
{
    Polinomio polinomio(7);
    Termo termo;
    for (int i = 1; i < 7; ++i) {
        termo.mudarGrau(i);
        termo.mudarCoeficiente(i);
        polinomio.Add(termo);
    }
    //Adicao de termo de grau 5 que ja esta presente no polinomio
    termo.mudarGrau(5);
    termo.mudarCoeficiente(5);
    polinomio.Add(termo);
    polinomio.Mostra();
    std::cout << polinomio.Calcula(10) << std::endl;
}
