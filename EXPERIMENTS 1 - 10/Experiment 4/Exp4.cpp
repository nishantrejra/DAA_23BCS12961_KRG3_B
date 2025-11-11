#include <iostream>
using namespace std;

class Node {
public:
    int data;
    Node* next;
    Node* prev;
    Node(int val) : data(val), next(nullptr), prev(nullptr) {}
};

class DoublyList {
    Node* head;
public:
    DoublyList() : head(nullptr) {}
    void insertBegin(int val) {
        Node* n = new Node(val);
        if (!head) head = n;
        else {
            n->next = head;
            head->prev = n;
            head = n;
        }
    }
    void insertEnd(int val) {
        Node* n = new Node(val);
        if (!head) head = n;
        else {
            Node* temp = head;
            while (temp->next) temp = temp->next;
            temp->next = n;
            n->prev = temp;
        }
    }
    void deleteBegin() {
        if (!head) return;
        Node* temp = head;
        head = head->next;
        if (head) head->prev = nullptr;
        delete temp;
    }
    void deleteEnd() {
        if (!head) return;
        if (!head->next) {
            delete head;
            head = nullptr;
            return;
        }
        Node* temp = head;
        while (temp->next) temp = temp->next;
        temp->prev->next = nullptr;
        delete temp;
    }
    void display() {
        Node* temp = head;
        while (temp) {
            cout << temp->data << " ";
            temp = temp->next;
        }
        cout << endl;
    }
};

class CircularList {
    Node* last;
public:
    CircularList() : last(nullptr) {}
    void insertBegin(int val) {
        Node* n = new Node(val);
        if (!last) {
            last = n;
            n->next = n;
        } else {
            n->next = last->next;
            last->next = n;
        }
    }
    void insertEnd(int val) {
        Node* n = new Node(val);
        if (!last) {
            last = n;
            n->next = n;
        } else {
            n->next = last->next;
            last->next = n;
            last = n;
        }
    }
    void deleteBegin() {
        if (!last) return;
        if (last->next == last) {
            delete last;
            last = nullptr;
        } else {
            Node* temp = last->next;
            last->next = temp->next;
            delete temp;
        }
    }
    void deleteEnd() {
        if (!last) return;
        if (last->next == last) {
            delete last;
            last = nullptr;
        } else {
            Node* temp = last->next;
            while (temp->next != last) temp = temp->next;
            temp->next = last->next;
            delete last;
            last = temp;
        }
    }
    void display() {
        if (!last) {
            cout << endl;
            return;
        }
        Node* temp = last->next;
        do {
            cout << temp->data << " ";
            temp = temp->next;
        } while (temp != last->next);
        cout << endl;
    }
};

int main() {
    cout << "---Doubly Linked List---" <<endl;
    DoublyList dl;
    dl.insertBegin(10);
    dl.insertEnd(20);
    dl.insertBegin(5);
    cout << "Display: ";
    dl.display();
    dl.deleteBegin();
    cout << "Display after deleteBegin: ";
    dl.display();
    dl.deleteEnd();
    cout << "Display after deleteEnd: ";
    dl.display();

    cout << "---Circular Linked List---" <<endl;
    CircularList cl;
    cl.insertEnd(1);
    cl.insertEnd(2);
    cl.insertBegin(0);
    cout << "Display: ";
    cl.display();
    cl.deleteBegin();
    cout << "Display after deleteBegin: ";
    cl.display();
    cl.deleteEnd();
    cout << "Display after deleteEnd: ";
    cl.display();

    return 0;
}
