#include <iostream>
#include <vector>
using namespace std;

struct Node {
    int value;
    Node* right;
    Node* left;

    Node(int val) : value(val), right(nullptr), left(nullptr) {}
};

struct Tree {
    Node* root;

    Tree() : root(nullptr) {}

    void insert(int val) {
        root = insertNode(root, val);
    }

        void printInOrder() {
        cout << "Percurso In-Order (Em Ordem):" << endl;
        inOrder(root);
        cout << endl;
    }

    void printPreOrder() {
        cout << "Percurso Pre-Order (Pré-Ordem):" << endl;
        preOrder(root);
        cout << endl;
    }

    void printPostOrder() {
        cout << "Percurso Post-Order (Pós-Ordem):" << endl;
        postOrder(root);
        cout << endl;
    }

private:
    Node* insertNode(Node* node, int val) {
        if (node == nullptr) {
            cout << "Inserindo nó com valor " << val << endl;
            return new Node(val);
        }

        if (val < node->value) {
            cout << "Valor " << val << " é menor que " << node->value << ", indo para a esquerda." << endl;
            node->left = insertNode(node->left, val);
        } else if (val > node->value){
            cout << "Valor " << val << " é maior que " << node->value << ", indo para a direita." << endl;
            node->right = insertNode(node->right, val);
        }
        return node;
    }

    void inOrder(Node* node){
        if (node != nullptr){
            inOrder(node->left);
            cout << "Visitando nó com valor: " << node->value << endl;
            inOrder(node->right);
        }
    }

    void preOrder(Node* node) {
        if (node != nullptr) {
            cout << "Visitando nó com valor: " << node->value << endl;
            preOrder(node->left);
            preOrder(node->right);
        }
    }

    void postOrder(Node* node) {
        if (node != nullptr) {
            postOrder(node->left);
            postOrder(node->right);
            cout << "Visitando nó com valor: " << node->value << endl;
        }
    }
};

int main(){

    vector<int> values = {10, 5, 3, 5, 7, 10, 15, 12, 15, 20, 17, 20, 25, 30, 25};
    
    Tree tree;

    for (int val : values){
        tree.insert(val);
    }
    
    tree.printInOrder();
    tree.printPreOrder();
    tree.printPostOrder();

    return 0;
}