#include <iostream>
#include <queue>
#include "getset.hpp"

using namespace std;

template<typename T>
class DequeStack
{
    GETSET(deque<T>*, Dq);

    public: 
        void pop()
        {
            getDq()->pop_back();
        }

        void push(T elemento)
        {
            getDq()->push_back(elemento);
        }

        T top()
        {
            return getDq()->back();
        }

        bool empty()
        {
            return getDq()->empty();
        }

        DequeStack()
        {
            setDq(new deque<T>);
        }
};

int main()
{
    //Teste com int
    DequeStack<int> dqsInt;

    cout << "Int:" << endl;
    for(int i = 0; i < 10; ++i) {
        dqsInt.push(i);
    }

    while(!dqsInt.empty()) {
        cout << '\t' << dqsInt.top() << endl;
        dqsInt.pop();
    }

    //Teste com double
    cout << "Double:" << endl;
    DequeStack<double> dqsDouble;

    for(double i = 0; i < 5; i += 0.5) {
        dqsDouble.push(i);
    }

    while(!dqsDouble.empty()){
        cout << '\t' << dqsDouble.top() << endl;
        dqsDouble.pop();
    }

    //Teste com string
    cout << "String:" << endl;
    DequeStack<string> dqsString;

    for(string s = "a"; s != "aaaaaaaaaaaa"; s += 'a') {
        dqsString.push(s);
    }

    while(!dqsString.empty()){
        cout << '\t' << dqsString.top() << endl;
        dqsString.pop();
    }
}
