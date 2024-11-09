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

private:
    Node* insertNode(Node* node, int val) {
        if (node == nullptr) {
            return new Node(val);
        }

        if (val < node->value) {
            node->left = insertNode(node->left, val);
        } else {
            node->right = insertNode(node->right, val);
        }
        return node;
    }
};

int main(){

    vector<int> values = {10, 5, 3, 5, 7, 10, 15, 12, 15, 20, 17, 20, 25, 30, 25};
    
    Tree tree;

    for (int val : values){
        tree.insert(val);
    }
    
    return 0;
}