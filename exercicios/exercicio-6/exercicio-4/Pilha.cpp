#include <iostream>
#include <stack>
#include "../getset.hpp"

using namespace std;

//Classe de excessao de pilha generica
class PilhaExcessao: public exception
{
    GETSET(string, Erro)
    public:
        virtual const char *what() const throw()
        {
            return "Sua Pilha deu erro";
        }
        PilhaExcessao(string mensagemErro)
        {
            setErro(mensagemErro);
        }
};

//Excessao de pilha vazia
class PilhaVazia: public PilhaExcessao
{
    public:
        PilhaVazia(): PilhaExcessao("Nao eh possivel dar pop na sua Pilha pois ela esta vazia"){}
};

//Excessao de pilha cheia
class PilhaCheia: public PilhaExcessao
{
    public:
        PilhaCheia(): PilhaExcessao("Nao eh possivel dar push na sua Pilha pois ela esta cheia"){}
};

//Classe Pilha
class Pilha 
{
    GETSET(int, Capacidade);
    private:
        stack<int> pilha;
    public:
        Pilha(int capacidade)
        {
            setCapacidade(capacidade);
        }
        void pop()
        {
            //Se a pilha estiver vazia eh lancada uma excessao do
            //tipo "pilha vazia"
            if(pilha.empty()) throw PilhaVazia();
            pilha.pop();
        }
        void push(int num) {
            //Se a pilha estiver cheia eh lancada uma excessao do
            //tipo "pilha cheia"
            if(pilha.size() + 1 > getCapacidade()) throw PilhaCheia();
            pilha.push(num);
        }
};
