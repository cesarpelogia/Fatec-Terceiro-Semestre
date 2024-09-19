#include <iostream>
using namespace std;

struct Node {
    string name;
    int value;
    Node* next;

    Node(string name, int value) : name(name), value(value), next(nullptr) {}
};

Node* head = nullptr;


struct LinkedListWhitoutHead{

    void addNode(string name, int value){
        Node* newNode = new Node(name, value);
        int counter = 0;
        
        if(head == nullptr){
            head = newNode;
        } else {
            Node* temporary = head;
            counter++;
            while (temporary->next != nullptr){
                counter++;
                temporary = temporary->next;
            }
            temporary->next = newNode;
        }
        cout << "Nó adicionado na posição " << counter << ", com nome: " << newNode->name << " e valor: " << newNode->value << endl << endl;
    };

    void getNodeByPosition(int position){
        Node* current = head;
        int counter = 0;

        while (counter != position){
            if(current == nullptr){
                cout << "Posição não encontrada" <<  endl << endl;
                break;
            }
            counter++;
            current = current->next;
            if(counter == position){
            cout << "Nó encontrado! Nome: " << current->name << " Valor: " << current->value <<  endl << endl;
                break;
            }
        }
    };

    void updateNode(string olderName, int olderValue, string newName, int newValue) {
        Node* current = head;
        int counter = 0;

        while (current != nullptr) {
            if (current->name == olderName) {
                if (current->value != olderValue) {
                    cout << "Parâmetros incorretos. Nome e valor não coincidem" <<  endl << endl;
                    return;
                } else {
                    current->name = newName;
                    current->value = newValue;
                    cout << "Nó atualizado na posição " << counter << ". Atualizado para: " << current->name << ", " << current->value <<  endl << endl;
                    return;
                }
            }
            current = current->next;
            counter++;
        }
        cout << "Nó não encontrado" <<  endl << endl;
    }


    void deleteNode(string name, int value){
        Node* current = head;
        Node* previous = nullptr;
        int counter = 0;

        if(head == nullptr){
            cout << "A lista está vazia" <<  endl << endl;
            return;
        }
        
        if (head->name == name && head->value == value){
            Node* temporary = head;
            head = head->next;
            delete temporary;
            cout << "Nó removido na posição " << counter <<  endl << endl;
            return;
        }

        previous = head;
        current = head->next;
        counter++;
        
        while(current != nullptr){
            if (current->name == name){
                if (current->value != value){
                    cout << "Parâmetros incorretos. Nome e valor não coincidem" <<  endl << endl;
                    return;
                } else{
                    previous->next = current->next;
                    delete current;
                    cout << "Nó deletado na posição " << counter<<  endl << endl;
                    return;
                }
            }

            previous = current;
            current = current->next;
            counter++;
        }
        cout << "Nó não encontrado" << endl << endl;
    }
};

int main(){

    LinkedListWhitoutHead lst;

    lst.addNode("Anália", 0);
    lst.addNode("Bento", 1);
    lst.addNode("Carlos", 2);
    lst.addNode("Diego", 3);

    lst.getNodeByPosition(2); // Deve encontrar Carlos

    lst.updateNode("Carlos", 2, "Carlos Atualizado", 22); // Deve atualizar Carlos

    lst.getNodeByPosition(2); // Deve encontrar Carlos Atualizado

    lst.deleteNode("Carlos Atualizado", 22); // Deve deletar Carlos Atualizado

    lst.getNodeByPosition(2); // Deve encontrar Diego



    return 0;
};