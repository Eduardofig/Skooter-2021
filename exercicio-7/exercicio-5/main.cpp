#include "../exercicio-3/Overload.cpp"
#include <vector>

int main()
{
    int n;
    cin >> n;
    vector<NumeroComplexo> v(n);
    for (int i = 0; i < n; ++i) {
        v[i] = *new NumeroComplexo(rand() % 50, rand() % 50);
    }
    NumeroComplexo soma(0, 0);
    for(vector<NumeroComplexo>::iterator i = v.begin(); i < v.end(); i++) {
        soma = soma + *i;
    }
    soma.printNumero();
    //Deletando os objetos
    v.clear();
}
