#include "ContaCorrente.cpp"

using namespace std;

int main()
{
    ContaCorrente conta(20, 300);
    //Tentativa de deposito normal
    try
    {
        conta.depositar(200);
    }
    catch(ContaExcessao ex)
    {
        cout << ex.getMessage();
    }
    //Tentativa de deposito de valor negativo
    try
    {
        conta.depositar(-10);
    }
    catch(ContaExcessao ex)
    {
        cout << ex.getMessage() << endl;
    }
    //Tentativa de saque superior a (saldo + creditoLimite)
    try
    {
        conta.sacar(221);
    }
    catch(ContaExcessao ex)
    {
        cout << ex.getMessage() << endl;
    }
    //Tentativa de saldo superior a valor limite
    try
    {
        conta.sacar(301);
    }
    catch(ContaExcessao ex)
    {
        cout << ex.getMessage() << endl;
    }
    //Tentativa de saque normal
    try
    {
        conta.sacar(200);
    }
    catch(ContaExcessao ex)
    {
        cout << ex.getMessage() << endl;
    }
    //Tentativa de saque de valor negativo
    try
    {
        conta.sacar(-200);
    }
    catch(ContaExcessao ex)
    {
        cout << ex.getMessage() << endl;
    }
}
