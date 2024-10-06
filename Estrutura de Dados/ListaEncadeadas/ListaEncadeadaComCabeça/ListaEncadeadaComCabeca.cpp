#include <iostream>
#include <string>
using namespace std;

struct Node {
    int value;
    Node* next;

    Node(int valor) : value(valor), next(nullptr) {}
};

struct LinkedListWithHead {

    Node* head = nullptr;

    void addNode(int value) {
        if (head == nullptr) {
            head = new Node(value);
            cout << "Nó de valor: " << value << " inserido na posição 0" << endl;
            return;
        }

        Node* current = head;
        int position = 0;

        while (current->next != nullptr) {
            current = current->next;
            position++;
        }

        current->next = new Node(value);
        position++;
        cout << "Nó de valor: " << value << " inserido na posição " << position << endl;
    }

void updateNodeByPosition(int value, int position) {
    if (head == nullptr) {
        cout << "Lista está vazia." << endl;
        return;
    }

    Node* current = head;
    Node* previous = nullptr;
    int counter = 0;

    if (position == 0) {
        Node* newNode = new Node(value);
        newNode->next = head->next;
        delete head;
        head = newNode;
        cout << "Nó de valor " << value << " na posição 0 substituído com sucesso." << endl;
        return;
    }

    while (current != nullptr && counter != position) {
        previous = current;
        current = current->next;
        counter++;
    }

    if (current == nullptr) {
        cout << "Posição inválida. A lista é menor do que " << position << " nós." << endl;
        return;
    }

    Node* newNode = new Node(value);
    newNode->next = current->next;
    previous->next = newNode;
    delete current;

    cout << "Nó de valor " << value << " na posição " << position << " substituído com sucesso." << endl;
}


    void deleteNodeByPosition(int position) {
        if (head == nullptr) {
            cout << "Impossível deletar nó de uma lista vazia." << endl;
            return;
        }

        if (position == 0) {
            Node* temp = head;
            head = head->next;
            delete temp;
            cout << "Nó na posição 0 (cabeça) deletado." << endl;
            return;
        }

        Node* current = head;
        Node* previous = nullptr;
        int counter = 0;

        while (current != nullptr && position != counter) {
            previous = current;
            current = current->next;
            counter++;
        }

        if (current == nullptr) {
            cout << "Nó não encontrado." << endl;
        } else {
            previous->next = current->next;
            cout << "Nó deletado na posição " << counter << " com valor: " << current->value << endl;
            delete current;
        }
    }

    void printList() {
        if (head == nullptr) {
            cout << "A lista está vazia, 0 posições" << endl;
            return;
        }

        Node* current = head;
        int counter = 0;


        while (current != nullptr) {
            cout << "Posição: " << counter << " com valor: " << current->value << endl;
            current = current->next;
            counter++;
        }

        cout << "A lista possui " << counter << " posições" << endl;
    }
};




int main() {

    LinkedListWithHead lst;
    
    lst.addNode(1);
    lst.addNode(2);
    lst.addNode(3);

    cout << "" << endl;

    lst.printList();

    cout << "" << endl;

    lst.updateNodeByPosition(0,0);
    lst.updateNodeByPosition(1,1);
    lst.updateNodeByPosition(2,2);

    cout << "" << endl;

    lst.printList();

    cout << "" << endl;

    lst.deleteNodeByPosition(1);
    lst.deleteNodeByPosition(1);

    cout << "" << endl;

    lst.printList();

    return 0;
}