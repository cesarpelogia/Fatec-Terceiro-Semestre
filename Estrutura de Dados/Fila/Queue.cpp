#include <iostream>
using namespace std;

struct Node {
    int value;
    Node* next;
};

struct QueueWithoutHead {

    void addNode(Node** top, Node** tail, int value){

        Node* newNode = new Node{value, nullptr};

        if(*top == nullptr){
            *top = newNode;
            *tail = newNode;
        } else {
            (*tail)->next = newNode;
            *tail = newNode;
        }
    }

    Node* deleteNode(Node **top, Node **tail) {
        if (*top == nullptr) {
            cout << "Fila vazia." << endl;
            return nullptr;
        }
    
        Node* nodeToRemove = *top;
        *top = (*top)->next;
    
        if (*top == nullptr) {
            *tail = nullptr;
        }
        return nodeToRemove;
    }

    bool isEmpty(Node* top) {
        return top == nullptr;
    }

    void printQueue(Node** top){
        Node* current = *top;
        int counter = 0;

        while(current != nullptr){
            cout << "Nó da posição: " << counter << " | valor: " << current->value << "." << endl;
            current = current->next;
            counter++;
        }
    }
    
};

int main(){

    Node* top = nullptr;
    Node* tail = nullptr;

    QueueWithoutHead queue;


    queue.addNode(&top, &tail, 1);
    queue.addNode(&top, &tail, 2);
    queue.addNode(&top, &tail, 3);

    cout << "----------" << endl;

    queue.printQueue(&top);

    cout << "----------" << endl;

    Node* node = queue.deleteNode(&top, &tail);
    cout << "Nó removido: " << node->value << endl;

    cout << "----------" << endl;

    queue.printQueue(&top);

    cout << "----------" << endl;

    queue.addNode(&top, &tail, 4);

    cout << "----------" << endl;

    queue.printQueue(&top);

    return 0;
}