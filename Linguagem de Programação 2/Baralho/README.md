# Baralho de Cartas

Este projeto é uma atividade acadêmica da disciplina "Linguagem de Programação 2" da Fatec São José dos Campos Jansen Vidal, ministrada pelo professor Lucas Nadalete. O objetivo é implementar um baralho de cartas em Java, permitindo criar um baralho, embaralhar, retirar cartas e imprimir o estado atual do baralho.

## Estrutura de Pastas

O workspace contém as seguintes pastas:

- `src`: a pasta que contém os arquivos fonte
- `lib`: a pasta que contém as dependências
- `bin`: a pasta onde os arquivos compilados são gerados

## Classes

### App

A classe principal que executa o programa. Ela cria um baralho, embaralha, retira cartas e imprime o estado do baralho.

[App.java](src/App.java)

### Baralho

A classe que representa o baralho de cartas. Ela contém métodos para criar, embaralhar, retirar cartas e imprimir o baralho.

[Baralho.java](src/Baralho/Baralho.java)

### Carta

A classe que representa uma carta individual. Ela contém enums para os valores e naipes das cartas, além de métodos para obter e definir esses valores.

[Carta.java](src/Baralho/Carta.java)

### BaralhoVazioException

Uma exceção personalizada que é lançada quando se tenta retirar uma carta de um baralho vazio.

[BaralhoVazioException.java](src/Baralho/BaralhoVazioException.java)

## Como Executar

1. Compile o projeto:
    ```sh
    javac -d bin src/**/*.java
    ```

2. Execute o programa:
    ```sh
    java -cp bin App
    ```