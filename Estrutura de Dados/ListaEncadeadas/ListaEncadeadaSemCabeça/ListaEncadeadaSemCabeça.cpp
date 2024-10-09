#include <iostream>
using namespace std;

struct Node {
    int value;
    Node* next;

    Node(int value) : value(value), next(nullptr) {}
};

struct LinkedListWithoutHead {

    void addNode(Node** head, int value) {
        if (*head == nullptr) {
            *head = new Node(value);
            cout << "Nó adicionado na posição 0, com valor: " << value << endl;
            return;
        }

        Node* temp = *head;
        int position = 0;

        while (temp->next != nullptr) {
            temp = temp->next;
            position++;
        }

        temp->next = new Node(value);
        cout << "Nó adicionado na posição: " << (position + 1) << ", com valor: " << value << endl;
    }

    void updateNodeByPosition(Node** head, int value, int position) {
        if (*head == nullptr) {
            cout << "Lista está vazia." << endl;
            return;
        }

        Node* current = *head;
        Node* previous = nullptr;
        int counter = 0;

        if (position == 0) {
            Node* newNode = new Node(value);
            newNode->next = (*head)->next;
            delete *head;
            *head = newNode;
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

    Node* deleteNodeByPosition(Node** head, int position) {
        if (*head == nullptr) {
            cout << "Impossível deletar nó de uma lista vazia." << endl;
            return nullptr;
        }

        if (position == 0) {
            Node* temp = *head;
            *head = (*head)->next;
            delete temp;
            cout << "Nó na posição 0 (cabeça) deletado." << endl;
            return temp;
        }

        Node* current = *head;
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
            return current;
        }
    }

    void printList(Node** head) {
        if (*head == nullptr) {
            cout << "A lista está vazia, 0 posições" << endl;
            return;
        }

        Node* current = *head;
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
    Node* head = nullptr;
    LinkedListWithoutHead lst;

    lst.addNode(&head, 10);
    lst.addNode(&head, 11);
    lst.addNode(&head, 12);

    cout << endl;

    lst.printList(&head);

    cout << endl;

    lst.updateNodeByPosition(&head, 50, 0);
    lst.updateNodeByPosition(&head, 1, 1);
    lst.updateNodeByPosition(&head, 2, 2);

    cout << endl;

    lst.printList(&head);

    cout << endl;

    Node* node1 = lst.deleteNodeByPosition(&head, 2);
    cout << "Nó removido: " << node1 << endl;

    Node* node2 = lst.deleteNodeByPosition(&head, 1);
    cout << "Nó removido: " << node2 << endl;

    cout << endl;

    lst.printList(&head);

    return 0;
}