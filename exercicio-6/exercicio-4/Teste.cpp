#include "Pilha.cpp"

int main()
{
    Pilha p(10);
    //Tentativa de dar o pop em uma pilha vazia
    try
    {
        p.pop();
    }
    catch (PilhaExcessao ex)
    {
        cout << ex.what() << endl << ex.getErro() << endl;
    }
    //Push de 11 elementos na pilha, como o limite da pilha eh 10,
    //o decimo primeiro ira lancar uma excessao
    for(int i = 0; i < 11; ++i) {
        try
        {
            p.push(i);
        }
        catch(PilhaExcessao ex)
        {
            cout << ex.what() << endl << ex.getErro() << endl;
        } 
    }
    //Pop em uma pilha nao vazia
    try 
    {
        p.pop();
    }
    catch(PilhaExcessao ex)
    {
        cout << ex.what() << endl << ex.getErro() << endl;
    } 
}
