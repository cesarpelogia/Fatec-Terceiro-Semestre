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

     
    float k = log(n+1)/log(3);
    
    // Dai vamos precisar arredondar o K.
    k = floor(k+0.5);

    // Agora, vamos calcular o H, que será a distância das varreduras com a formula de Knuth: h = (3^k - 1)/2
    int h = (pow(3, k) - 1)/2;

    // Enquanto H for maior que 0, vamos continuar o loop
    while (h>0){
        for(i=0; i<n; i++) {
            if(arr[i] > arr[i+h]){
                aux = arr[i];
                arr[i] = arr[i+h];
                arr[i+h] = aux;
                j = i-h;
                while(j>=0){
                    if(arr[j]>arr[j+h]){
                        aux = arr[j];
                        arr[j] = arr[j+h];
                        arr[j+h] = aux;
                        j = j-h;
                    }
                }  
            }
        }
    };