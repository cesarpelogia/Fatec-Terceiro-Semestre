#include <iostream>
using namespace std;

struct Node {
    int value;
    Node* next;
};

struct StackWithHead {

    Node* top;

    StackWithHead(){
        top = nullptr;
    }

    bool isEmpty(){
        if (top == nullptr){
            cout << "Pila vazia" << endl;
            return true;
        } else {
            cout << "Pilha contém elementos." << endl;
            return false;
        }
    }

    void addNode(int value){

        Node* newNode = new Node();
        newNode->value = value;
        

        if(top == nullptr){
            newNode->next = nullptr;
            top = newNode;
            cout << "Pilha inicializada com valor: " << value << "." << endl;
            return;
        }

        newNode->next = top;
        top = newNode;
        cout << "Adicionado nó no topo da pilha com valor: " << value << "." << endl;
    }

    void removeNode(){
        if(top == nullptr){
            cout << "Pilha vazia." << endl;
        }

        Node* nodeToRemove = top;
        top = top->next;
        delete nodeToRemove;
        cout << "Nó removido do topo da pilha." << endl;
    }
    
    void peek() {
        if (top == nullptr) {
            cout << "A pilha está vazia." << endl;
        } else {
            cout << "Valor no topo: " << top->value << endl;
        }
    }
};

int main(){

    StackWithHead stack;

    stack.isEmpty();   // Pilha vazia

    cout << "" << endl;

    stack.addNode(10); // Inicializa a pilha com 10
    stack.addNode(20); // Adiciona o valor 20 no topo
    stack.addNode(30); // Adiciona o valor 30 no topo

    cout << "" << endl;
    stack.peek();      // Verifica o valor no topo (30)

    cout << "" << endl;

    stack.removeNode();// Remove o nó do topo (30)

    cout << "" << endl;

    stack.peek();      // Verifica o valor no topo (20)

    cout << "" << endl;

    stack.isEmpty();   // Verifica se a pilha está vazia

    cout << "" << endl;
    
    stack.removeNode();// Remove o nó do topo (20)
    stack.removeNode();// Remove o nó do topo (10)

    cout << "" << endl;

    stack.removeNode();// Tenta remover da pilha vazia

    cout << "" << endl;
    
    stack.isEmpty();   // Verifica se a pilha está vazia

    return 0;
}