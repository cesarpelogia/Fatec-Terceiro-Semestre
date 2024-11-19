// Inclusão da Biblioteca iostream, para realizar operações de entrada e saída de dados.
#include <iostream>

// Inclusão da Biblioteca vector, para manipular vetores dinâmicos (arrays que podem mudar de tamanho).
#include <vector>

// Permite utilizar os elementos do namespace std diretamente, como cout, cin e vector, 
// sem a necessidade de prefixá-los com 'std::'.
using namespace std;


struct Vector {

    vector<int> elements;

    Vector() {
        elements = vector<int>(10);
    }

    void printElements(){
        for(int i =0; i< elements.size(); ++i){
            cout << elements[i] << " ";
        }
        cout << endl;
    }

    void selectionSort() {
        // Pegando o tamanho do vetor para usar como limite nas iterações.
        int n = elements.size();
    
        // Iteração sobre os elementos do vetor para encontrar o menor elemento em cada iteração.
        for (int i = 0; i < n - 1; ++i) {
            // Definindo i como o índice do menor valor a ser comparado inicialmente.
            int minIndex = i;
    
            // Comparando o valor dos elementos subsequentes com o valor no índice minIndex.
            for (int j = i + 1; j < n; ++j) {
                if (elements[j] < elements[minIndex]) {
                    // Caso elements[j] seja menor que elements[minIndex], atualiza minIndex.
                    minIndex = j;
                }
            }
    
            // Troca os elementos na posição i e minIndex, se necessário.
            if( minIndex != i) {
                int temp = elements[i];
                elements[i] = elements[minIndex];
                elements[minIndex] = temp;

                cout << "Troca feita => ";
                printElements();
                
            }
        }
    }

};

int main(){

    Vector newVector;

    newVector.elements = {9, 4, 6, 3, 5, 8, 1, 7, 2, 0};
    cout << "Vetor antes da ordenação: ";
    newVector.printElements();
    cout <<"\n";

    newVector.selectionSort();

    cout << "Vetor após a ordenação: ";
    newVector.printElements();

    return 0;
}