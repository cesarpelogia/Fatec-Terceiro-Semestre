#include <iostream>
#include <string>
using namespace std;

struct Node {
    string name;
    int value;
    Node* next;

    Node(string nome, int valor) : name(nome), value(valor), next(nullptr) {}
};

struct LinkedList {
    Node* head;
    Node* tail;

    LinkedList() : head(new Node("", 0)), tail(head) {}

    void addNode(string name, int value) {
        Node* newNode = new Node(name, value);
        tail->next = newNode;
        tail = newNode;
        cout << "Nó inserido: " << name << " com valor " << value << endl;
    }

    void updateNodeByPosition(string name, int value, int position) {
        Node* current = head->next;
        int counter = 0;

        while (current != nullptr && counter != position) {
            current = current->next;
            counter++;
        }

        if (current == nullptr) {
            cout << "Posição não encontrada." << endl;
        } else {
            current->name = name;
            current->value = value;
        }
    }

    void updateNodeByData(string olderName, int olderValue, string newName, int newValue) {
        Node* current = head->next;

        while (current != nullptr) {
            if (current->name == olderName) {
                if (current->value != olderValue) {
                    cout << "Parâmetros incorretos. Nome e valor não coincidem" << endl;
                } else {
                    current->name = newName;
                    current->value = newValue;
                }
                break;
            }
            current = current->next;
        }
        if (current == nullptr) {
            cout << "Nome e valor não encontrado na lista" << endl;
        }
    }

    void linkedListSize() {
        int counter = 0;
        Node* current = head->next;

        while (current != nullptr) {
            current = current->next;
            counter++;
        }

        cout << "A lista possui " << counter << " posições" << endl;
    }

    void deleteNodeByData(string name, int value) {
        Node* current = head->next;
        Node* previous = head;

        while (current != nullptr && (current->name != name || current->value != value)) {
            previous = current;
            current = current->next;
        }

        if (current == nullptr) {
            cout << "Nó não encontrado." << endl;
        } else {
            previous->next = current->next;
            if (current == tail) {
                tail = previous;
            }
            delete current;
            cout << "Nó deletado: " << name << " com valor " << value << endl;
        }
    }

    void deleteNodeByPosition(int position) {
        Node* current = head->next;
        Node* previous = head;
        int counter = 0;

        while (current != nullptr && counter != position) {
            previous = current;
            current = current->next;
            counter++;
        }

        if (current == nullptr) {
            cout << "Nó não encontrado." << endl;
        } else {
            previous->next = current->next;
            if (current == tail) {
                tail = previous;
            }
            delete current;
            cout << "Nó deletado na posição " << counter << "." << endl;
        }
    }
};

int main() {
    LinkedList list;

    list.addNode("Carlos", 1);
    list.addNode("Ana", 2);
    list.addNode("Pedro", 3);
    list.addNode("Maria", 4);
    list.addNode("João", 5);

    list.linkedListSize();

    list.deleteNodeByData("Pedro", 3);

    list.linkedListSize();

    return 0;
}