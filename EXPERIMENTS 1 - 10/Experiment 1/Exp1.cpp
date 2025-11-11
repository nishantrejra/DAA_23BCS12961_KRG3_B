#include <iostream>
using namespace std;

template <typename T, int SIZE>
class Stack {
    T arr[SIZE];
    int topIndex;
public:
    Stack() : topIndex(-1) {}
    bool isEmpty() { 
        return topIndex == -1; 
    }
    bool isFull() { 
        return topIndex == SIZE - 1; 
    }
    void push(T value) {
        if (!isFull()) arr[++topIndex] = value;
        else cout << "Stack Full\n";
    }
    void pop() {
        if (!isEmpty()) --topIndex;
        else cout << "Stack Empty\n";
    }
    T top() {
        if (!isEmpty()) return arr[topIndex];
        throw runtime_error("Stack Empty");
    }
};

int main() {
    Stack<int,10> s;
    s.push(10);
    s.push(20);
    s.push(30);
    s.push(40);
    s.push(50);
    cout << "Top: ";
    cout << s.top() << endl;
    s.pop();
    cout << "Top after using pop(): ";
    cout << s.top() << endl;
    cout << (s.isEmpty() ? "Empty" : "Not Empty") << endl;
    return 0;
}
