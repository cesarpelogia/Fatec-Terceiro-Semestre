#include <iostream>
using namespace std;

struct Node {
    int value;
    Node* next;
};

struct QueueWhitoutHead {

    void addNode(Node** top, Node** tail, int value){

        Node* newNode = new Node();
        newNode->value = value;

        if(*top == nullptr || *tail == nullptr){
            newNode->next = nullptr;
            *top = newNode;
            *tail = newNode;
        } else {
            (*tail)->next = newNode;
            *tail = newNode;
        }
    }
};

int main(){

    Node* top;
    Node* tail;


    return 0;
}