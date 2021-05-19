#include "Pilha.cpp"

int main()
{
    Pilha p(10);
    try
    {
        p.pop();
    }
    catch (PilhaExcessao e)
    {
        cout << e.what() << endl << e.getErro() << endl;
    }
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
}
