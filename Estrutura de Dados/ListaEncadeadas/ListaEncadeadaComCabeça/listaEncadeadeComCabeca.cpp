#include <iostream>
#include <string>
using namespace std;

struct Node {
    string name;
    int value;
    Node* next;

    // Construtor com lista de inicialização
    Node(string nome, int valor) : name(nome), value(valor), next(nullptr) {}
};

void addNode(Node* head, string name, int value) {
    Node* current = head;

     // Inicializando o contador de posição com 0.
    int counter = 0;

    // Percorre a lista até encontrar o último nó
    while (current->next != nullptr) {
        current = current->next;
        counter++; // Incrementa o contador para cada nó existente
    }

    // Sai do while quando encontra o último nó.
    // Adiciona o novo nó após o último nó e incrementa o contador.
    current->next = new Node(name, value);
    counter++;
    cout << "Nó inserido na posição " << counter << endl;
}

void updateNodeByPosition(Node*head, string name, int value, int position){
    Node* current = head;

    int counter = 0;

    if (position == 0){
        cout << "Impossível reescrever a posição 0, pois é a cabeça da lista" << endl;
    }
    // Percorre a lista até achar a posição.
    while(counter != position){
        current = current -> next;
        counter++;
    }
    if (current == nullptr){
        cout << "Posição não encontrada." << endl;
    } else {
        current -> name = name;
        current -> value = value;
    }
}

void updateNodeByData(Node* head, string olderName, int olderValue, string newName, int newValue){
    
}

void linkedListSize(Node* head) {
    // Verifica se existe um nó depois da cabeça e inicia um contador.
    int counter = 0;
    if (head->next == nullptr) {
        // Se o ponteiro da cabeça for nulo, a lista está vazia.
        cout << "A lista está vazia, " << counter << " posições" << endl;
    } else {
        // Inicializa o ponteiro current para começar
        // a percorrer a lista a partir do primeiro nó real.
        Node* current = head->next;

        // Enquanto esse ponteiro não for nulo, vai setando current com o próximo
        // e incrementando o contador.
        while (current != nullptr) {
            current = current->next;
            counter++;
        }

        // Imprime o tamanho da lista
        cout << "A lista possui " << counter << " posições" << endl;
    }
}

void deleteNodeByData(Node* head, string name, int value){
    int counter = 0;

    // Verifica se o existe algum nó depois do head. Caso não exista, a lista está vazia.
    if (head -> next == nullptr){
        cout << "Impossível deletar nó de uma lista com " << counter << " nós." << endl;
    } else {

        // setando o ponteiro current para o primeiro nó verdadeiro.
        Node* current = head -> next;

        // setando o ponteiro previous para o nó cabeça.
        Node* previous = head;

        while(current != nullptr && (current->name != name || current -> value != value)) {
            
            // Seta o ponteiro previous para o nó atual.
            previous = current;
            // Muda o ponteiro do current para o próximo.
            current = current->next;
            // Incrementa o contador.
            counter++;
        }

        if ( current == nullptr) {
            cout << "Nó não encontrado." << endl;

        } else {
            // Ajustando o ponteiro para poder excluir sem perder o parâmetro.
            previous -> next = current -> next;
            // Deletando o nó atual.
            delete current;
            counter++;
            cout << "Nó deletado na posição " << counter << "." << endl;
        }
    }
}

void deleteNodeByPosition(Node* head, int position) {
    int counter = 0;

    // Verifica se existe algum nó depois do head. Caso não exista, a lista está vazia.
    if (head->next == nullptr) {
        cout << "Impossível deletar nó de uma lista com " << counter << " nós." << endl;

    } else {
        // Setando o ponteiro current para o primeiro nó verdadeiro.
        Node* current = head->next;

        // Setando o ponteiro previous para o nó cabeça.
        Node* previous = head;

        // Percorre a lista até encontrar a posição ou chegar ao final da lista
        while (current != nullptr && position != counter) {
            counter++;

            // Seta o ponteiro previous para o nó atual.
            previous = current;

            // Muda o ponteiro do current para o próximo.
            current = current->next;
        }

        // Verifica se o nó foi encontrado
        if (current == nullptr) {
            cout << "Nó não encontrado." << endl;
        } else {
            // Ajustando o ponteiro para poder excluir sem perder o parâmetro.
            previous->next = current->next;
            // Deletando o nó atual.
            delete current;
            cout << "Nó deletado na posição " << counter << "." << endl;
        }
    }
}



int main() {
    
    // Criando o nó cabeça
    Node* head = new Node("", 0);

    // Adicionando nós
    addNode(head, "Carlos", 1);
    addNode(head, "Ana", 2);
    addNode(head, "Pedro", 3);
    addNode(head, "Maria", 4);
    addNode(head, "João", 5);

    // Verificando o tamanho da lista
    linkedListSize(head);

    // Deletando por parâmetro
    deleteNodeByData(head, "Pedro", 3);

    // Verificando o tamanho da lista após exclusão.
    linkedListSize(head);

    return 0;
}