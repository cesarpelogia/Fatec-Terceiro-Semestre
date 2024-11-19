#include<iostream>
#include<vector>
using namespace std;

struct Vector {

    vector<int> elements;

    Vector (){
        elements = vector<int>(30);
    }

    void printElements(){
        for(int i =0; i< elements.size(); ++i){
            cout << elements[i] << " ";
        }
        cout << endl;
    }

    void insertionSort (){
        int n = elements.size();
        int aux;

        for (int i = 1; i < n; i++){
            aux = elements[i];
            int j = i - 1;

            while (j >= 0 && elements[j] > aux){
                elements[j+1] = elements[j];
                j--;
            }
            
            elements[j + 1] = aux;
            printElements();
            cout << "\n";
        }
    }
};

int main(){

    Vector newVector;

    newVector.elements = {3, 12, 25, 7, 19, 1, 30, 14, 8, 23, 05, 16, 11, 9, 28, 17, 2, 20, 15, 6, 26, 22, 4, 18, 27, 10, 29, 13, 24, 21};
    cout << "Antes da Ordenação: ";
    cout << "\n";

    newVector.insertionSort();

    return 0;
}