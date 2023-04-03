#include <iostream>
#include "../getset.hpp"

using namespace std;

//Classe parente para todas as excessoes da classe Conta Corrente
class ContaExcessao: public exception
{
    virtual const char *what() const throw()
    { 
        return "Erro na operacao da conta";
    }
    GETSET(string, Message);
    public:
        ContaExcessao(string message)
        {
            setMessage(message);
        }
};

//Classe para excessao do tipo "saldo inssuficiente"
class SaldoInsuficiente: public ContaExcessao
{
    public:
        SaldoInsuficiente(): ContaExcessao("Saldo e Credito insuficientes para o valor de saque desejado"){}
};

//Classe para excessao do tipo "saque invalido"
class SaqueInvalido: public ContaExcessao
{
    public:
        SaqueInvalido(): ContaExcessao("Saque de valor invalido"){}
};

//Classe para excessao do tipo "deposito invalido"
class DepositoInvalido: public ContaExcessao
{
    public:
        DepositoInvalido(): ContaExcessao("Valor de Deposito Invalido"){}
};

//Classe para a conta corrente
class ContaCorrente
{
    //Getters e Setters
    GETSET(float, CreditoLimite);
    GETSET(float, Saldo);
    GETSET(float, ValorLimite);
    public:
        //Metodo Sacar
        void sacar(float valor)
        {
            //Se a pessoa sacar um valor superior ao valor limite ou um valor negativo
            //eh lancada a excessao valor invalido e se a pessoa tentar sacar um valor
            //superior ao seu saldo + creditoLimite eh lancada uma excessao de tipo saldo insuficiente
            if(valor > ValorLimite || valor <= 0) throw SaqueInvalido();
            if(valor > getCreditoLimite() + getSaldo()) throw SaldoInsuficiente();
            setSaldo(getSaldo() - valor);
            //clausula if para impedir que a pessoa fique com saldo negativo
            if(getSaldo() > valor) {
                setSaldo(getSaldo() - valor);
            } else {
                setCreditoLimite(getCreditoLimite() > (valor - getSaldo()? getCreditoLimite() - (valor + getSaldo()): 0));
                setSaldo(0);
            }
            cout << "Saque de " << valor << "R$ efetuado com sucesso\n";
        }
        void depositar(float valor)
        {
            if(valor < 0) throw DepositoInvalido();
            setSaldo(getSaldo() + valor);
            cout << "Deposito de " << valor << "R$ efetuado com sucesso\n";
        }
        //Construtor
        ContaCorrente(float creditoLimite, float valorLimite)
        {
            setSaldo(0);
            setCreditoLimite(creditoLimite);
            setValorLimite(valorLimite);
        }
};
