#include <iostream>
using namespace std;

struct Node {
    string name;
    int value;
    Node* next;

    Node(string name, int value) : name(name), value(value), next(nullptr) {}
};

Node* head = nullptr;


void addNode(string name, int value){
    Node* newNode = new Node(name, value);
    
    if(head == nullptr){
        head = newNode;
    } else {
        Node* temporary = head;
        while (temporary != nullptr){
            temporary = temporary->next;
        }
        temporary->next = newNode;
    }
};

void updateNode(string olderName, int olderValue, string newName, int newValue){
    Node* current = head;
    int counter = 0;

    while(current != nullptr){
        counter++;
        if(current->name == olderName){
            if(current->value != olderValue){
                cout << "Parâmetros incorretos. Nome e valor não coincidem" << endl;
            }else{
                current->name = newName;
                current->value = newValue;
                cout << "Nós inserido na posição " << counter << endl;
                break;
            }
        current = current->next;
        }
    }
};

void deleNode(string name, int value){
    Node* current = head;
    Node* previous = nullptr;
    int counter = 0;

    if(head == nullptr){
        cout << "A lista está vazia" << endl;
        return;
    }
    
    if (head->name == name && head->value == value){
        Node* temporary = head;
        head = head->next;
        delete temporary;
        counter++;
        cout << "Nó removido na posição " << counter << endl;
        return;
    }
    current = head;
    while(current->next != nullptr){
        counter++;
        if (current->name == name){
            if (current->value != value){
                cout << "Parâmetros incorretos. Nome e valor não coincidem" << endl;
            } else{
                previous->next = current->next;
                delete current;
                cout << "Nó deletado na posição " << counter +1 << endl;
                return;
            }
            return;
        }
    }
};