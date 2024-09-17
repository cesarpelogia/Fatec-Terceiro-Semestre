#include <iostream>
#include <string>
using namespace std;

struct Node {
    string name;
    int value;
    Node* next;

    Node(string nome, int valor) : name(nome), value(valor), next(nullptr) {}
};

void addNode(Node* head, string name, int value) {
    Node* current = head;
    int counter = 0;

    while (current->next != nullptr) {
        current = current->next;
        counter++;
    }

    current->next = new Node(name, value);
    counter++;
    cout << "Nó inserido na posição " << counter << endl;
}

void updateNodeByPosition(Node* head, string name, int value, int position) {
    Node* current = head;
    int counter = 0;

    if (position == 0) {
        cout << "Impossível reescrever a posição 0, pois é a cabeça da lista" << endl;
    }

    while (counter != position) {
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


void updateNodeByData(Node* head, string olderName, int olderValue, string newName, int newValue) {
    Node* current =  head;

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

void linkedListSize(Node* head) {
    int counter = 0;

    if (head->next == nullptr) {
        cout << "A lista está vazia, " << counter << " posições" << endl;
    } else {
        Node* current = head->next;

        while (current != nullptr) {
            current = current->next;
            counter++;
        }

        cout << "A lista possui " << counter << " posições" << endl;
    }
}

void deleteNodeByData(Node* head, string name, int value) {
    int counter = 0;

    if (head->next == nullptr) {
        cout << "Impossível deletar nó de uma lista com " << counter << " nós." << endl;
    } else {
        Node* current = head->next;
        Node* previous = head;

        while (current != nullptr && (current->name != name || current->value != value)) {
            previous = current;
            current = current->next;
            counter++;
        }

        if (current == nullptr) {
            cout << "Nó não encontrado." << endl;
        } else {
            previous->next = current->next;
            delete current;
            counter++;
            cout << "Nó deletado na posição " << counter << "." << endl;
        }
    }
}

void deleteNodeByPosition(Node* head, int position) {
    int counter = 0;

    if (head->next == nullptr) {
        cout << "Impossível deletar nó de uma lista com " << counter << " nós." << endl;
    } else {
        Node* current = head->next;
        Node* previous = head;

        while (current != nullptr && position != counter) {
            counter++;
            previous = current;
            current = current->next;
        }

        if (current == nullptr) {
            cout << "Nó não encontrado." << endl;
        } else {
            previous->next = current->next;
            delete current;
            cout << "Nó deletado na posição " << counter << "." << endl;
        }
    }
};

int main() {
    Node* head = new Node("", 0);

    addNode(head, "Carlos", 1);
    addNode(head, "Ana", 2);
    addNode(head, "Pedro", 3);
    addNode(head, "Maria", 4);
    addNode(head, "João", 5);

    linkedListSize(head);

    deleteNodeByData(head, "Pedro", 3);

    linkedListSize(head);

    return 0;
}