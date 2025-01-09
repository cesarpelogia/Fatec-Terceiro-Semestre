#include <iostream>
#include <chrono>


using namespace std;
using namespace std::chrono;

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
            cout << "Pilha vazia" << endl;
            return true;
        } else {
            cout << "Pilha contém elementos." << endl;
            return false;
        }
    }

    Node* searchNode(int value){
        Node* current = top;
        while(current != nullptr){
            if(current->value == value){
                cout << "Valor encontrado: " << current->value << endl;
                return current;
            }
            current = current->next;
        }
        cout << "Valor não encontrado." << endl;
        return nullptr;
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

    Node* removeNode(){
        if(top == nullptr){
            cout << "Pilha vazia." << endl;
        }

        Node* nodeToRemove = top;
        top = top->next;

        return nodeToRemove;
        
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

    // Verificação de pilha vazia e medição de tempo
    auto EmptyStackStart = high_resolution_clock::now();
    stack.isEmpty();
    auto EmptyStackEnd = high_resolution_clock::now();
    auto EmptyStackDuration = duration_cast<nanoseconds>(EmptyStackEnd - EmptyStackStart);
    cout << "Tempo de execução da verificação de pilha vazia: " << EmptyStackDuration.count() << " nanosegundos" << endl;
    cout << "\n" << endl;

    // Adição de nó na pilha e medição de tempo
    auto AddNodeStart = high_resolution_clock::now();
    stack.addNode(10); // Inicializa a pilha com 10
    stack.addNode(20); // Adiciona o valor 20 no topo
    stack.addNode(30); // Adiciona o valor 30 no topo
    stack.addNode(40); // Adiciona o valor 40 no topo
    stack.addNode(50); // Adiciona o valor 50 no topo
    stack.addNode(60); // Adiciona o valor 60 no topo
    stack.addNode(70); // Adiciona o valor 70 no topo
    stack.addNode(80); // Adiciona o valor 80 no topo
    stack.addNode(90); // Adiciona o valor 90 no topo
    stack.addNode(100); // Adiciona o valor 100 no topo
    auto AddNodeEnd = high_resolution_clock::now();
    auto AddNodeDuration = duration_cast<nanoseconds>((AddNodeEnd - AddNodeStart)/10);
    cout << "Tempo de execução da adição por nó na pilha: " << AddNodeDuration.count() << " microssegundos" << endl;
    cout << "" << endl;

    // Primeira verificação do topo da pilha e medição de tempo
    auto PeekStart = high_resolution_clock::now();
    stack.peek();
    auto PeekEnd = high_resolution_clock::now();
    auto PeekDuration = duration_cast<nanoseconds>(PeekEnd - PeekStart);
    cout << "Tempo de execução da verificação do topo da pilha: " << PeekDuration.count() << " nanosegundos" << endl;
    cout << "" << endl;

    // Remoção nó na pilha e medição de tempo
    auto RemoveNodeStart = high_resolution_clock::now();
    Node* node1 = stack.removeNode();
    auto RemoveNodeEnd = high_resolution_clock::now();
    cout << "Nó removido: " << node1->value << endl;
    auto RemoveNodeDuration = duration_cast<nanoseconds>(RemoveNodeEnd - RemoveNodeStart);
    cout << "Tempo de execução da remoção de nó na pilha: " << RemoveNodeDuration.count() << " nanosegundos" << endl;
    cout << "" << endl;

     // Segunda verificação do topo da pilha e medição de tempo
    auto PeekStart2 = high_resolution_clock::now();
    stack.peek();
    auto PeekEnd2 = high_resolution_clock::now();
    auto PeekDuration2 = duration_cast<nanoseconds>(PeekEnd2 - PeekStart2);
    cout << "Tempo de execução da verificação do topo da pilha: " << PeekDuration2.count() << " nanosegundos" << endl;
    cout << "" << endl;

    // Busca de nó na pilha e medição de tempo
    auto SearchNodeStart = high_resolution_clock::now();
    stack.searchNode(10);
    auto SearchNodeEnd = high_resolution_clock::now();
    auto SearchNodeDuration = duration_cast<nanoseconds>(SearchNodeEnd - SearchNodeStart);
    cout << "Tempo de execução da busca do primeiro nó na pilha: " << SearchNodeDuration.count() << " nanosegundos" << endl;
    cout << "" << endl;

    return 0;
}