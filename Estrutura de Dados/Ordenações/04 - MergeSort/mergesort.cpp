#include <iostream>
#include <vector>
using namespace std;

void conquer(vector<int>& vec, int begin, int middle, int end){
    
    // Aqui, estabelecemos os tamanhos dos subvetores para ajudar na ordenação
    int n1 = middle - begin +1;
    int n2 = end - middle;

    // Criando dois vetores com os tamanhos pré estabelecidos
    vector<int> L(n1), R(n2);

    // Com esses dois vetores estabelecidos, vou substituir pelos valores do vetor original

    // Para L (subarray esquerdo)
    for (int i = 0; i < n1; i++) {
        L[i] = vec[begin + i];
    }

    // Para R (subarray direito)
    for (int j = 0; j < n2; j++) {
        R[j] = vec[middle + 1 + j];
    }

    // variáveis auxiliáres para o loop onde vamos realmente ordenar
    int i = 0;
    int j = 0;
    int k = begin;

    // Mescla os dois subvetores em ordem crescente
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            vec[k] = L[i];
            i++;
        } else {
            vec[k] = R[j];
            j++;
        }
        k++;
    }

    // Copia os elementos restantes do subvetor L, se houver
    while (i < n1) {
        vec[k] = L[i];
        i++;
        k++;
    }

    // Copia os elementos restantes do subvetor R, se houver
    while (j < n2) {
        vec[k] = R[j];
        j++;
        k++;
    }

};

void divide(vector<int>& vec, int begin, int end){
    if(begin < end){

        // Achando o meio.
        int middle = begin + (end - begin) / 2;

        // recursivando a parte da exquerda
        divide(vec, begin, middle);

        // recursivando a parte da deretcha
        divide(vec, middle+1, end);

        conquer(vec, begin, middle, end);
    }
};

int main() {
    vector<int> vec = {38, 27, 43, 3, 9, 82, 10};
    divide(vec, 0, vec.size() - 1);

    for (int i = 0; i < vec.size(); i++) {
        cout << vec[i] << " ";
    }
    cout << endl;

    return 0;
}