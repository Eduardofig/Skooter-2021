#include <iostream>
#include <stack>
#include "../getset.hpp"

using namespace std;

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

class PilhaVazia: public PilhaExcessao
{
    public:
        PilhaVazia(): PilhaExcessao("Nao eh possivel dar pop na sua Pilha pois ela esta vazia"){}
};

class PilhaCheia: public PilhaExcessao
{
    public:
        PilhaCheia(): PilhaExcessao("Nao eh possivel dar push na sua Pilha pois ela esta cheia"){}
};

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
            if(pilha.empty()) {
                throw PilhaVazia();
            }
            pilha.pop();
        }
        void push(int num) {
            if(pilha.size() + 1 > getCapacidade()) {
                throw PilhaCheia();
            }
            pilha.push(num);
        }
};
