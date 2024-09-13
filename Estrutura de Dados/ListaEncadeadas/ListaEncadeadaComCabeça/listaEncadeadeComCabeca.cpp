#include <stdio.h>
#include <iostream>
using namespace std;

struct Node{
    string nome;
    int valor;
    Node* prox;

    Node(string nome, int valor){
        this->nome = nome;
        this->valor = valor;
        this->prox = nullptr;
    }
};



int main(){

    return 0;
}