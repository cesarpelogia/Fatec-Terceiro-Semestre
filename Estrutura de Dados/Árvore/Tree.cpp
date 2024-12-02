#include <iostream>
#include <vector>
using namespace std;

struct Node {
    int value;
    Node* right;
    Node* left;

    Node(int value) : value(value), right(nullptr), left(nullptr) {}
};

struct Tree {
    Node* root;

    Tree() : root(nullptr) {}

    void insert(int value) {
        root = insertNode(root, value);
    }

    Node* search(int searchedValue) {
        return searchNode(root, searchedValue);
    }

    Node* remove(int value) {
        root = removeNode(root, value);
        return root;
    }

    void print() {
        printInOrder(root);
        cout << endl;
    }

private:

    Node* insertNode(Node* node, int value) {
        if (node == nullptr) {
            cout << "Inserindo nó com valor " << value << endl;
            return new Node(value);
        }

        if (value < node->value) {
            cout << "Valor " << value << " é menor que " << node->value << ", indo para a esquerda." << endl;
            node->left = insertNode(node->left, value);
        } else if (value > node->value){
            cout << "Valor " << value << " é maior que " << node->value << ", indo para a direita." << endl;
            node->right = insertNode(node->right, value);
        }
        return node;
    }

    Node* searchNode(Node* root, int searchedValue){
        if(root == nullptr){
            cout << "Arvore vazia" << endl;
            return nullptr;
        }
    
        if(searchedValue == root->value){
            return root;
        } else if (searchedValue < root->value) {
            return searchNode(root->left, searchedValue);
        } else {
            return searchNode(root->right, searchedValue);
        }
    }

    Node* removeNode(Node* node, int value) {
        if (node == nullptr) {
            cout << "Nó não encontrado" << endl;
            return node;
        }
    
        if (value < node->value) {
            node->left = removeNode(node->left, value);
        } else if (value > node->value) {
            node->right = removeNode(node->right, value);
        } else {
            if (node->left == nullptr) {
                Node* temp = node->right;
                delete node;
                return temp;
            } else if (node->right == nullptr) {
                Node* temp = node->left;
                delete node;
                return temp;
            }
    
            // Encontrar o menor valor na subárvore direita
            Node* temp = node->right;
            while (temp->left != nullptr) {
                temp = temp->left;
            }
    
            // Substituir o valor do nó a ser removido pelo menor valor encontrado
            node->value = temp->value;
    
            // Remover o nó duplicado na subárvore direita
            node->right = removeNode(node->right, temp->value);
        }
        return node;
    }

    void printInOrder(Node* node) {
        if (node == nullptr) {
            return;
        }
        printInOrder(node->left);
        cout << node->value << " ";
        printInOrder(node->right);
    }
};

int main() {
    vector<int> values = {10, 5, 3, 7, 15, 12, 20, 17, 25, 30};
    
    Tree tree;

    for (int val : values) {
        tree.insert(val);
    }

    cout << "Árvore em ordem: ";
    tree.print();

    cout << "Removendo o valor 10" << endl;
    tree.remove(10);

    cout << "Árvore em ordem após remoção: ";
    tree.print();

    return 0;
}