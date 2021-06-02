#include "../exercicio-2/NumeroComplexo.cpp"

//Overload dos operators
NumeroComplexo operator+(NumeroComplexo &z1, NumeroComplexo &z2) 
{
    return z1.soma(z2);
}
NumeroComplexo operator*(NumeroComplexo &z1, NumeroComplexo &z2) 
{
    return z1.multiplicacao(z2);
}
NumeroComplexo operator-(NumeroComplexo &z1, NumeroComplexo &z2) 
{
    return z1.subtracao(z2);
}
int operator!(NumeroComplexo &z)
{
    return z.modulo();
}

