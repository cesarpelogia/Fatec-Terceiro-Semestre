#include <iostream>
#include <vector>
#include <cmath>
#include <chrono>
#include <numeric>
#include <random>

using namespace std;
using namespace std::chrono;

// Shell Sort
// Time Complexity: O(n^2)
// Space Complexity: O(1)

void printVector(const vector<int>& vec) {
    int n = vec.size();
    cout << "[";
    for (int i = 0; i < 10 && i < n; i++) { // Imprime os primeiros 10 elementos
        cout << vec[i];
        if (i < 9 && i < n - 1) cout << ", ";
    }
    if (n > 10) cout << "... ";
    for (int i = max(0, n - 10); i < n; i++) { // Imprime os últimos 10 elementos
        cout << vec[i];
        if (i < n - 1) cout << ", ";
    }
    cout << "]";
}

void shellSort(vector<int>& arr){ // passando o endereço do vetor para que ele seja modificado diretamente
    
    // Variáveis auxiliares
    int i, j, aux;
    
    // Tamanho do Array
    int n = arr.size();
    
    // Calcula o valor inicial de k usando o logaritmo base 3
    float k = log(n + 1) / log(3);
    
    // Arredonda k para o inteiro mais próximo
    k = floor(k + 0.5);
    
    // Calcula o valor inicial de h usando a fórmula de Knuth: h = (3^k - 1) / 2
    int h = (pow(3, k) - 1) / 2;

    // Enquanto h for maior que 0, continuamos o loop
    while (h > 0) {
        // Percorremos o vetor
        for (i = h; i < n; i++) {
            aux = arr[i];
            j = i;
            // Loop para continuar trocando enquanto o valor na posição j for maior que o valor na posição j - h
            while (j >= h && arr[j - h] > aux) {
                arr[j] = arr[j - h];
                j -= h;
            }
            arr[j] = aux;
        }
        // Atualiza o valor de h para a próxima iteração
        h = (h - 1) / 3;
    }
};

int main() {

    // Vetor organizado (melhor caso)
    vector<int> sorted(1000000);
    iota (sorted.begin(), sorted.end(), 1);

    // Vetor randômico
    vector<int> random(1000000);
    random_device rd;
    mt19937 gen(rd());
    uniform_int_distribution<> dis(1, 1000000);

    for (int& num : random) {
        num = dis(gen); // Preenche o vetor com números aleatórios
    }

    // Vetor ao contrário (pior caso)
    vector<int> worst_case(1000000);
    iota(worst_case.rbegin(), worst_case.rend(), 1);
    

    // Melhor caso
    cout << "\nVetor no melhor caso antes: ";
    printVector(sorted);

    auto startBest = high_resolution_clock::now();
    shellSort(sorted);
    auto stopBest = high_resolution_clock::now();
    auto durationBest = duration_cast<microseconds>(stopBest - startBest);

    cout << "\nVetor no melhor caso depois: ";
    printVector(sorted);
    cout << "\nTempo de execução: " << durationBest.count() << " microsegundos." << endl;
    cout << "------------------------------------------------------------------" << endl;

    // Caso randômico
    cout << "\nVetor randômico: ";
    printVector(random);

    auto startRandom = high_resolution_clock::now();
    shellSort(random);
    auto stopRandom = high_resolution_clock::now();
    auto durationRandom = duration_cast<microseconds>(stopRandom - startRandom);

    cout << "\nVetor no caso aleatório depois: ";
    printVector(random);
    cout << "\nTempo de execução: " << durationRandom.count() << " microsegundos." << endl;
    cout << "------------------------------------------------------------------" << endl;

    // Pior caso
    cout << "\nVetor no pior caso antes: ";
    printVector(worst_case);

    auto startWorst = high_resolution_clock::now();
    shellSort(worst_case);
    auto stopWorst = high_resolution_clock::now();
    auto durationWorst = duration_cast<microseconds>(stopWorst - startWorst);

    cout << "\nVetor no pior caso depois: ";
    printVector(worst_case);
    cout << "\nTempo de execução: " << durationWorst.count() << " microsegundos." << endl;
    cout << "------------------------------------------------------------------" << endl;

    return 0;
}
