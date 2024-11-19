#include <iostream>
#include <vector>
using namespace std;
#include <cmath>

// Shell Sort
// Time Complexity: O(n^2)
// Space Complexity: O(1)


void shellSort(vector<int>& arr){ // passando o endereço do vetor para que ele seja modificado diretamente
    
    // Variáveis auxiliares
    int i, j, aux;

    // Tamanho do Array
    int n = arr.size();

    // Para descobrirmos quantas varreduras, precisamos saber o valor de k.
    // utilizando a formula de Knuth: k = log(n+1)/log(3)
    float k = log(n+1)/log(3);
    
    // Dai vamos precisar arredondar o K.
    k = floor(k+0.5);

    // Agora, vamos calcular o H, que será a distância das varreduras.
    int h = (pow(3, k) - 1)/2;


};