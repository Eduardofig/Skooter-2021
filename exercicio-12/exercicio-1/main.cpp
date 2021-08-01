#include <iostream>
#include "getset.hpp"

using namespace std;

template<typename T>
class GenericClass
{
    GETSET(T, A);
    GETSET(T, B);

    public:

        T getMax()
        {
            return max(getA(), getB());
        }

        T getMin()
        {
            return min(getA(), getB());
        }

        T getSum()
        {
            return getA() + getB();
        }
        
        GenericClass(T a, T b)
        {
            setA(a);
            setB(b);
        }
};

int main()
{
    GenericClass<double> doubleGeneric(2.3, 3.3);
    GenericClass<string> stringGeneric("a string menor", "z string maior");
    GenericClass<int> intGeneric(20, 0x3f3f3f3f);

    cout << "Double " << endl;
    cout << "\tMax: " << doubleGeneric.getMax() << endl;
    cout << "\tMin: " << doubleGeneric.getMin() << endl;
    cout << "\tSum: " << doubleGeneric.getSum() << endl;

    cout << "String " << endl;
    cout << "\tMax: " << stringGeneric.getMax() << endl;
    cout << "\tMin: " << stringGeneric.getMin() << endl;
    cout << "\tSum: " << stringGeneric.getSum() << endl;

    cout << "Int " << endl;
    cout << "\tMax: " << intGeneric.getMax() << endl;
    cout << "\tMin: " << intGeneric.getMin() << endl;
    cout << "\tSum: " << intGeneric.getSum() << endl;
}
