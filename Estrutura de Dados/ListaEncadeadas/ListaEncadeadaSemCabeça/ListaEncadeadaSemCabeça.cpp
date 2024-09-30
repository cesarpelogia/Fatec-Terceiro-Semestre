#include <iostream>
using namespace std;

struct Node {
    string name;
    int value;
    Node* next;

    Node(string name, int value) : name(name), value(value), next(nullptr) {}
};

struct LinkedListWhitoutHead {
private:
    Node* head;

public:
    LinkedListWhitoutHead() : head(nullptr) {}

    void initializeList(string name, int value) {
        if (head == nullptr) {
            head = new Node(name, value);
            cout << "Lista inicializada com nó de nome: " << head->name << " e valor: " << head->value << endl << endl;
        } else {
            cout << "A lista já foi inicializada." << endl << endl;
        }
    }

    void addNode(string name, int value) {
        Node** headRef = &head;
        Node* newNode = new Node(name, value);
        newNode->next = *headRef;
        *headRef = newNode;

        cout << "Nó adicionado com nome: " << newNode->name << " e valor: " << newNode->value << endl << endl;
    }
};

int main() {
    LinkedListWhitoutHead lst;

    lst.initializeList("Node1", 1);
    lst.addNode("Node2", 2);
    lst.addNode("Node3", 3);

    return 0;
}